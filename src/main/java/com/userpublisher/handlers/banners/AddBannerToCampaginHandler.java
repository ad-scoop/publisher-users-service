package com.userpublisher.handlers.banners;

import com.userpublisher.entites.BannerNode;
import com.userpublisher.entites.Campagin;
import com.userpublisher.services.CampaginService;
import com.userpublisher.services.UploadBannerService;
import ratpack.form.Form;
import ratpack.form.UploadedFile;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Optional;

/**
 * Created by kleistit on 13/02/2017.
 */
public class AddBannerToCampaginHandler implements Handler {
    CampaginService campaginService;
    UploadBannerService uploadBannerService;


    public AddBannerToCampaginHandler(CampaginService campaginService, UploadBannerService uploadBannerService) {
        this.campaginService = campaginService;
        this.uploadBannerService = uploadBannerService;
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
