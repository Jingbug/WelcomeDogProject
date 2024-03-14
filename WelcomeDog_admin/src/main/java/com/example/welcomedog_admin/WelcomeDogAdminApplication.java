package com.example.welcomedog_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.welcomedog_core", "com.example.welcomedog_admin"})
public class WelcomeDogAdminApplication {
    public static void main(String[] args) { SpringApplication.run(WelcomeDogAdminApplication.class, args); }
}
