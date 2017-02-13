package com.userpublisher.services;


import com.userpublisher.entites.Campagin;

import java.util.Optional;

/**
 * Created by thokle on 23/01/2017.
 */
public interface CampaginService {



    Optional<Campagin> findCampaingByUser(String  token) throws Exception;

    Optional<Iterable> findCampaginsByUserTokenAndName(String campaginname, String token) throws Exception;
    void updateCampagin(Campagin campagin);

    void deleteCampagin(Campagin campagin);


}
