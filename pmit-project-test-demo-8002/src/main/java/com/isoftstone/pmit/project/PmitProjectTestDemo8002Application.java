package com.isoftstone.pmit.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PmitProjectTestDemo8002Application {

    public static void main(String[] args) {
        SpringApplication.run(PmitProjectTestDemo8002Application.class, args);
    }

}
