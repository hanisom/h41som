package com.complaint_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ComplaintApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComplaintApplication.class, args);
    }
}

