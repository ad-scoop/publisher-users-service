package com.userpublisher.services;

import java.util.Collections;
import java.util.Optional;

import org.neo4j.ogm.session.Session;

import com.userpublisher.entites.UserNode;

/**
 * Created by kleistit on 13/02/2017.
 */
public class UserServiceImpl implements UserSevice

{
    Session session;

    public UserServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<UserNode> findUserByToken(String token) {

        return Optional.ofNullable(session.queryForObject(UserNode.class, "match (u) where u.token='"+token+"' return u", Collections.EMPTY_MAP));
    }


    @Override
    public void saveOrUpate(UserNode userNode) {
        session.save(userNode);
    }
}
