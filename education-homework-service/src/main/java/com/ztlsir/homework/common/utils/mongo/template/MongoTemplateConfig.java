package com.ztlsir.homework.common.utils.mongo.template;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoTemplateConfig {
    private String fileDBUri;
    private String dataDBUri;
}
