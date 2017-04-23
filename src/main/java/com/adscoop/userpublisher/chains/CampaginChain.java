package com.adscoop.userpublisher.chains;

import com.adscoop.userpublisher.handlers.CreateCampaginHandler;
import com.adscoop.userpublisher.handlers.DeleteCampaginHandler;
import com.adscoop.userpublisher.handlers.GetCampaginHandler;
import com.adscoop.userpublisher.handlers.UpdateCampaginHandler;

import ratpack.func.Action;
import ratpack.handling.Chain;

public class CampaginChain implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain
        	.post("create", CreateCampaginHandler.class)
        	.post("update", UpdateCampaginHandler.class)
        	.delete("remove/:id", DeleteCampaginHandler.class)
        	.get(GetCampaginHandler.class);
    }
    
}
