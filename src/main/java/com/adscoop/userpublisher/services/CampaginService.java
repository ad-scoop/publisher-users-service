package com.adscoop.userpublisher.services;



import com.adscoop.userpublisher.entites.Campagin;
import ratpack.exec.Promise;

import java.util.Optional;


/**
 * Created by thokle on 23/01/2017.
 */
public interface CampaginService {



   Promise<Iterable<Campagin>> findCampaingsByUser(String  token) throws Exception;

    Promise<Campagin> findCampaginsByUserTokenAndName(String campaginname, String token) throws Exception;
    void updateCampagin(Campagin campagin);

    void deleteCampagin(Campagin campagin);




}
