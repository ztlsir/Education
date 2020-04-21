package com.ztlsir.homework.config.mongoTemplate;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Value
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoTemplateConfig {
    private String fileDBUri;
    private String dataDBUri;
}
