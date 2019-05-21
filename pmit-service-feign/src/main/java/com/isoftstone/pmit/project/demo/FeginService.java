package com.isoftstone.pmit.project.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yihur
 * 使用@FeignClient 注解加上调用服务的名称 下面就可以优雅的进行服务之间的调用
 */
@FeignClient("pmit-project-test-demo")
public interface FeginService {

    @RequestMapping(method = RequestMethod.GET, value = "/demo/getNowDate")
    String getNowDate();
}
