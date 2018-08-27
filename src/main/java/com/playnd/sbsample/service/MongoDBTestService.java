package com.playnd.sbsample.service;

import com.playnd.sbsample.model.test.TestModel;
import com.playnd.sbsample.mogodbEntity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.xml.soap.Detail;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 9.
 */
public interface MongoDBTestService {
    List<UserEntity> getUserList();
    
    Page<UserEntity> getDataPaging(Pageable pageRequest);
    
    UserEntity getUserData(String id);
    
    TestModel getUserDetail(String id);
    
    UserEntity saveUser(UserEntity mUser);
    
    UserEntity insertUser(UserEntity mUser);
    
    void deleteUser(UserEntity mUser);
    
    TestModel insertUserDetail(TestModel detail);
}
