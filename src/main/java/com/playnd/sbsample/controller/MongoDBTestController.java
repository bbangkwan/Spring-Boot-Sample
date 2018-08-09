package com.playnd.sbsample.controller;


import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.playnd.sbsample.model.user.param.UserParam;
import com.playnd.sbsample.mogodbEntity.UserEntity;
import com.playnd.sbsample.service.MongoDBTestService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 7.
 */
@RestController
@RequestMapping("/mgtest")
@Slf4j
public class MongoDBTestController {
    @Autowired
    MongoDBTestService mongoDBTestService;
    
    @PostMapping(value = "/getData")
    public List<UserEntity> getMongoDB(){
        List<UserEntity> testList = mongoDBTestService.getUserList();
        
        return testList;
    }
    
    @PostMapping(value = "/saveUserData")
    public UserEntity saveUserData(@RequestBody UserParam userParam){
        UserEntity.UserEntityBuilder userBuilder = UserEntity.builder();
        userBuilder.id(userParam.getId())
        .type(userParam.getType()).age(userParam.getAge());
    
        UserEntity resultUser = mongoDBTestService.saveUser(userBuilder.build());
        
        return resultUser;
    }
    
    @PostMapping(value = "/insertUserData")
    public UserEntity insertUserData(@RequestBody UserParam userParam) {
        UserEntity.UserEntityBuilder userBuilder = UserEntity.builder();
        userBuilder.id(userParam.getId())
                .type(userParam.getType()).age(userParam.getAge());
    
        UserEntity resultUser = null;
        try{
            resultUser = mongoDBTestService.insertUser(userBuilder.build());   
        } catch (Exception mwe){
            log.error("insert error!!!!");
        }
    
        return resultUser;
    }
    
    @PostMapping(value = "/deleteUserData")
    public String deleteUserData(@RequestBody UserParam userParam) {
        UserEntity.UserEntityBuilder userBuilder = UserEntity.builder();
        userBuilder.id(userParam.getId())
                .type(userParam.getType()).age(userParam.getAge());
        
        
        try{
            mongoDBTestService.deleteUser(userBuilder.build());
        } catch (Exception mwe){
            log.error("insert error!!!!");
        }
        
        return "success";
    }
}
