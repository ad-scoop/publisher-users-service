package com.adscoop.userpublisher.services;

import com.adscoop.userpublisher.entites.WebSite;
import com.google.inject.Inject;
import org.neo4j.ogm.session.Session;
import ratpack.exec.Promise;

import java.util.Collections;

/**
 * Created by thokle on 04/03/2017.
 */
public class WebSiteServiceImpl implements WebSiteService {

	private Session session;

	@Inject
	public WebSiteServiceImpl(Session session) {
		this.session = session;
	}

	@Override
	public Promise<WebSite> findById(Long id) {
		return Promise.value(session.queryForObject(WebSite.class,
				"match (b:WebiteNode) where ID(b)=" + id + " return b", Collections.emptyMap()));
	}

}
