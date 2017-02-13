package com.userpublisher.services;



import com.userpublisher.entites.BannerNode;

import java.util.List;
import java.util.Optional;

/**
 * Created by thokle on 23/01/2017.
 */
public interface BannerNodeService {



    Optional<List<BannerNode>> getBannersByCampaginName(String campaginame);

    Optional<List<BannerNode>> getBannerByUserToken(String token);



    Optional<BannerNode> addBannerToCampagin(BannerNode bannerNode);

    boolean deleteBannerNode(BannerNode bannerNode);

    boolean updateBannerNode(BannerNode bannerNode);

    boolean save(BannerNode bannerNode);



}
