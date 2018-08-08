package com.playnd.sbsample.mogodbEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Bae B K on 2018. 8. 7.
 */
@Document
public class User {
    @Id
    public String ttt;
    
    public String id;
    public String type;
    
    public User() {}
    
    public User(String ttt, String id, String type) {
        this.ttt = ttt;
        this.id = id;
        this.type = type;
    }
    
    @Override
    public String toString() {
        return String.format(
                "TestEntity[id=%s, type='%s', ttt=%s",
                id, type, ttt);
    }
}
