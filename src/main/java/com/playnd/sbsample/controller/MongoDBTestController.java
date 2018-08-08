package com.playnd.sbsample.controller;

import com.playnd.sbsample.mogodbEntity.User;
import com.playnd.sbsample.repository.MdTestRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    private MdTestRepository mdTestRepository;
    
    @PostMapping(value = "/test")
    public List<User> getMongoDB(){
        List<User> testList = mdTestRepository.findAll();
        log.info("testList size : "+testList.size());
        log.info("testList toString : "+testList.toString());
        
        return testList;
    }
}
