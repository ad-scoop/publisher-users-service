package com.adscoop.userpublisher.handlers;

import static ratpack.jackson.Jackson.json;
import static ratpack.rx.RxRatpack.observeEach;

import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;

import ratpack.handling.Context;

public class GetCampaginHandler extends AbstractTokenHandler {

	private CampaginService campaginService;

	@Inject
	public GetCampaginHandler(CampaginService campaginService) {
		this.campaginService = campaginService;
	}

	@Override
	protected void handleWithToken(Context ctx, String token) {
		observeEach(campaginService
				.findCampaingsByToken(token))
				.toList()
				.forEach(campagins -> ctx.render(json(campagins)));
	}
}
