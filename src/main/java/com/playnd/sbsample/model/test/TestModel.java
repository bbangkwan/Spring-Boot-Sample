package com.playnd.sbsample.model.test;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.Nullable;

/**
 * Created by Bae B K on 2018. 8. 8.
 */
@Data
@Document(collection = "default")
public class TestModel {
    @Id
    private String id;
    @Field(value = "name")
    private String name;
    @Field(value = "age")
    private Integer age;
    @Field(value = "status")
    private String status;
    
    /*public TestModel(String name, Integer age, String status){
        this.name = name;
        this.age = age;
        this.status = status;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Integer getAge() {
        return this.age;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }*/
}
