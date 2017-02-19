package com.adscoop.userpublisher.exceptions;

import ratpack.error.ClientErrorHandler;
import ratpack.handling.Context;

/**
 * Created by kleistit on 13/02/2017.
 */
public class PublisherUserException implements ClientErrorHandler {
    @Override
    public void error(Context context, int statusCode) throws Exception {
        context.redirect(statusCode,context.file("ErrorPage.html"));
    }
}
