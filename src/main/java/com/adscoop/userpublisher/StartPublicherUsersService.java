package com.adscoop.userpublisher;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.adscoop.userpublisher.chains.CampaginChain;
import com.adscoop.userpublisher.configurations.ConfigModule;
import com.adscoop.userpublisher.exceptions.PublisherUserException;
import com.adscoop.userpublisher.exceptions.ServerErrorHandler;
import com.adscoop.userpublisher.handlers.CORSHandler;
import com.adscoop.userpublisher.modules.Config;
import com.adscoop.userpublisher.modules.ServiceCommonConfigModule;

import ratpack.dropwizard.metrics.DropwizardMetricsConfig;
import ratpack.dropwizard.metrics.DropwizardMetricsModule;
import ratpack.dropwizard.metrics.MetricsWebsocketBroadcastHandler;
import ratpack.func.Action;
import ratpack.func.Function;
import ratpack.guice.Guice;
import ratpack.handling.Chain;
import ratpack.health.HealthCheckHandler;
import ratpack.registry.Registry;
import ratpack.rx.RxRatpack;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfigBuilder;

public class StartPublicherUsersService {

    public static void main(String... args) throws Exception {
        RxRatpack.initialize();

        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec
                .serverConfig(buildServerConfig())
                .registry(setUpRegistry())
                .handlers(setUpChain()));
    }

	private static Action<? super Chain> setUpChain() {
		return chain -> chain
		        		.all(CORSHandler.class)
		        		.prefix("publisher", userchain -> userchain.all(CORSHandler.class)
		        			.prefix("campagins", CampaginChain.class)
		        			.prefix("admin",
		                        admin -> admin
		                        	.get("health-check/:name", new HealthCheckHandler())
		                        	.get("metric-report", new MetricsWebsocketBroadcastHandler())));
	}

	private static Action<? super ServerConfigBuilder> buildServerConfig() {
		return sfb -> sfb.baseDir(BaseDir.find())
		        .props("ratpack.properties")
		        .yaml("database.yaml")
		        .require("/db", Config.class).require("/metrics", DropwizardMetricsConfig.class)
		        .env().development(false)
		        .sysProps()
		        .build();
	}

	private static Function<Registry, Registry> setUpRegistry() {
		return Guice.registry(bindingsSpec -> bindingsSpec
		        .module(ConfigModule.class).module(DropwizardMetricsModule.class, d -> {
		            d.getGraphite(   ).get().prefix("publisher-service").durationUnit(TimeUnit.SECONDS);
		            d.jmx(jmxConfig -> {
		                jmxConfig.enable(true);
		            });
		            d.console(  consoleConfig -> {
		                consoleConfig.enable(true);
		                consoleConfig.reporterInterval(Duration.ofSeconds(2));
		            });

		            d.webSocket( websocketConfig -> {
		               websocketConfig.reporterInterval(Duration.ofSeconds(2));
		            });
		            d.console();
		            d.jmx();
		        })
		        .module(ServiceCommonConfigModule.class).bind(PublisherUserException.class).bind(ServerErrorHandler.class));
	}

}
