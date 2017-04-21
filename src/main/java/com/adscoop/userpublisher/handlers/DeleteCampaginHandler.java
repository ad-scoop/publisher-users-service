package com.adscoop.userpublisher.handlers;

import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class DeleteCampaginHandler implements Handler {

	private CampaginService campaginService;

	@Inject
	public DeleteCampaginHandler(CampaginService campaginService) {
		this.campaginService = campaginService;
	}

	@Override
	public void handle(Context ctx) throws Exception {
		campaginService.deleteCampagin(Long.parseLong(ctx.getRequest().getQueryParams().get("id")));
		ctx.render(json("delete ok"));
	}

}
