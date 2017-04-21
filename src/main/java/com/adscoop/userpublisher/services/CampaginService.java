package com.adscoop.userpublisher.services;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Campagin;
import com.google.inject.Inject;

import ratpack.exec.Promise;

public class CampaginService {

	private Session session;

	@Inject
	public CampaginService(Session session) {
		this.session = session;
	}

	public Promise<Iterable<Campagin>> findCampaingsByToken(String token) {
		return Promise.value(session.loadAll(Campagin.class, new Filter("token", token)));
	}

	public void deleteCampagin(Long id) {
		session.delete(session.load(Campagin.class, id));
		session.clear();
	}

	public void updateCampagin(Campagin campagin) {
		session.save(campagin);
		session.clear();
	}

}
