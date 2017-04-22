package com.adscoop.userpublisher.handlers;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;

import ratpack.handling.Context;

public class CreateCampaginHandler extends AbstractTokenHandler {

	private CampaginService campaginService;

	@Inject
	public CreateCampaginHandler(CampaginService campaginService) {
		this.campaginService = campaginService;
	}

	@Override
	protected void handleWithToken(Context ctx, String token) {
		ctx.parse(fromJson(Campagin.class)).then(campagin -> {
			campagin.setToken(token);
			campaginService.updateCampagin(campagin);
			ctx.render(json("created ok"));
		});
	}

}

