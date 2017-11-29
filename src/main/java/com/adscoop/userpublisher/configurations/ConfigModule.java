
package com.adscoop.userpublisher.configurations;

import com.adscoop.userpublisher.chains.CampaginChain;
import com.adscoop.userpublisher.handlers.CORSHandler;
import com.adscoop.userpublisher.handlers.CreateCampaginHandler;
import com.adscoop.userpublisher.handlers.DeleteCampaginHandler;
import com.adscoop.userpublisher.handlers.GetCampaginHandler;
import com.adscoop.userpublisher.handlers.UpdateCampaginHandler;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.AbstractModule;

public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CampaginChain.class).asEagerSingleton();
		bind(CampaginService.class).asEagerSingleton();
		
		bind(CreateCampaginHandler.class).asEagerSingleton();
		bind(DeleteCampaginHandler.class).asEagerSingleton();
		bind(UpdateCampaginHandler.class).asEagerSingleton();
		bind(GetCampaginHandler.class).asEagerSingleton();
		
		bind(CORSHandler.class).asEagerSingleton();
	}

}
