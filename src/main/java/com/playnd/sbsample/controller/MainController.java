package com.playnd.sbsample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

/**
 * Created by Bae B K on 2018. 8. 6.
 */
//@Controller
@RestController
@RequestMapping("/main")
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    
    @Value("${spring.testValue}") private String testValue;
    
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String test(){
        log.info("current env : "+testValue);
        
        return "Hi, Spring Boot Project Init!!!";
    }
}
