package com.center.pmit.project.rabbitmq.service.email;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 配置邮件服务调用接口
 *
 * @author Administrator
 */
@Component
@FeignClient(name = "PMIT-SERVICE-MAIL", fallback = EmailSendServiceImpl.class)
public interface EmailSendService {


    /**
     * 邮件发送请求的消费
     *
     * @param object
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/email/sendEmail", produces = "application/json;charset=UTF-8")
    String processEmailReceiver(Object object);
}
