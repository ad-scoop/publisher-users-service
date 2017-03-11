package com.adscoop.userpublisher.services;

import java.util.Collections;
import java.util.Optional;

import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.BannerSpace;
import com.google.inject.Inject;

/**
 * Created by thokle on 19/02/2017.
 */
public class BannerSpaceServiceImpl implements BannerSpaceService {

	private Session session;

	@Inject
	public BannerSpaceServiceImpl(Session session) {
		this.session = session;
	}

	@Override
	public Optional<Iterable<BannerSpace>> getReservedBannerSpaces(String reservedtoken) {
		return Optional.ofNullable(session.query(BannerSpace.class,
				"match (b) where  a.reservedids IN [" + reservedtoken + "] return b ", Collections.emptyMap()));
	}
}
