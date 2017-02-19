package com.adscoop.userpublisher.handlers.banners;

import com.adscoop.userpublisher.entites.BannerNode;
import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Optional;

import static ratpack.jackson.Jackson.fromJson;

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
        Optional<Campagin> campagin =  campaginService.findCampaginsByUserTokenAndName(campaginname,token);

        if(campagin.isPresent()){
            BannerNode banner = new BannerNode();
            bannerNode.getCategories().stream().filter(f -> f !=null).forEach( s ->{
                banner.getCategories().add(s);

            });

            banner.setDomain(bannerNode.getDomain());
            banner.setHeight(bannerNode.getHeight());

            banner.getLabels().stream().filter(f -> f !=null).forEach( s ->  {
                banner.getLabels().add(s);

            });


            banner.setLenght(bannerNode.getLenght());
            banner.setPictureUrl(bannerNode.getPictureUrl());
            banner.setPositionSiteL(bannerNode.getPositionSiteL());
            banner.setPositionSiteM(bannerNode.getPositionSiteM());

            bannerNode.getTargetGroupses().stream().filter(f -> f !=null ).forEach(tg -> {
                banner.getTargetGroupses().add(tg);
            });


            banner.setUrl(bannerNode.getUrl());



            campagin.get().addBanner(banner);


            campaginService.updateCampagin(campagin.get());
        }


        });



            }
}
