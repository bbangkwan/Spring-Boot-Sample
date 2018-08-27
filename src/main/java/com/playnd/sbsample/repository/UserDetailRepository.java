package com.playnd.sbsample.repository;

import com.playnd.sbsample.model.test.TestModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Bae B K on 2018. 8. 17.
 */
public interface UserDetailRepository extends MongoRepository<TestModel, String> {
}
