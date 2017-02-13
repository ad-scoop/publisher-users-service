package com.userpublisher.services;


import com.google.inject.Inject;
import com.userpublisher.entites.Campagin;
import org.neo4j.ogm.session.Session;

import java.util.Collections;
import java.util.Optional;

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
    public Optional<Campagin> findCampaingByUser(String token) throws Exception {
        try {
            return Optional.ofNullable(session.queryForObject(Campagin.class,"", Collections.EMPTY_MAP));
        }catch (Exception e){
             throw new Exception(e);
        }
    }


    public Optional<Iterable> findCampaginsByUserTokenAndName(String campaginname, String token) throws Exception {
        try{
            return Optional.ofNullable(session.query(Campagin.class, "",Collections.EMPTY_MAP));
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public void deleteCampagin(Campagin campagin) {

    }

    @Override
    public void updateCampagin(Campagin campagin) {
         session.delete(campagin);
    }
}
