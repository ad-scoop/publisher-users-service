package com.adscoop.userpublisher.handlers.campagin;

import com.adscoop.userpublisher.entites.Campagin;
import com.adscoop.userpublisher.entites.WebSiteNode;
import com.adscoop.userpublisher.models.ReservedSites;
import com.adscoop.userpublisher.services.CampaginService;
import com.adscoop.userpublisher.services.WebSiteService;
import com.google.inject.Inject;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

/**
 * Created by thokle on 04/03/2017.
 */
public class AddWebSiteToCampaginHandler  implements Handler{



    private WebSiteService webSiteService;

    private CampaginService campaginService;


    @Inject
    public AddWebSiteToCampaginHandler(WebSiteService webSiteService, CampaginService campaginService) {
        this.webSiteService = webSiteService;
        this.campaginService = campaginService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String token = ctx.getRequest().getHeaders().get("token");
        String campagin_name= ctx.getAllPathTokens().get("campagin_name");

     ctx.parse(fromJson(ReservedSites.class)).then( reservedSites -> {
         Promise<WebSiteNode> webSiteNodePromise = webSiteService.findById(reservedSites.getWebsiteid());

         webSiteNodePromise.then( webSiteNode -> {
          Promise<Campagin> campaginPromise =    campaginService.findCampaginsByUserTokenAndName(campagin_name,token);

          campaginPromise.then( campagin -> {
              campagin.addReservedWebSite(webSiteNode);

              campaginService.updateCampagin(campagin);
              ctx.render(json(campagin));

          });




         });


     });

    }
}
