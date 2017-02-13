package com.userpublisher.services;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.userpublisher.entites.UserNode;
import org.neo4j.ogm.session.Session;

import java.util.Collections;
import java.util.Optional;

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
