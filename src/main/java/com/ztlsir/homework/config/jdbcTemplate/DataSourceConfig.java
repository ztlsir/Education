package com.ztlsir.homework.config.jdbcTemplate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "homework")
    @ConfigurationProperties(prefix="spring.data-source.homework")
    @Primary
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "education")
    @ConfigurationProperties(prefix="spring.data-source.education")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
