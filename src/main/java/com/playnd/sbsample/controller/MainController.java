package com.playnd.sbsample.controller;

import com.google.gson.Gson;
import com.playnd.sbsample.model.test.TestModel;
import com.playnd.sbsample.model.test.param.TestParamModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Bae B K on 2018. 8. 6.
 */
//@Controller
@RestController
@RequestMapping("/main")
@Slf4j
public class MainController {
    @Value("${spring.testValue}") private String testValue;
    
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public TestModel test(HttpServletRequest request, HttpServletResponse response){
        log.info("current env : "+testValue);
    
        Gson tsetGson = new Gson();
    
        TestModel testModel = new TestModel();
        testModel.setAge(10);
        testModel.setName("bbk");
        testModel.setStatus("live");
        
        return testModel;
    }
    
    @RequestMapping(value = "/initPost", method = RequestMethod.POST)
    @ResponseBody
    //public ResponseEntity<TestModel> initPost(HttpServletRequest request, HttpServletResponse response, @RequestBody TestParamModel testParamModel){
    public TestModel initPost(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody TestParamModel testParamModel, BindingResult bindingResult){
        log.info("current env : "+testValue);
    
        if(bindingResult.hasErrors()){
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.info(errorMessage);
        }
        
        log.info(testParamModel.toString());
        
        Gson testGson = new Gson();
    
        TestModel testModel = new TestModel();
        testModel.setAge(10);
        testModel.setName("bbk");
        testModel.setStatus("live");
        
        //return testGson.toJson(testModel);
        //return new ResponseEntity<TestModel>(testModel);
        return testModel;
    }
}
