package com.andreiy.gordeev.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.andreiy.gordeev")
@PropertySource("classpath:application.properties")
public class DbConfig {

    @Value("${database.driver}")
    private String dbDriver;

    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.username}")
    private String dbUserName;

    @Value("${database.password}")
    private String dbUserPass;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbUserPass);

        return dataSource;
    }
}
