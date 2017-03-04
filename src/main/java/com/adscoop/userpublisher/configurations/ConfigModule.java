
package com.adscoop.userpublisher.configurations;

import com.adscoop.userpublisher.chains.BannerNodeChain;
import com.adscoop.userpublisher.chains.CampaginChain;
import com.adscoop.userpublisher.exceptions.PublisherUserException;
import com.adscoop.userpublisher.handlers.banners.AddBannerToCampaginHandler;
import com.adscoop.userpublisher.handlers.bannerspace.GetReservedBannserSpacesHandler;
import com.adscoop.userpublisher.handlers.campagin.AddWebSiteToCampaginHandler;
import com.adscoop.userpublisher.handlers.campagin.CreateCampaginHandler;
import com.adscoop.userpublisher.handlers.campagin.GetCampaginHandler;
import com.adscoop.userpublisher.services.*;
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
        bind(BannerSpaceService.class).to(BannerSpaceServiceImpl.class).asEagerSingleton();

        bind(CreateCampaginHandler.class).asEagerSingleton();

        bind(AddBannerToCampaginHandler.class).asEagerSingleton();
        bind(GetReservedBannserSpacesHandler.class).asEagerSingleton();
        bind(PublisherUserException.class).asEagerSingleton();
        bind(GetCampaginHandler.class).asEagerSingleton();
        bind(AddWebSiteToCampaginHandler.class).asEagerSingleton();

    }
}
