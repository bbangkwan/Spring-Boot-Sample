package com.playnd.sbsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bae B K on 2018. 8. 6.
 */
//@Controller
@RestController
@RequestMapping("/main")
public class MainController {
    
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String test(){
        return "Hi, Spring Boot Project Init!!!";
    }
}
