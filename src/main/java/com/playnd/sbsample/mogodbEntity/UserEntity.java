package com.playnd.sbsample.mogodbEntity;

import com.playnd.sbsample.model.test.TestModel;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by Bae B K on 2018. 8. 7.
 */
@Data
@Builder
@Document(collection = "user")
public class UserEntity {
    @Id
    private String _id;
    
    @Indexed(name = "id", unique = true)
    private String id;
    
    //@Indexed(name="type", unique = true)
    @Field(value = "type")
    private String type;
    
    @Field(value = "age", order = 3)
    private Integer age;
    
    @DBRef
    private List<TestModel> detail;
    
    
    //expireAfterSeconds는 Date 인 경우에 적용이 가능. mongodb에서 기본적으로 60초마다 expire를 시키기 때문에 60초 이상의 시간으로 설정하는게 적당할듯. 그리고 60초가 되었다고 바로 삭제가 되지는 않으며, 약간의 오차범위는 존재한다.
    //@Indexed(name = "temp", expireAfterSeconds = 60)
    @Field(value = "temp", order = 2)
    private Date temp;
}
