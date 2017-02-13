package com.userpublisher.configurations;

import com.userpublisher.chains.BannerNodeChain;
import com.userpublisher.chains.CampaginChain;
import com.userpublisher.services.BannerNodeService;
import com.userpublisher.services.BannerNodeServiceImpl;
import com.userpublisher.services.CampaginService;
import com.userpublisher.services.CampaginServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Created by thokle on 25/01/2017.
 */
public class ConfigModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(BannerNodeChain.class).asEagerSingleton();
        bind(CampaginChain.class).asEagerSingleton();
        bind(CampaginService.class).to(CampaginServiceImpl.class);
        bind(BannerNodeService.class).to(BannerNodeServiceImpl.class);
    }
}
