package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
// hi

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MainProgram {
    public static void main(String[] args) {
        SpringApplication.run(MainProgram.class, args);
    }

}
