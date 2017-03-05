package com.adscoop.userpublisher.handlers.banners;

import com.adscoop.userpublisher.entites.BannerNode;
import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Optional;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

/**
 * Created by kleistit on 13/02/2017.
 */
public class AddBannerToCampaginHandler implements Handler {
    CampaginService campaginService;


@Inject
    public AddBannerToCampaginHandler(CampaginService campaginService) {
        this.campaginService = campaginService;

    }

    @Override
    public void handle(Context ctx) throws Exception {

        ctx.parse(fromJson(BannerNode.class)).then(bannerNode -> {
    String token = ctx.getRequest().getHeaders().get("token");
    String campaginname = ctx.getPathTokens().get("campaginname");
        Promise<Campagin> campagin =  campaginService.findCampaginsByUserTokenAndName(campaginname,token);

      campagin.then( campagin1 -> {
            BannerNode banner = new BannerNode();


            banner.setDomain(bannerNode.getDomain());
            banner.setHeight(bannerNode.getHeight());




            banner.setLenght(bannerNode.getLenght());
            banner.setPictureUrl(bannerNode.getPictureUrl());
            banner.setPositionSiteL(bannerNode.getPositionSiteL());
            banner.setPositionSiteM(bannerNode.getPositionSiteM());



            banner.setUrl(bannerNode.getUrl());
            banner.setFiletype(bannerNode.getFiletype());


            campagin1.addBanner(banner);


            campaginService.updateCampagin(campagin1);
            ctx.render(json(campagin1));

        });

        });



            }
}
