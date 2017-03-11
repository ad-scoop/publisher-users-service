package com.adscoop.userpublisher.handlers.banners;

import com.adscoop.userpublisher.entites.Banner;
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

		ctx.parse(fromJson(Banner.class)).then(bannerNode -> {
			String token = ctx.getRequest().getHeaders().get("token");
			String campaginname = ctx.getPathTokens().get("campaginname");
			Promise<Campagin> promise = campaginService.findCampaginsByUserTokenAndName(campaginname, token);
			promise.then(campagin -> {

			    if(campagin==null){
			        ctx.render(json("NO CAMPAGIN FOUND"));
                }else {

                    campagin.addBanner(bannerNode);
                    campaginService.updateCampagin(campagin);
                    ctx.render(json(campagin));
                }
			});

		});

	}
}
