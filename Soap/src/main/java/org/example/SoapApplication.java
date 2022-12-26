package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapApplication {
    public static void main(String[] args) {
        new SpringApplication(SoapApplication.class).run(args);
    }
}