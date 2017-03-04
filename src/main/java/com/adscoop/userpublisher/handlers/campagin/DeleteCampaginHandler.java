package com.adscoop.userpublisher.handlers.campagin;

import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class DeleteCampaginHandler implements Handler {

	private ExtractUser extractUser;

	@Inject
	public DeleteCampaginHandler(UserSevice userSevice) {
		this.extractUser = new ExtractUser(userSevice);
	}

	@Override
	public void handle(Context ctx) throws Exception {
		this.extractUser.handle(ctx, (user) -> { 
			user.removeCampagin(ctx.getRequest().getQueryParams().get("name"));
		}); 
	}

}
