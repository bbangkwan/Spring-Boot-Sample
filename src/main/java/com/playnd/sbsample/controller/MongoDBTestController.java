package com.playnd.sbsample.controller;


import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.playnd.sbsample.model.test.TestModel;
import com.playnd.sbsample.model.user.User;
import com.playnd.sbsample.model.user.param.UserParam;
import com.playnd.sbsample.mogodbEntity.UserEntity;
import com.playnd.sbsample.service.MongoDBTestService;
import lombok.extern.slf4j.Slf4j;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    @GetMapping(value = "/getDataList")
    public List<UserEntity> getDataList(){
        List<UserEntity> testList = mongoDBTestService.getUserList();
        
        for(UserEntity temp : testList){
            log.info("==========================================================");
            log.info("objectId : "+temp.get_id());
            log.info("toString : "+temp.get_id().toString());
            /*log.info("toString : "+temp.get_id().toString());
            log.info("getDate : "+temp.get_id().getDate());
            log.info("getCounter : "+temp.get_id().getCounter());
            log.info("getTimestamp : "+temp.get_id().getTimestamp());
            log.info("getMachineIdentifier : "+temp.get_id().getMachineIdentifier());
            log.info("getProcessIdentifier : "+temp.get_id().getProcessIdentifier());
            
            log.info(""+temp.get_id().toByteArray());*/
        }
        
        return testList;
    }
    
    @GetMapping(value = "/getDataListPaging")
    public void getDataPaging(){
        PageRequest pageRequest = PageRequest.of(1, 10);
        Page<UserEntity> userListPage = mongoDBTestService.getDataPaging(pageRequest);
        
        log.info("getTotalElements : "+userListPage.getTotalElements());
        log.info("getTotalPages : "+userListPage.getTotalPages());
        log.info("getContent : "+userListPage.getContent());
        log.info("getNumber : "+userListPage.getNumber());
        log.info("getNumberOfElements : "+userListPage.getNumberOfElements());
        log.info("getPageable : "+userListPage.getPageable());
        log.info("getSize : "+userListPage.getSize());
        log.info("getSort : "+userListPage.getSort());
        
        log.info("toString : "+userListPage.toString());
        
        while(userListPage.hasNext()){
            log.info("test!!!");
        }
        
        for(UserEntity temp : userListPage){
            log.info(temp.toString());
        }
    }
    
    @GetMapping(value = "/getData")
    public UserEntity getData(@RequestParam(value = "userId") String userId){
        log.info(userId);
        UserEntity userEntity = mongoDBTestService.getUserData(userId);
        
        return userEntity;
    }
    
    @GetMapping(value = "getDataDetail")
    public TestModel getDataDetail(@RequestParam(value = "id") String id){
        TestModel detail = mongoDBTestService.getUserDetail(id);
        
        return detail;
    }
    
    @GetMapping(value = "/searchData")
    public void searchData(){
    
    }
    
    @PostMapping(value = "/insertUserData")
    public UserEntity insertUserData(@RequestBody UserParam userParam) {
        UserEntity.UserEntityBuilder userBuilder = UserEntity.builder();
        
        /*ObjectId objectId = new ObjectId();
        log.info(objectId.toString());
        userParam.getDetail().setId(objectId);*/
        
        TestModel userDetail = mongoDBTestService.insertUserDetail(userParam.getDetail());
        
        List<TestModel> testModelList = new ArrayList<>();
        testModelList.add(userDetail);
    
        Date date = Calendar.getInstance().getTime();
        
        userBuilder.id(userParam.getId())
                .type(userParam.getType()).age(userParam.getAge()).detail(testModelList).temp(date);
    
        UserEntity resultUser = null;
        try{
            resultUser = mongoDBTestService.insertUser(userBuilder.build());   
        }catch (MongoWriteException mw){
            log.error("write exception!!!!");
        }
        catch (Exception mwe){
            log.error("insert error!!!!");
        }
    
        return resultUser;
    }
    
    @PutMapping(value = "/saveUserData")
    public UserEntity saveUserData(@RequestBody UserParam userParam){
        UserEntity.UserEntityBuilder userBuilder = UserEntity.builder();
    
        List<TestModel> testModelList = new ArrayList<>();
        testModelList.add(userParam.getDetail());
    
        Date date = Calendar.getInstance().getTime();
        
        userBuilder.id(userParam.getId())
                .age(10)
                .type(userParam.getType()).detail(testModelList).temp(date);
        
        UserEntity resultUser = mongoDBTestService.saveUser(userBuilder.build());
        
        return resultUser;
    }
    
    @DeleteMapping(value = "/deleteUserData")
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
