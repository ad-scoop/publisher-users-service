package com.userpublisher.services;

import com.userpublisher.entites.UserNode;

import java.util.Optional;

/**
 * Created by kleistit on 13/02/2017.
 */
public interface UserSevice {

    Optional<UserNode> findUserByToken(String token);

    void saveOrUpate(UserNode userNode);
}
