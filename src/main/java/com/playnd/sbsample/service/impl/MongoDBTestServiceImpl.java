package com.playnd.sbsample.service.impl;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.playnd.sbsample.model.test.TestModel;
import com.playnd.sbsample.mogodbEntity.UserEntity;
import com.playnd.sbsample.repository.MdTestRepository;
import com.playnd.sbsample.repository.UserDetailRepository;
import com.playnd.sbsample.service.MongoDBTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import javax.xml.soap.Detail;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 9.
 */
@Slf4j
@Service
public class MongoDBTestServiceImpl implements MongoDBTestService {
    @Autowired
    private MdTestRepository mdTestRepository;
    
    @Autowired
    private UserDetailRepository userDetailRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public List<UserEntity> getUserList() {
        List<UserEntity> testList = mdTestRepository.findAll();
        log.info("testList size : "+testList.size());
        log.info("testList toString : "+testList.toString());
        
        log.info("test : "+mongoTemplate.getDb().getName());
        
        return testList;
    }
    
    @Override
    public Page<UserEntity> getDataPaging(Pageable pageable) {
        Page<UserEntity> pageList = mdTestRepository.findAll(pageable);
        
        return pageList;
    }
    
    @Override
    public UserEntity getUserData(String id) {
        Criteria criteria = Criteria.where("id");// where 절에 들어가는 부분을 이 클래스를 이용해서 구성을 한뒤 Query 객체에 넣는다.
        criteria.is(id);
        
        Query query = new Query(criteria);
        
        
        
        UserEntity userEntity = mongoTemplate.findOne(query, UserEntity.class);
        log.info(userEntity.toString());
        
        UserEntity userEntity1 = mdTestRepository.findByIdQuery(id);
        log.info(userEntity1.toString());
        
        return userEntity1;
    }
    
    @Override
    public TestModel getUserDetail(String id) {
        Criteria criteria = Criteria.where("id");
        criteria.is(id);
    
        Query query = new Query(criteria);
        query.fields().include("detail").exclude("_id");
    
        TestModel testModel = mongoTemplate.findOne(query, TestModel.class, "detail");
        //log.info(testModel.toString());
    
        TestModel detail = mdTestRepository.findDetail(id);
        
        return detail;
    }
    
    /**
     * save의 경우에는 document에 해당 id 객체가 존재하면 update, 없을 경우에는 insert를 수행한다.
     * @param mUser
     * @return
     */
    @Override
    public UserEntity saveUser(UserEntity mUser) {
        UserEntity user = mdTestRepository.save(mUser);
        
        log.info("saveUser : "+user.toString());
        
        return user;
    }
    
    /**
     * insert의 경우에는 rdbms의 insert와 마찬가지로 document에 해당 id가 존재하지 않을 경우에 insert를 하고, 존재할 경우에는 duplicated error 를 발생시킨다.
     * @param mUser
     * @return
     */
    @Override
    public UserEntity insertUser(UserEntity mUser) throws MongoWriteException {
        UserEntity user = null;
        try{
            user = mdTestRepository.insert(mUser);
        }catch(Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
            log.info(e.hashCode()+"");
            log.error("error@!!!!!!!");
        }
    
        log.info("insertUser : "+user.toString());
        
        return user;
    }
    
    @Override
    public void deleteUser(UserEntity mUser) {
        //mdTestRepository.delete(mUser);
        
        mdTestRepository.deleteById(mUser.getId());
    }
    
    @Override
    public TestModel insertUserDetail(TestModel detail) {
        TestModel userDetail = userDetailRepository.insert(detail);
        
        return userDetail;
    }
}
