package com.adscoop.userpublisher.chains;

import com.adscoop.userpublisher.handlers.CORSHandler;
import com.adscoop.userpublisher.handlers.banners.AddBannerToCampaginHandler;
import ratpack.func.Action;
import ratpack.handling.Chain;

/**
 * Created by thokle on 25/01/2017.
 */
public class BannerNodeChain implements Action<Chain> {
    @Override
    public void execute(Chain chain) throws Exception {
        chain.post(":campaginname",AddBannerToCampaginHandler.class);
    }
}
