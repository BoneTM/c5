package com.bone.c5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class C5Application {

    public static void main(String[] args) {
        SpringApplication.run(C5Application.class, args);
    }

}

