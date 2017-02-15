package com.userpublisher.services;


import java.util.Optional;

import com.userpublisher.entites.Campagin;

/**
 * Created by thokle on 23/01/2017.
 */
public interface CampaginService {



    Optional<Iterable<Campagin>> findCampaingsByUser(String  token) throws Exception;

    Optional<Campagin> findCampaginsByUserTokenAndName(String campaginname, String token) throws Exception;
    void updateCampagin(Campagin campagin);

    void deleteCampagin(Campagin campagin);


}
