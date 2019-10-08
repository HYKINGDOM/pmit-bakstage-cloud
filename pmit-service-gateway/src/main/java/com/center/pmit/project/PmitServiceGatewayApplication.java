package com.center.pmit.project;

import com.center.pmit.project.common.util.JsonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@EnableCaching
@SpringBootApplication
@EnableEurekaClient
@RestController
public class PmitServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmitServiceGatewayApplication.class, args);
    }


    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("请求超时请稍后再试!!!");
    }


    /**
     * 用户没有登陆需要先登录
     * @return
     */
    @GetMapping("/returnLogin")
    public String returnLogin() {
        Map<String,Object> map = new HashMap<>(4);
        map.put("code",801);
        map.put("data",null);
        map.put("message","请先新登录!!!");
        return JsonUtils.toJSON(map);
    }


    /**
     * 用户session过期需要重新登陆
     * @return
     */
    @GetMapping("/returnAgainLogin")
    public String returnAgainLogin() {
        Map<String,Object> map = new HashMap<>(4);
        map.put("code",802);
        map.put("data",null);
        map.put("message","登录过期请重新登录!!");
        return JsonUtils.toJSON(map);
    }
}
