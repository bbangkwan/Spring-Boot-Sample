package com.playnd.sbsample.repository;


import com.playnd.sbsample.model.test.TestModel;
import com.playnd.sbsample.mogodbEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.lang.Nullable;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 7.
 */
public interface MdTestRepository extends MongoRepository<UserEntity, String>{
    //insert : 말그대로 insert.
    //save : 해당 id의 row가 존재하면 update, 없으면 insert
    
    @Query("{id : ?0}")
    UserEntity findByIdQuery(String userId);
    
    @Query(value = "{'id' : ?0}", fields = "{'_id': 0, 'detail': 1}")
    TestModel findDetail(String id);
}
