package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.json;

import java.util.Optional;

import com.adscoop.userpublisher.entites.UserNode;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;

public class ExtractUser {

	private UserSevice userSevice;

	@Inject
	public ExtractUser(UserSevice userSevice) {
		this.userSevice = userSevice;
	}

	public void handle(Context ctx, CampaginConsumer consumeCampagin) throws Exception {
		String token = ctx.getRequest().getHeaders().get("token");
		if (!token.isEmpty()) {
			 userSevice.findUserByToken(token).then(userNode -> {
				 if (userNode !=null) {
					 consumeCampagin.accept(userNode);
				 } else {
					 ctx.render(json("no user present"));
				 }

			 });

		} else {
			ctx.render(json("no token present"));
		}
		
	}

}
