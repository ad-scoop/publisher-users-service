package com.adscoop.userpublisher.services;

import java.util.Optional;

import com.adscoop.userpublisher.entites.BannerSpace;
import ratpack.exec.Promise;

/**
 * Created by thokle on 19/02/2017.
 */
public interface BannerSpaceService {

    public Promise<Iterable<BannerSpace>> getReservedBannerSpaces(String reservedtoken) throws Exception;
}
