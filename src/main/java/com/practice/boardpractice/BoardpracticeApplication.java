package com.practice.boardpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BoardpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardpracticeApplication.class, args);
    }

}
