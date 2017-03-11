package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.services.CampaginService;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class DeleteCampaginHandler implements Handler {

	private ExtractUser extractUser;
	private CampaginService campaginService;

	@Inject
	public DeleteCampaginHandler(UserSevice userSevice, CampaginService campaginService) {
		this.campaginService = campaginService;
		this.extractUser = new ExtractUser(userSevice);
	}

	@Override
	public void handle(Context ctx) throws Exception {
		this.extractUser.handle(ctx, (user) -> {
			campaginService.deleteCampagin(Long.parseLong(ctx.getRequest().getQueryParams().get("id")));
			ctx.render(json("delete ok"));
		});
	}

}
