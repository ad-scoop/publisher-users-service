package com.userpublisher.services;

import java.util.Optional;

import com.userpublisher.entites.UserNode;

/**
 * Created by kleistit on 13/02/2017.
 */
public interface UserSevice {

    Optional<UserNode> findUserByToken(String token);

    void saveOrUpate(UserNode userNode);
}
