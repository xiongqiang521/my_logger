package com.xq.logest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author XQ
 * @version v1.0
 * 2020/10/3 21:48
 */
@Configuration
@EnableConfigurationProperties(LoggerConfigProperty.class)
public class LoggerConfig {

    @Autowired
    LoggerConfigProperty property;


    @Bean
    public LoggerService loggerService(){
        System.out.println("LoggerConfig ++++");
        return new LoggerService(property);
    }

    public String getProperty(){
        return property.toString();
    }

    @Bean
    public DataSource dataSource() {
        //可以在此处调用相关接口获取数据库的配置信息进行 DataSource 的配置
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        LoggerConfigProperty.Database databaseProperty = property.getDatabase();
        dataSource.setDriverClassName(databaseProperty.getType());
        dataSource.setUrl(databaseProperty.getUrl());
        dataSource.setUsername(databaseProperty.getUsername());
        dataSource.setPassword(databaseProperty.getPassword());

        return dataSource;
    }



}
