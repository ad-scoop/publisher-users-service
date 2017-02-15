package com.userpublisher.services;

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
