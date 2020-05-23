package com.ztlsir.homework.common.utils.mongo.template;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
public class MongoTemplateFactory {
    public static final String FILE_DATABASE_INJECT_NAME ="file";
    public static final String DATA_DATABASE_INJECT_NAME ="data";


    private MongoTemplateConfig config;

    public MongoTemplateFactory(MongoTemplateConfig config) {
        this.config = config;
    }

    @Primary
    @Bean(name = MongoTemplateFactory.DATA_DATABASE_INJECT_NAME)
    public MongoTemplate getDataMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(config.getDataDBUri()));
    }

    @Bean(name = MongoTemplateFactory.FILE_DATABASE_INJECT_NAME)
    public MongoTemplate getFileMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(config.getFileDBUri()));
    }

    protected MongoDbFactory mongoDbFactory(String uri) throws Exception {
        return new SimpleMongoClientDbFactory(uri);
    }
}
