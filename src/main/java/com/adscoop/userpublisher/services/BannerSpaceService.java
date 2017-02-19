package com.adscoop.userpublisher.services;

import com.adscoop.userpublisher.entites.BannerSpace;

import java.util.Optional;

/**
 * Created by thokle on 19/02/2017.
 */
public interface BannerSpaceService {

    public Optional<Iterable<BannerSpace>> getReservedBannerSpaces(String reservedtoken) throws Exception;
}
