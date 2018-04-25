package com.magneto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MagnetoApp {

    public static void main(String[] args) {
        SpringApplication.run(MagnetoApp.class, args);
    }
}
