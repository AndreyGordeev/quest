package com.andreiy.gordeev.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.andreiy.gordeev")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
