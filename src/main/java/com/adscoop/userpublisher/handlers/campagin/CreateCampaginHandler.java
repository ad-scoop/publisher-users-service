package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.fromJson;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Created by thokle on 27/01/2017.
 */
public class CreateCampaginHandler implements Handler {

	private ExtractUser extractUser;
	private UserSevice userSevice;

	@Inject
	public CreateCampaginHandler(UserSevice userSevice) {
		this.userSevice = userSevice;
		this.extractUser = new ExtractUser(userSevice);
	}

	@Override
	public void handle(Context ctx) throws Exception {
		this.extractUser.handle(ctx, user -> { 
			ctx.parse(fromJson(Campagin.class)).then(campagin -> {
				user.addCampagin(campagin);
				userSevice.saveOrUpate(user);
			});
		}); 
	}

}
