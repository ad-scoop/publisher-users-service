package com.adscoop.userpublisher.handlers.campagin;



import java.util.Optional;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.entites.UserNode;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;


import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

/**
 * Created by thokle on 27/01/2017.
 */
public class CreateCampaginHandler implements Handler {


    private UserSevice userSevice;

    @Inject
    public CreateCampaginHandler(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token  =ctx.getRequest().getHeaders().get("token");
    if(!token.isEmpty()){
      Optional<UserNode> optional =   userSevice.findUserByToken(token);
            if(optional.isPresent()){
                ctx.parse(fromJson(Campagin.class)).then(campagin -> {
                    Campagin campagin1 = new Campagin();
                    campagin1.setCampagin_name(campagin.getCampagin_name());
                    campagin1.setStartDate(campagin.getStartDate());
                    campagin1.setEndDate(campagin.getEndDate());

                    optional.get().addCampagin(campagin1);
                    userSevice.saveOrUpate(optional.get());



                });

            } else {
                ctx.render(json("no user present"));
            }
    }else {ctx.render(json("no token present"));
    }


    }



    private String getToken(Context context){
      Optional<String>  token =  Optional.of(context.getRequest().getHeaders().get("token"));
       if(token.isPresent()){
           return  token.get();
       }else {
           return "no token";
    }
    }
}
