package com.adscoop.userpublisher.services;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.handlers.Const;
import com.google.inject.Inject;

import ratpack.exec.Promise;

public class CampaginService {

	private Session session;

	@Inject
	public CampaginService(Session session) {
		this.session = session;
	}

	public Promise<Iterable<Campagin>> findCampaingsByToken(String token) {
		return Promise.value(session.loadAll(Campagin.class, new Filter(Const.Headers.TOKEN, token)));
	}

	public void deleteCampagin(Long id) {
		Campagin campagin = session.load(Campagin.class, id);
		if (campagin != null) {
			session.delete(campagin);
		}
		session.clear();
	}

	public void updateCampagin(Campagin campagin) {
		session.save(campagin);
		session.clear();
	}

}
