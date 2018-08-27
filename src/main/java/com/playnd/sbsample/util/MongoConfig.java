package com.playnd.sbsample.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.Arrays;

/**
 * Created by Bae B K on 2018. 8. 16.
 */
public class MongoConfig extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.username}")
    private String userName;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.database}")
    private String database;
    
    @Override
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
        return new MongoClient(new ServerAddress(host, 27017), Arrays.asList(credential));
    }
    
    @Override
    protected String getDatabaseName() {
        return database;
    }
    
    @Bean
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongoClient(), database);
    }
}
