package com.adscoop.userpublisher.services;


import com.adscoop.userpublisher.entites.UserNode;

import ratpack.exec.Promise;


/**
 * Created by kleistit on 13/02/2017.
 */
public interface UserSevice {

    Promise<UserNode> findUserByToken(String token) throws Exception;

    void saveOrUpate(UserNode userNode);
}
