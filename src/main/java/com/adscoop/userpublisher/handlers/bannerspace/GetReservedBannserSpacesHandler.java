package com.adscoop.userpublisher.handlers.bannerspace;

import com.adscoop.userpublisher.entites.BannerSpace;
import com.adscoop.userpublisher.services.BannerSpaceService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ratpack.jackson.Jackson.json;

/**
 * Created by thokle on 19/02/2017.
 */
public class GetReservedBannserSpacesHandler implements Handler {

    private BannerSpaceService bannerSpaceService;
    private  List<BannerSpace> bannerSpaces;
    @Inject
    public GetReservedBannserSpacesHandler(BannerSpaceService bannerSpaceService) {
        this.bannerSpaceService = bannerSpaceService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token  = ctx.getRequest().getHeaders().get("token");

        if(!token.isEmpty()){


           Optional<Iterable<BannerSpace>>  bannerSpaces = bannerSpaceService.getReservedBannerSpaces(token);

           if(bannerSpaces.isPresent()){


               bannerSpaces.get().iterator().forEachRemaining( bannerSpace ->  {

                  addBannerSpaceToList(bannerSpace);

               });

               ctx.render(json(getBannerSpaces()));

           }



        }
    }


    private void addBannerSpaceToList(BannerSpace bannerSpace){
        bannerSpaces.add(bannerSpace);

    }

    public List<BannerSpace> getBannerSpaces() {
        return bannerSpaces;
    }

    public void setBannerSpaces(List<BannerSpace> bannerSpaces) {
        this.bannerSpaces = bannerSpaces;
    }
}
