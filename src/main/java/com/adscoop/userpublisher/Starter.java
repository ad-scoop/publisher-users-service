package com.adscoop.userpublisher;

import com.adscoop.userpublisher.chains.CampaginChain;
import com.adscoop.userpublisher.modules.Config;
import com.adscoop.userpublisher.chains.BannerNodeChain;

import com.adscoop.userpublisher.configurations.ConfigModule;

import com.adscoop.userpublisher.modules.ServiceCommonConfigModule;
import ratpack.guice.Guice;
import ratpack.rx.RxRatpack;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Created by thokle on 25/01/2017.
 */
public class Starter {


    public static void main(String ... args) throws Exception {
        RxRatpack.initialize();

        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec.serverConfig(sfb -> sfb.baseDir(BaseDir.find()).props("ratpack.properties").yaml("database.yaml").require("/db", Config.class).env().sysProps().build())
                .registry(Guice.registry(bindingsSpec -> bindingsSpec.module(ConfigModule.class).module(ServiceCommonConfigModule.class))).
                        handlers(chain -> chain.prefix("banners", BannerNodeChain.class).prefix("campagin", CampaginChain.class)));


    }
}