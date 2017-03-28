package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

import com.adscoop.userpublisher.configurations.JsonToString;
import com.adscoop.userpublisher.services.CampaginService;
import com.google.gson.Gson;
import com.google.inject.Inject;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.reactivestreams.Publisher;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.rx.RxRatpack;

import java.nio.charset.Charset;

/**
 * Created by thokle on 28/02/2017.
 */
public class GetCampaginHandler implements Handler {


    private  CampaginService campaginService;
private JsonToString  jsonToString;

    @Inject
    public GetCampaginHandler(CampaginService campaginService, JsonToString jsonToString) {
        this.campaginService = campaginService;
        this.jsonToString = jsonToString;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token = ctx.getRequest().getHeaders().get("token");
        if(!token.isEmpty()) {
            RxRatpack.observeEach(campaginService.findCampaingsByUser(token)).toList().forEach(

                    campagins -> ctx.render(json(campagins)));


        } else {
            ctx.render(json("no token"));
        }

    }
}
