package com.galaxysoft.center.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
public class PmitServiceMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmitServiceMailApplication.class, args);
    }

}
