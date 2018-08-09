package com.playnd.sbsample.service;

import com.playnd.sbsample.mogodbEntity.UserEntity;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 9.
 */
public interface MongoDBTestService {
    List<UserEntity> getUserList();
    
    UserEntity saveUser(UserEntity mUser);
    
    UserEntity insertUser(UserEntity mUser);
    
    void deleteUser(UserEntity mUser);
}
