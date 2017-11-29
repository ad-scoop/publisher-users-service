package com.adscoop.userpublisher.handlers;

import static ratpack.jackson.Jackson.json;

import org.apache.commons.lang3.StringUtils;

import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.http.Status;

public class DeleteCampaginHandler extends AbstractTokenHandler {

	private CampaginService campaginService;

	@Inject
	public DeleteCampaginHandler(CampaginService campaginService) {
		this.campaginService = campaginService;
	}

	@Override
	protected void handleWithToken(Context ctx, String token) {
		String id = ctx.getPathTokens().get("id");
		if (StringUtils.isEmpty(id)) {
			ctx.getResponse().status(Status.of(412));
			ctx.render(json("missing id"));
		} else {
			campaginService.deleteCampagin(Long.parseLong(id));
			ctx.render(json("campagin deleted"));
		}
	}

}
