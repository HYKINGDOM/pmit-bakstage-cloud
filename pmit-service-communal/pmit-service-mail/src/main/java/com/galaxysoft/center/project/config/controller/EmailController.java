package com.galaxysoft.center.project.config.controller;

import com.center.pmit.project.common.pojo.EmailObject;
import com.center.pmit.project.common.util.JsonUtils;
import com.center.pmit.project.common.web.controller.AbstractCustomResult;
import com.galaxysoft.center.project.config.service.IMailService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.galaxysoft.center.project.config.util.EmailConstants.EMAIL_RECEIVE_USER_NAME_PM_IT;

/**
 * @author Administrator
 */
@Slf4j
@RestController
@RequestMapping(value = "/email")
public class EmailController extends AbstractCustomResult {

    @Autowired
    private IMailService iMailService;


    @GetMapping(value = "/sendEmailInfoTest")
    public void sendEmailInfo() {
        EmailObject emailObject = new EmailObject();
        emailObject.setReceiveMailAddress(new String[]{"yihur@galaxysoft.com"});
        emailObject.setCcMailAddress(new String[]{"llzhaon@galaxysoft.com"});
        emailObject.setSubjectMail("这是一封测试邮件");
        emailObject.setContentMail("这是邮件内容");
        emailObject.setTemplateMail("message.ftl");
        emailObject.setImageMail("springcloud.png");
        emailObject.setFileMail("eqweqdasdasddasdasdasdasdasdasdasdasdasdweqwe.xls");
        emailObject.setEmailReceiveUserName(EMAIL_RECEIVE_USER_NAME_PM_IT);
        Map<String, Object> map = new HashMap<>(3);
        map.put("messageCode", 500);
        map.put("MessageStatus", "正常");
        map.put("Cause", "邮件已发送");
        emailObject.setKvMapMail(map);
        iMailService.sendHtml(emailObject);
    }


    @HystrixCommand(fallbackMethod = "hystrixError")
    @PostMapping(value = "/sendEmail")
    public void sendEmailInfoByMq(@RequestBody String parameter) {
        try {
            log.info("邮件发送接收到的参数:{}", parameter);
            EmailObject paramMap = JsonUtils.readValue(parameter, EmailObject.class);
            iMailService.send(paramMap);
        } catch (Exception e) {
            throw new RuntimeException("邮件服务调用异常");
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
