package com.adscoop.userpublisher.modules;

import java.io.IOException;

import org.neo4j.ogm.session.Session;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ServiceCommonConfigModule extends AbstractModule {

	@Override
	protected void configure() {
	}

	@Singleton
	@Provides
	public Session connectionSource(Config config) throws IOException {
		return new ConnectionSource(config).session();
	}

}
