package com.adscoop.userpublisher.services;

import com.adscoop.userpublisher.entites.WebSiteNode;
import ratpack.exec.Promise;

/**
 * Created by thokle on 04/03/2017.
 */
public interface WebSiteService {



    Promise<WebSiteNode> findById(Long id) throws Exception;
}
