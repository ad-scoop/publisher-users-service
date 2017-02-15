package com.adscoop.userpublisher.services;


<<<<<<< HEAD:src/main/java/com/userpublisher/services/CampaginServiceImpl.java
=======
import com.google.inject.Inject;
import com.adscoop.userpublisher.entites.Campagin;
import org.neo4j.ogm.session.Session;

>>>>>>> 9f601f8e89d6b93e82d885f5993a327ddbb02cbc:src/main/java/com/adscoop/userpublisher/services/CampaginServiceImpl.java
import java.util.Collections;
import java.util.Optional;

import org.neo4j.ogm.session.Session;

import com.google.inject.Inject;
import com.userpublisher.entites.Campagin;

/**
 * Created by thokle on 27/01/2017.
 */
public class CampaginServiceImpl implements CampaginService {


    private Session session;


    @Inject
    public CampaginServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Iterable<Campagin>> findCampaingsByUser(String token) throws Exception {
        try {
            return Optional.ofNullable(session.query(Campagin.class,"", Collections.EMPTY_MAP));
        }catch (Exception e){
             throw new Exception(e);
        }
    }


    public Optional<Campagin> findCampaginsByUserTokenAndName(String campaginname, String token) throws Exception {
        try{
            return Optional.ofNullable(session.queryForObject(Campagin.class, "",Collections.EMPTY_MAP));
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public void deleteCampagin(Campagin campagin) {
        if(session.detachNodeEntity(campagin.getId())){
            session.delete(campagin);
        }
    }

    @Override
    public void updateCampagin(Campagin campagin) {
         session.save(campagin);
    }
}
