package com.adscoop.userpublisher.services;

import java.util.Optional;

import com.adscoop.userpublisher.entites.BannerSpace;

/**
 * Created by thokle on 19/02/2017.
 */
public interface BannerSpaceService {

    public Optional<Iterable<BannerSpace>> getReservedBannerSpaces(String reservedtoken) throws Exception;
}
