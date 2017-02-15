package com.adscoop.userpublisher.services;

<<<<<<< HEAD:src/main/java/com/userpublisher/services/UserSevice.java
=======
import com.adscoop.userpublisher.entites.UserNode;

>>>>>>> 9f601f8e89d6b93e82d885f5993a327ddbb02cbc:src/main/java/com/adscoop/userpublisher/services/UserSevice.java
import java.util.Optional;

import com.userpublisher.entites.UserNode;

/**
 * Created by kleistit on 13/02/2017.
 */
public interface UserSevice {

    Optional<UserNode> findUserByToken(String token);

    void saveOrUpate(UserNode userNode);
}
