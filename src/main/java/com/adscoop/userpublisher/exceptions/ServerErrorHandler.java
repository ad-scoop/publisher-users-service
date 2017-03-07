package com.adscoop.userpublisher.exceptions;

import ratpack.handling.Context;

/**
 * Created by kleistit on 06/03/2017.
 */
public class ServerErrorHandler implements ratpack.error.ServerErrorHandler {

    @Override
    public void error(Context context, Throwable throwable) throws Exception {
        context.render(throwable.getMessage());
        throwable.printStackTrace();
    }
}
