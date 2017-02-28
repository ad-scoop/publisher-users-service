package com.adscoop.userpublisher.handlers.campagin;

import com.adscoop.userpublisher.services.CampaginService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.rx.RxRatpack;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

/**
 * Created by thokle on 28/02/2017.
 */
public class GetCampaginHandler implements Handler {


    private  CampaginService campaginService;


    @Inject
    public GetCampaginHandler(CampaginService campaginService) {
        this.campaginService = campaginService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token = ctx.getRequest().getHeaders().get("token");
        if(!token.isEmpty()){
            RxRatpack.observeEach(campaginService.findCampaingsByUser(token)).toList().forEach(campagins -> {
                ctx.render(json(campagins));
            });
        } else {
            ctx.render(json("no token"));
        }

    }
}
