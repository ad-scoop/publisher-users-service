package com.adscoop.userpublisher.chains;

import com.adscoop.userpublisher.handlers.bannerspace.GetReservedBannserSpacesHandler;
import com.adscoop.userpublisher.handlers.campagin.CreateCampaginHandler;
import com.adscoop.userpublisher.handlers.campagin.DeleteCampaginHandler;
import com.adscoop.userpublisher.handlers.campagin.GetCampaginHandler;
import com.adscoop.userpublisher.handlers.campagin.UpdateCampaginHandler;

import ratpack.func.Action;
import ratpack.handling.Chain;

/**
 * Created by thokle on 25/01/2017.
 */
public class CampaginChain implements Action<Chain> {


    @Override
    public void execute(Chain chain) throws Exception {
        chain
        	.post("create", CreateCampaginHandler.class)
        	.post("update", UpdateCampaginHandler.class)
        	.delete("remove", DeleteCampaginHandler.class)
        	.get("reservedbannserspaces", GetReservedBannserSpacesHandler.class)
        	.get("listUserCampagins", GetCampaginHandler.class);
    }
}
