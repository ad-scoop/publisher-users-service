package com.adscoop.userpublisher.handlers.campagin;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.entites.UserNode;
import com.adscoop.userpublisher.services.CampaginService;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.exec.Promise;
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
			findCampagin(ctx, user)
				.then(campagin -> campaginService.deleteCampagin(campagin));
		}); 
	}

	private Promise<Campagin> findCampagin(Context ctx, UserNode user) throws Exception {
		return campaginService.findCampaginsByUserTokenAndName(
				ctx.getRequest().getQueryParams().get("name"), 
				user.getToken());
	}

}
