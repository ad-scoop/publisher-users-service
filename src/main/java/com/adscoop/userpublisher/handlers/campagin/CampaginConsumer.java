package com.adscoop.userpublisher.handlers.campagin;

import com.adscoop.userpublisher.entites.UserNode;
import com.adscoop.userpublisher.services.UserSevice;

public interface CampaginConsumer {

	public void accept(UserNode userNode) throws Exception;

}
