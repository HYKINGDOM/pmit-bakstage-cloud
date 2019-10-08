package com.center.pmit.project.rabbitmq.controller;


import com.center.pmit.project.common.pojo.EmailObject;
import com.center.pmit.project.common.util.JsonUtils;
import com.center.pmit.project.rabbitmq.service.email.EmailSender;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@Slf4j
@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMqController {


    @Autowired
    private EmailSender emailSender;

    @GetMapping(value = "/sendMailTest")
    public String sendMailQueue() {
        EmailObject emailObject = new EmailObject();
        emailObject.setCcMailAddress(new String[]{"yihur@galaxysoft.com","llzhaon@galaxysoft.com"});
        emailObject.setReceiveMailAddress(new String[]{"yihur@galaxysoft.com","llzhaon@galaxysoft.com"});
        emailObject.setContentMail("测试邮件");
        emailObject.setEmailReceiveUserName("用户邮件额测试");
        emailObject.setSubjectMail("这是一封测试邮件");
        return JsonUtils.toJSON(emailObject);
    }


    @HystrixCommand(fallbackMethod = "hystrixError")
    @PostMapping(value = "/sendMail")
    public String sendMailQueue(@RequestBody String parameter) {
        try {
            EmailObject paramMap = JsonUtils.readValue(parameter, EmailObject.class);
            emailSender.sendEmailInfo(paramMap);
            log.info("服务调用接收到的参数:{}", paramMap);
            return "邮件进入队列";
        } catch (Exception e) {
            throw new RuntimeException("队列服务调用异常");
        }
    }


    /**
     * hystrix 服务失败跳转到此
     *
     * @return string
     */
    public String hystrixError(String parameter) {
        log.info("服务调用失败进入熔断:{}", parameter);
        return "FeignHystrix / hystrix(): Service Unavailable" + parameter;
    }

}
