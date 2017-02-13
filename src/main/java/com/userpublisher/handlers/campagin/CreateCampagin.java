package com.userpublisher.handlers.campagin;

import com.userpublisher.services.CampaginServiceImpl;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Optional;

/**
 * Created by thokle on 27/01/2017.
 */
public class CreateCampagin implements Handler {


    private CampaginServiceImpl campaginService;

    @Inject
    public CreateCampagin(CampaginServiceImpl campaginService) {
        this.campaginService = campaginService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
    if(!getToken(ctx).contains("no token")){


    }


    }



    private String getToken(Context context){
      Optional<String>  token =  Optional.of(context.getRequest().getHeaders().get("token"));
       if(token.isPresent()){
           return  token.get();
       }else return "no token";
    }
}
