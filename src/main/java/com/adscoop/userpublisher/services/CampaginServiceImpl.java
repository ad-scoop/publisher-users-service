package com.adscoop.userpublisher.services;

import com.google.inject.Inject;
import com.adscoop.userpublisher.entites.Campagin;
import org.neo4j.ogm.session.Session;
import ratpack.exec.Promise;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by thokle on 27/01/2017.
 */
public class CampaginServiceImpl implements CampaginService {



    private Session session;


    @Inject
    public CampaginServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public Promise<Iterable<Campagin>> findCampaingsByUser(String token) throws Exception {
        try {
            return Promise.value(session.query(Campagin.class,"match (u:UserNode)-[:CAMPAGIN_HAS_USER]->(c:Campagin) where u.token='"+token+"' return c", Collections.emptyMap()));
        }catch (Exception e){
             throw new Exception(e);
        }
    }


    public Promise<Campagin> findCampaginsByUserTokenAndName(String campaginname, String token) throws Exception {
        try{

            return Promise.value(session.queryForObject(Campagin.class, "match (u)-[:CAMPAGIN_HAS_USER]->(c) where u.token = '"+token +"' and c.campagin_name='"+campaginname+"' return c", Collections.emptyMap()));
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public void deleteCampagin(Campagin campagin) {
        if(session.detachNodeEntity(campagin.getId())){
            session.delete(campagin);
        }
    }

    @Override
    public void updateCampagin(Campagin campagin) {
        session.save(campagin);
    }
}
