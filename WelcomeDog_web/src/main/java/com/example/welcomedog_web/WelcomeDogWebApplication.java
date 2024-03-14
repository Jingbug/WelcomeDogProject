package com.example.welcomedog_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.welcomedog_core", "com.example.welcomedog_web"})
public class WelcomeDogWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WelcomeDogWebApplication.class, args);
    }
}
