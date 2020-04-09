package com.djw.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.djw.edu.mapper")
@ComponentScan(basePackages = "com.djw")
public class ServiceEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class, args);
    }

}
