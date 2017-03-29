package com.adscoop.userpublisher.services;


import com.adscoop.userpublisher.entites.Campagin;
import com.google.inject.Inject;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.exec.Promise;

import java.util.*;

/**
 * Created by thokle on 27/01/2017.
 */


public class CampaginServiceImpl implements CampaginService {
private  static Logger logger = LoggerFactory.getLogger(CampaginServiceImpl.class);
    private Session session;


    @Inject
    public CampaginServiceImpl(Session session ) {
        this.session = session;

    }

    @Override
    public Promise<Iterable<Map<String, Object>>> findCampaingsByUser(String token) {
            return  Promise.value(session.query("MATCH (u:UserNode {token:{token}} )-[:CAMPAGIN_HAS_USER]->(c:Campagin)-[:CAMPAGIN_HAS_BANNERS]->(b:Banner) return  c as Campagin, b as Banner" , Collections.singletonMap("token", token)).queryResults());
    }

    public Promise<Campagin> findCampaginsByUserTokenAndName(String campaginname, String token) {
        return Promise
                .value(session.queryForObject(Campagin.class, "MATCH (u)-[:CAMPAGIN_HAS_USER]->(c) WHERE u.token = '"
                        + token + "' AND c.name='" + campaginname + "' RETURN c", Collections.emptyMap()));
    }

    @Override
    public void deleteCampagin(Long id) {
        session.delete(session.load(Campagin.class, id));
        session.clear();
    }

    @Override
    public void updateCampagin(Campagin campagin) {
        session.save(campagin);
        session.clear();
    }

}
