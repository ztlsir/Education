package com.ztlsir.homework.config.jdbcTemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryHomework",
        transactionManagerRef = "transactionManagerHomework",
        basePackages = {"com.ztlsir.homework.entity"})
public class HomeworkConfig {
    private DataSource primaryDataSource;
    private JpaProperties jpaProperties;
    private HibernateProperties hibernateProperties;

    public HomeworkConfig(
            @Qualifier("homework") DataSource primaryDataSource,
            JpaProperties jpaProperties,
            HibernateProperties hibernateProperties) {
        this.primaryDataSource = primaryDataSource;
        this.jpaProperties = jpaProperties;
        this.hibernateProperties = hibernateProperties;
    }

    @Primary
    @Bean(name = "entityManagerHomework")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryHomework")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties(primaryDataSource))
                .packages("com.ztlsir.homework.dao")
                .persistenceUnit("homeworkPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerHomework")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

    private Map<String, Object> getVendorProperties(DataSource dataSource) {
        return hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
    }
}
