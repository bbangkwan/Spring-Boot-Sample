package com.playnd.sbsample.service.impl;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.playnd.sbsample.mogodbEntity.UserEntity;
import com.playnd.sbsample.repository.MdTestRepository;
import com.playnd.sbsample.service.MongoDBTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 9.
 */
@Slf4j
@Service
public class MongoDBTestServiceImpl implements MongoDBTestService {
    @Autowired
    private MdTestRepository mdTestRepository;
    
    @Override
    public List<UserEntity> getUserList() {
        List<UserEntity> testList = mdTestRepository.findAll();
        log.info("testList size : "+testList.size());
        log.info("testList toString : "+testList.toString());
        
        return testList;
    }
    
    @Override
    public Page<UserEntity> getDataPaging(Pageable pageable) {
        Page<UserEntity> pageList = mdTestRepository.findAll(pageable);
        
        return pageList;
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
}
