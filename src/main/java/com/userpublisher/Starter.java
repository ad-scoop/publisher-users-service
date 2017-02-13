package com.userpublisher;

import com.userpublisher.chains.BannerNodeChain;
import com.userpublisher.chains.CampaginChain;
import com.adscoop.com.adscoop.services.AuthConfigurableModule;
import com.userpublisher.configurations.ConfigModule;
import com.adscoop.services.neo4j.connection.Config;
import com.adscoop.services.neo4j.connection.ServiceCommonConfigModule;
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

        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec.serverConfig(sfb -> sfb.baseDir(BaseDir.find()).props("ratpack.properties").yaml("database.yaml").require("/db", Config.class).env().port(2828).sysProps().build())
                .registry(Guice.registry(bindingsSpec -> bindingsSpec.module(ConfigModule.class).module(ServiceCommonConfigModule.class).module(AuthConfigurableModule.class))).
                        handlers(chain -> chain.prefix("bannerNode", BannerNodeChain.class).prefix("campagin", CampaginChain.class)));


    }
}
