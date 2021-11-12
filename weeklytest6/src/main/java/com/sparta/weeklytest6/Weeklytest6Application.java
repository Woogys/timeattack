package com.sparta.weeklytest6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Weeklytest6Application {

    public static void main(String[] args) {
        SpringApplication.run(Weeklytest6Application.class, args);
    }

}
