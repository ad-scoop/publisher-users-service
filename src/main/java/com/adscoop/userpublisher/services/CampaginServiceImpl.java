package com.adscoop.userpublisher.services;

import java.util.Collections;
import java.util.Map;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.entites.UserNode;
import com.google.inject.Inject;

import ratpack.exec.Promise;

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
	public Promise<Iterable<Campagin>> findCampaingsByUser(String token) {

		return  Promise.value(session.query(Campagin.class,"match (u:UserNode {token:{token}})-[:CAMPAGIN_HAS_USER]-(c:Campagin)-[:CAMPAGIN_HAS_BANNERS]->(b:Banner) return c,b,u", Collections.singletonMap("token",token)));

	}

	public Promise<Campagin> findCampaginsByUserTokenAndName(String campaginname, String token) {
		return Promise
				.value(session.queryForObject(Campagin.class, "match (u)-[:CAMPAGIN_HAS_USER]->(c) where u.token = '"
						+ token + "' and c.name='" + campaginname + "' return c", Collections.emptyMap()));
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
