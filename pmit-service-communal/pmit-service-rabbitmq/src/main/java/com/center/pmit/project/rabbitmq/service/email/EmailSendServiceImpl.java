package com.center.pmit.project.rabbitmq.service.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 配置断路器
 *
 * @author Administrator
 */
@Component
@Slf4j
public class EmailSendServiceImpl implements EmailSendService {


    @Override
    public String processEmailReceiver(Object object) {
        log.error("邮件发送进入熔断:{}", object);
        return "邮件发送进入熔断";
    }

}
