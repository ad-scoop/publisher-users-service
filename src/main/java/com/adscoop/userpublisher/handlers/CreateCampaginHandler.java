package com.adscoop.userpublisher.handlers;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class CreateCampaginHandler implements Handler {

	private CampaginService campaginService;

	@Inject
	public CreateCampaginHandler(CampaginService campaginService) {
		this.campaginService = campaginService;
	}

	@Override
	public void handle(Context ctx) throws Exception {
		ctx.parse(fromJson(Campagin.class)).then(campagin -> {
			campagin.setToken(ctx.getRequest().getHeaders().get("token"));
			campaginService.updateCampagin(campagin);
			ctx.render(json("created ok"));
		});
	}

}

