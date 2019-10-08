package com.center.pmit.project.rabbitmq.service.email;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.center.pmit.project.common.constant.RabbitMqConstants.RABBIT_EXCHANGE_SELF_CHECKING_SEND_EMAIL_STREAM;
import static com.center.pmit.project.common.constant.RabbitMqConstants.RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL;


/**
 * 邮件发送端
 *
 * @author Administrator
 */
@Component
@Slf4j
public class EmailSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 邮件发送端
     *
     * @param object
     */
    public void sendEmailInfo(Object object) {
        this.rabbitTemplate.convertAndSend(RABBIT_EXCHANGE_SELF_CHECKING_SEND_EMAIL_STREAM, RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL, object);
    }
}
