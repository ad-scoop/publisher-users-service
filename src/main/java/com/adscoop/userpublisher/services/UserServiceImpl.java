package com.adscoop.userpublisher.services;

import java.util.Collections;

import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.UserNode;
import com.google.inject.Inject;

import ratpack.exec.Promise;

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
	public Promise<UserNode> findUserByToken(String token) {
		return Promise.value(session.queryForObject(UserNode.class, "match (u) where u.token='" + token + "' return u",
				Collections.emptyMap()));
	}

	@Override
	public void saveOrUpate(UserNode userNode) {
		session.save(userNode);
	}
}
