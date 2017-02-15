package com.adscoop.userpublisher.services;

<<<<<<< HEAD:src/main/java/com/userpublisher/services/UserServiceImpl.java
=======

import com.adscoop.userpublisher.entites.UserNode;
import com.google.inject.Inject;
import org.neo4j.ogm.session.Session;

>>>>>>> 9f601f8e89d6b93e82d885f5993a327ddbb02cbc:src/main/java/com/adscoop/userpublisher/services/UserServiceImpl.java
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

    @Inject
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
