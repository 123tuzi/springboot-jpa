package com.wtc.example.multidatasource.property.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/****
 * 配置主数据源
 * @author wangning
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="propertyEntityManagerFactory",
        transactionManagerRef="propertyTransactionManager",
        basePackages= {"com.wtc.example.multidatasource.property.repository"})
public class TestdbConfig {


    @Primary
    @Bean(name = "testdbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.testdb")
    public DataSource testdbDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "propertyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,  @Qualifier("testdbDataSource") DataSource dataSource) {
        return builder.
                dataSource(dataSource)
                .packages("com.wtc.example.multidatasource.property.entity")
                .persistenceUnit("testdbPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "propertyTransactionManager")
    public PlatformTransactionManager propertyTransactionManager(
            @Qualifier("propertyEntityManagerFactory") EntityManagerFactory propertyEntityManagerFactory) {
        return new JpaTransactionManager(propertyEntityManagerFactory);
    }
}