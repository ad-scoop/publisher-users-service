package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class UpdateCampaginHandler implements Handler {

	private ExtractUser extractUser;
	private UserSevice userSevice;
	private CampaginService campaginService;

	@Inject
	public UpdateCampaginHandler(UserSevice userSevice, CampaginService campaginService) {
		this.userSevice = userSevice;
		this.campaginService = campaginService;
		this.extractUser = new ExtractUser(userSevice);
	}

	@Override
	public void handle(Context ctx) throws Exception {
		this.extractUser.handle(ctx, user -> {
			ctx.parse(fromJson(Campagin.class)).then(campagin -> {
				campagin.setUserNode(user);
				campaginService.updateCampagin(campagin);
				user.getCampagins().add(campagin);
				userSevice.saveOrUpate(user);
				ctx.render(json("update ok"));
			});
		}); 
	}

}
