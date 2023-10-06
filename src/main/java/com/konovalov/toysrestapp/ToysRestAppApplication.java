package com.konovalov.toysrestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ToysRestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToysRestAppApplication.class, args);
    }

}
