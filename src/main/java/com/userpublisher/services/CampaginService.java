package com.userpublisher.services;

import com.adscoop.entiites.Campagin;
import com.adscoop.entiites.UserNode;

import java.util.Optional;

/**
 * Created by thokle on 23/01/2017.
 */
public interface CampaginService {
    Optional<UserNode> findUserByToken(String token);

    void createCampagin(UserNode campagin);

    void deleteCampagin(Campagin campagin);

    void updateCampagin(Campagin campagin);



}
