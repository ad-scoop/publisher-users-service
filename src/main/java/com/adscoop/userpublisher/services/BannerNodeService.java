package com.adscoop.userpublisher.services;


<<<<<<< HEAD:src/main/java/com/userpublisher/services/BannerNodeService.java
=======

import com.adscoop.userpublisher.entites.BannerNode;

>>>>>>> 9f601f8e89d6b93e82d885f5993a327ddbb02cbc:src/main/java/com/adscoop/userpublisher/services/BannerNodeService.java
import java.util.List;
import java.util.Optional;

import com.userpublisher.entites.BannerNode;

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
