package com.wtc.example.multidatasource.property.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef="agentEntityManagerFactory",
        transactionManagerRef="agentTransactionManager",
        basePackages= {"com.wtc.example.multidatasource.agent.repository"})
public class Testdb2Config {

    @Bean(name = "testdb2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.testdb2")
    public DataSource testdb2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "agentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("testdb2DataSource") DataSource dataSource) {
        return builder.
                dataSource(dataSource)
                .packages("com.wtc.example.multidatasource.agent.entity")
                .persistenceUnit("testdb2PersistenceUnit")
                .build();
    }

    @Bean(name = "agentTransactionManager")
    public PlatformTransactionManager propertyTransactionManager(
            @Qualifier("agentEntityManagerFactory") EntityManagerFactory agentEntityManagerFactory) {
        return new JpaTransactionManager(agentEntityManagerFactory);
    }
}