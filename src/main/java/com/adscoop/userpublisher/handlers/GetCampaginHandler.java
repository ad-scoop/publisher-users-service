package com.adscoop.userpublisher.handlers;

import static ratpack.jackson.Jackson.json;
import static ratpack.rx.RxRatpack.*;

import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;

public class GetCampaginHandler implements Handler {

	private CampaginService campaginService;

	@Inject
	public GetCampaginHandler(CampaginService campaginService) {
		this.campaginService = campaginService;
	}

	@Override
	public void handle(Context ctx) throws Exception {
		String token = ctx.getRequest().getHeaders().get("token");
		if (token != null && !token.isEmpty()) {
			observeEach(campaginService.findCampaingsByToken(token))
				.toList()
				.forEach(campagins -> ctx.render(json(campagins)));
		} else {
			ctx.getResponse().status(Status.of(406));
			ctx.render(json("no token"));
		}

	}
}
