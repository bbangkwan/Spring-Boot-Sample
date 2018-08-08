package com.playnd.sbsample.repository;

import com.playnd.sbsample.mogodbEntity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Bae B K on 2018. 8. 7.
 */
public interface MdTestRepository extends MongoRepository<User, String> {

}
