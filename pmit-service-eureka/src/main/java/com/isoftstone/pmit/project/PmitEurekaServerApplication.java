package com.isoftstone.pmit.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PmitEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmitEurekaServerApplication.class, args);
    }

}
