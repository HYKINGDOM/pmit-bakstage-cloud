package com.isoftstone.pmit.project.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/www")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 注意这里URL不能为IP加端口号，应该是模块的实例名，而且模块的名字不能是下划线间隔否则会报错
     * 只有这样 ribbon 负载均衡才真正使用上，当运行多个相同模块实例的时候，负载均衡算法才会根据在注册中心的实例名进行请求的分配
     *
     * 这个demo针对于模块之间的调用方法
     *
     * 服务名映射到ip:port的，映射的功能是由@loadbalancer注解来实现的
     * @return
     */
    @GetMapping(value = "/getNowDate")
    public String getRibbonNowDate() {
        String url = "http://pmit-project-test-demo/demo/getNowDate";
        String forObject = restTemplate.getForObject(url, String.class);
        return "当前时间为--"+forObject+";返回数据模块为Ribbon";
    }
}
