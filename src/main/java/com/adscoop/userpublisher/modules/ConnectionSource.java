package com.adscoop.userpublisher.modules;

import java.io.IOException;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import com.google.inject.Inject;


public class ConnectionSource {



    SessionFactory sessionFactory;



@Inject
    public ConnectionSource(Config config) throws  IOException {
    sessionFactory = new SessionFactory(configuration(config),"com.adscoop.userservice.entites");
        configuration(config);
    }

    private Configuration configuration(Config config) throws IOException {
        Configuration configuration = new Configuration();
     configuration.driverConfiguration().setDriverClassName(config.getDriver_class_name()).setCredentials(config.getUsername(),config.getPassword()).setURI(config.getNeo4Url());
        return configuration;

    }

    public Session session() {

        return sessionFactory.openSession();

    }







}
