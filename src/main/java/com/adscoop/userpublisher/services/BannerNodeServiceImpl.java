package com.adscoop.userpublisher.services;

<<<<<<< HEAD:src/main/java/com/userpublisher/services/BannerNodeServiceImpl.java
=======
import com.adscoop.userpublisher.entites.BannerNode;
import com.google.inject.Inject;
import org.neo4j.ogm.session.Session;

>>>>>>> 9f601f8e89d6b93e82d885f5993a327ddbb02cbc:src/main/java/com/adscoop/userpublisher/services/BannerNodeServiceImpl.java
import java.util.List;
import java.util.Optional;

import org.neo4j.ogm.session.Session;

import com.google.inject.Inject;
import com.userpublisher.entites.BannerNode;

/**
 * Created by thokle on 27/01/2017.
 */
public class BannerNodeServiceImpl implements BannerNodeService {

    private Session session;


    @Inject
    public BannerNodeServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public Optional<List<BannerNode>> getBannersByCampaginName(String campaginame) {
        return null;
    }

    @Override
    public Optional<List<BannerNode>> getBannerByUserToken(String token) {
        return null;
    }

    @Override
    public Optional<BannerNode> addBannerToCampagin(BannerNode bannerNode) {
        return null;
    }

    @Override
    public boolean deleteBannerNode(BannerNode bannerNode) {
        return false;
    }

    @Override
    public boolean updateBannerNode(BannerNode bannerNode) {
        return false;
    }

    @Override
    public boolean save(BannerNode bannerNode) {
        return false;
    }
}
