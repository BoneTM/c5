package com.bone.c5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bone.c5.mapper")
public class C5Application {

    public static void main(String[] args) {
        SpringApplication.run(C5Application.class, args);
    }

}

