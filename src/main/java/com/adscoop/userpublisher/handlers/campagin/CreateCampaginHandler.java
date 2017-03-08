package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.entites.BannerNode;
import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Created by thokle on 27/01/2017.
 */
public class CreateCampaginHandler implements Handler {

	private ExtractUser extractUser;
	private UserSevice userSevice;

	@Inject
	public CreateCampaginHandler(UserSevice userSevice) {
		this.userSevice = userSevice;
		this.extractUser = new ExtractUser(userSevice);
	}

	@Override
	public void handle(Context ctx) throws Exception {
		this.extractUser.handle(ctx, user -> { 
			ctx.parse(fromJson(Campagin.class)).then(campagin -> {
				Campagin campagin1 = new Campagin();
				campagin.getBanners().stream().filter(f -> f != null).iterator().forEachRemaining( bannerNode -> {
					BannerNode bn = new BannerNode();
					bn.setPicture(bannerNode.getPicture());
					campagin1.addBanner(bn);
				});

				user.addCampagin(campagin1);
				userSevice.saveOrUpate(user);
				ctx.render(json("created ok"));
			});
		}); 
	}

}
