package com.playnd.sbsample.mogodbEntity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String type;
    private int age;
    private Object test;
}
