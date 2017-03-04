package com.adscoop.userpublisher.handlers.campagin;

import com.adscoop.userpublisher.entites.UserNode;

public interface CampaginConsumer {

	public void accept(UserNode userNode) throws Exception;

}
