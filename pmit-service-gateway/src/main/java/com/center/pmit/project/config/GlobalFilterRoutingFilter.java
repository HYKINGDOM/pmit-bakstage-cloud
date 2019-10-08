package com.center.pmit.project.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
@Slf4j
@Component
public class GlobalFilterRoutingFilter implements GlobalFilter, Ordered {

    private String redisSession = "spring:session:sessions:";


    @Autowired
    private RedisService redisService;

    /**
     * 用户session过期配置,跳转登录
     * @param serverWebExchange
     * @param gatewayFilterChain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        RequestPath path = request.getPath();
        log.info("path:{}", path.toString());
        ServerHttpResponse response = serverWebExchange.getResponse();
        HttpHeaders headers = request.getHeaders();
        List<String> cookie = headers.get("Cookie");
        log.info("用户Cookie:{}", cookie);
        if (!path.toString().contains("login")) {
            if (cookie != null) {
                String sessionId = cookie.get(0).replace("SESSION=", "");
                String key = redisSession + sessionId;
                Object redisSession = redisService.hget(key, "sessionAttr:sessionLoginIdKey");
                log.info("redis中的session:{}", redisSession);
                if (redisSession == null || !redisSession.toString().contains(sessionId)) {
                    String url = "/returnAgainLogin";
                    response.setStatusCode(HttpStatus.SEE_OTHER);
                    response.getHeaders().set(HttpHeaders.LOCATION, url);
                    return response.setComplete();
                }
            } else {
                String url = "/returnLogin";
                response.setStatusCode(HttpStatus.SEE_OTHER);
                response.getHeaders().set(HttpHeaders.LOCATION, url);
                return response.setComplete();
            }
        }


        return gatewayFilterChain.filter(serverWebExchange);
    }


    @Override
    public int getOrder() {
        return -300;
    }
}
