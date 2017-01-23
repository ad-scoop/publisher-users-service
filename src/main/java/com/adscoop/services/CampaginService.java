package com.adscoop.services;

import com.adscoop.entiites.BannerNode;
import com.adscoop.entiites.Campagin;

import java.util.List;
import java.util.Optional;

/**
 * Created by thokle on 23/01/2017.
 */
public interface CampaginService {



    Campagin createCampagin(Campagin campagin);

    boolean DeleteCampagin(Campagin campagin);

    boolean UpdateCampagin(Campagin campagin);



}
