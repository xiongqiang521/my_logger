package com.xq.logest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyLoggerApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MyLoggerApplication.class, args);
    }

}
