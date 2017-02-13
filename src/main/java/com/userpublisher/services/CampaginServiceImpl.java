package com.userpublisher.services;

import com.adscoop.entiites.Campagin;
import com.adscoop.entiites.UserNode;
import com.google.inject.Inject;
import org.neo4j.ogm.session.Session;

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
    public Optional<UserNode> findUserByToken(String token) {
        return Optional.of(session.queryForObject(UserNode.class, "match (u:UserNode) where u.token='"+token+"'", Collections.EMPTY_MAP));
    }

    @Override
    public void createCampagin(UserNode userNode) {
         session.save(userNode);
    }

    @Override
    public void deleteCampagin(Campagin campagin) {
         session.delete(campagin);
    }

    @Override
    public void updateCampagin(Campagin campagin) {
         session.delete(campagin);
    }
}
