package com.adscoop.userpublisher.services;




import com.adscoop.userpublisher.entites.Banner;

import java.util.List;
import java.util.Optional;



/**
 * Created by thokle on 23/01/2017.
 */
public interface BannerNodeService {



    Optional<List<Banner>> getBannersByCampaginName(String campaginame);

    Optional<List<Banner>> getBannerByUserToken(String token);



    Optional<Banner> addBannerToCampagin(Banner bannerNode);

    boolean deleteBannerNode(Banner bannerNode);

    boolean updateBannerNode(Banner bannerNode);

    boolean save(Banner bannerNode);



}
