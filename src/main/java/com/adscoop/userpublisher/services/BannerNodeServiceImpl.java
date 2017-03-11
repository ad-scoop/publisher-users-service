package com.adscoop.userpublisher.services;


import java.util.List;
import java.util.Optional;

import org.neo4j.ogm.session.Session;

import com.adscoop.userpublisher.entites.Banner;
import com.google.inject.Inject;



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
    public Optional<List<Banner>> getBannersByCampaginName(String campaginame) {
        return null;
    }

    @Override
    public Optional<List<Banner>> getBannerByUserToken(String token) {
        return null;
    }

    @Override
    public Optional<Banner> addBannerToCampagin(Banner bannerNode) {
        return null;
    }

    @Override
    public boolean deleteBannerNode(Banner bannerNode) {
        return false;
    }

    @Override
    public boolean updateBannerNode(Banner bannerNode) {
        return false;
    }

    @Override
    public boolean save(Banner bannerNode) {
        return false;
    }
    
}
