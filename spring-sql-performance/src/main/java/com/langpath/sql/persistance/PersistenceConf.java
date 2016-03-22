package com.langpath.sql.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sebastian on 2016-03-14.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.langpath.sql.repositories")
@EnableTransactionManagement
public class PersistenceConf {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("sql.base.packagesToScan"));

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(vendorAdapter);

        em.setJpaProperties(additionalProperties());


        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DataSource dataSource(){
        final String password = env.getRequiredProperty("sql.dataBase.password");
        final String user = env.getRequiredProperty("sql.dataBase.user");
        final String url = env.getProperty("sql.dataBase.url");
        final String driverClass = env.getRequiredProperty("sql.dataBase.driver");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public Properties additionalProperties() {
        final String hbm2ddl = env.getRequiredProperty("hibernate.hbm2ddl.auto");
        final String dialect = env.getRequiredProperty("hibernate.dialect");
        final String generateDdl = env.getRequiredProperty("spring.jpa.generate-ddl");
        final String showSql = env.getRequiredProperty("hibernate.show_sql");
        
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("spring.jpa.generate-ddl", generateDdl);
        properties.setProperty("hibernate.show_sql", showSql);

        return properties;
    }


}
