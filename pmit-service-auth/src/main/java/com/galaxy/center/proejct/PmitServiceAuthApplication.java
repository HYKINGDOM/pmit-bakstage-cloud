package com.galaxy.center.proejct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringCloudApplication
@EnableAuthorizationServer
@MapperScan("com.galaxy.center.proejct.dao")
public class PmitServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmitServiceAuthApplication.class, args);
    }

}
