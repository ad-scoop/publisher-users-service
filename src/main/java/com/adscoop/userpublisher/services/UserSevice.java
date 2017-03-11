package com.adscoop.userpublisher.services;


import java.util.Optional;

import com.adscoop.userpublisher.entites.UserNode;


/**
 * Created by kleistit on 13/02/2017.
 */
public interface UserSevice {

    Optional<UserNode> findUserByToken(String token) throws Exception;

    void saveOrUpate(UserNode userNode);
}
