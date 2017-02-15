package com.userpublisher.handlers.banners;

import java.util.Optional;


import com.adscoop.userpublisher.entites.BannerNode;
import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.services.CampaginService;
import ratpack.form.Form;
import ratpack.form.UploadedFile;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Created by kleistit on 13/02/2017.
 */
public class AddBannerToCampaginHandler implements Handler {
    CampaginService campaginService;



    public AddBannerToCampaginHandler(CampaginService campaginService) {
        this.campaginService = campaginService;

    }

    @Override
    public void handle(Context ctx) throws Exception {

        ctx.parse(Form.class).then(form -> {

        Optional<Campagin> campagin =  campaginService.findCampaginsByUserTokenAndName("","");

        if(campagin.isPresent()){
            BannerNode banner = new BannerNode();

            //path =  /token/campaginname/bannername/pictureid.extension

            campagin.get().addBanner(banner);


            campaginService.updateCampagin(campagin.get());
        }
           UploadedFile uploadedFile =  form.file("file");


        });



            }
}
