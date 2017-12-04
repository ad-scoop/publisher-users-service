package com.adscoop.userpublisher.services;

import com.adscoop.userpublisher.entites.Campagin;
import com.google.inject.Inject;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import ratpack.exec.Promise;

import java.util.Collections;

public class CampaginService {

    private Session session;

    @Inject
    public CampaginService(Session session) {
        this.session = session;
    }

    public Promise<Iterable<Campagin>> findByToken(String token) {
        return Promise.async(downstream -> {
            Iterable<Campagin> campagins   = session.loadAll(Campagin.class, new Filter("token", ComparisonOperator.EQUALS, token), 3);

            downstream.success(campagins);
        });

    }

    public void deleteCampagin(Long id) {

        Campagin campagin = session.queryForObject(Campagin.class, "match (c:Campagin) where ID(c)={id} return c", Collections.singletonMap("id", id));
        session.delete(campagin);
        session.clear();
    }

    public void updateCampagin(Campagin campagin) {
        session.save(campagin);
        session.clear();
    }

}
