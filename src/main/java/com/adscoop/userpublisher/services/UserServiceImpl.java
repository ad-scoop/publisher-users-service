package com.adscoop.userpublisher.services;



import com.adscoop.userpublisher.entites.UserNode;
import com.google.inject.Inject;
import org.neo4j.ogm.session.Session;

import java.util.Collections;
import java.util.Optional;



/**
 * Created by kleistit on 13/02/2017.
 */
public class UserServiceImpl implements UserSevice

{
    Session session;

    @Inject
    public UserServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<UserNode> findUserByToken(String token) throws Exception {
        try {
            return Optional.ofNullable(session.queryForObject(UserNode.class, "match (u) where u.token='" + token + "' return u", Collections.EMPTY_MAP));
        } catch (Exception e) {
            throw new Exception(e.getCause());
        }
    }


    @Override
    public void saveOrUpate(UserNode userNode) {
        session.save(userNode);
    }
}
