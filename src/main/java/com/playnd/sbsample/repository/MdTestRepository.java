package com.playnd.sbsample.repository;


import com.playnd.sbsample.mogodbEntity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Bae B K on 2018. 8. 7.
 */
public interface MdTestRepository extends MongoRepository<UserEntity, String>{
    //insert : 말그대로 insert.
    //save : 해당 id의 row가 존재하면 update, 없으면 insert
}
