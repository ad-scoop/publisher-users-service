package com.adscoop.userpublisher.configurations;

import com.adscoop.userpublisher.chains.CampaginChain;
import com.adscoop.userpublisher.handlers.banners.AddBannerToCampaginHandler;
import com.adscoop.userpublisher.services.*;
import com.adscoop.userpublisher.chains.BannerNodeChain;
import com.adscoop.userpublisher.handlers.campagin.CreateCampaginHandler;
import com.google.inject.AbstractModule;

/**
 * Created by thokle on 25/01/2017.
 */
public class ConfigModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(BannerNodeChain.class).asEagerSingleton();
        bind(CampaginChain.class).asEagerSingleton();



        bind(CampaginService.class).to(CampaginServiceImpl.class).asEagerSingleton();
        bind(BannerNodeService.class).to(BannerNodeServiceImpl.class).asEagerSingleton();
        bind(UserSevice.class).to(UserServiceImpl.class).asEagerSingleton();

        bind(CreateCampaginHandler.class).asEagerSingleton();
        bind(AddBannerToCampaginHandler.class).asEagerSingleton();

    }
}
