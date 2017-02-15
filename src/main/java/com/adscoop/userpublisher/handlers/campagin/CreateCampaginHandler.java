package com.adscoop.userpublisher.handlers.campagin;

import static ratpack.jackson.Jackson.fromJson;

import java.util.Optional;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.entites.UserNode;
import com.adscoop.userpublisher.services.UserSevice;
import com.google.inject.Inject;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

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
    if(!getToken(ctx).contains("no token")){
      Optional<UserNode> optional =   userSevice.findUserByToken(getToken(ctx));
            if(optional.isPresent()){
                ctx.parse(Jackson.fromJson(Campagin.class)).then(campagin -> {
                    Campagin campagin1 = new Campagin();
                    campagin1.setCampagin_name(campagin.getCampagin_name());
                    campagin1.setStartDate(campagin.getStartDate());
                    campagin1.setEndDate(campagin.getEndDate());

                    optional.get().addCampagin(campagin1);
                    userSevice.saveOrUpate(optional.get());



                });

            } else {
                ctx.render("no user present");
            }
    }else {ctx.render("no token present");
    }


    }



    private String getToken(Context context){
      Optional<String>  token =  Optional.of(context.getRequest().getHeaders().get("token"));
       if(token.isPresent()){
           return  token.get();
       }else return "no token";
    }
}
