package com.playnd.sbsample.controller;

import com.playnd.sbsample.model.ApiStatusModel;
import com.playnd.sbsample.model.ResponseModel;
import com.playnd.sbsample.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bae B K on 2018. 8. 21.
 */
@Controller
@Slf4j
@RequestMapping(value = "/api/users")
public class UserController {
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getAllUserList(){
        ResponseEntity<ResponseModel> responseEntity = null;
        
        HttpStatus httpStatus = null;
        
        User user = new User();
        user.setName("api/users/all");
        
        ResponseModel.ResponseModelBuilder builder = ResponseModel.builder();
        builder.data(user);
        
        httpStatus = HttpStatus.OK;
        
        log.info(httpStatus.value()+"");
        log.info(httpStatus.getReasonPhrase());
        log.info("is error : "+httpStatus.isError());
        log.info("is 1xxInformational : "+httpStatus.is1xxInformational());
        log.info("is 2xxSuccessful : "+httpStatus.is2xxSuccessful());
        log.info("is 3xxRedirection : "+httpStatus.is3xxRedirection());
        log.info("is 4xxClientError : "+httpStatus.is4xxClientError());
        log.info("is 5xxServerError : "+httpStatus.is5xxServerError());
        
        ApiStatusModel.ApiStatusModelBuilder apiStatusModelBuilder = ApiStatusModel.builder();
        apiStatusModelBuilder.code(httpStatus.value());
        apiStatusModelBuilder.codeType(httpStatus.name());
        apiStatusModelBuilder.message(httpStatus.getReasonPhrase());
        
        builder.apiStatus(apiStatusModelBuilder.build());
        
        responseEntity = new ResponseEntity<>(builder.build(), httpStatus);
        
        return responseEntity;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserDetail(@PathVariable("id") final String id){
        HttpStatus httpStatus = null;
        
        log.info(id);
    
        httpStatus = HttpStatus.NOT_ACCEPTABLE;
    
        log.info(httpStatus.value()+"");
        log.info(httpStatus.getReasonPhrase());
        
        User user = new User();
        user.setName(id);
        
        return new ResponseEntity<User>(user, httpStatus);
    }
    
    @RequestMapping(value = "/singUp", method = RequestMethod.POST)
    public void createUser(){
    
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(){
    
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(){
    
    }
}
