package com.adscoop.userpublisher.services;


<<<<<<< HEAD:src/main/java/com/userpublisher/services/CampaginService.java
=======
import com.adscoop.userpublisher.entites.Campagin;

>>>>>>> 9f601f8e89d6b93e82d885f5993a327ddbb02cbc:src/main/java/com/adscoop/userpublisher/services/CampaginService.java
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
