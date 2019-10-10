package com.galaxysoft.pmit.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
@SpringBootApplication
public class PmitServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmitServiceZuulApplication.class, args);
    }

}
