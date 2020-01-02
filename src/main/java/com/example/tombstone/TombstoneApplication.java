package com.example.tombstone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "com.example.tombstone")

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan( "com.example.tombstone.api.dao")
@SpringBootApplication
public class TombstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TombstoneApplication.class, args);
    }

}
