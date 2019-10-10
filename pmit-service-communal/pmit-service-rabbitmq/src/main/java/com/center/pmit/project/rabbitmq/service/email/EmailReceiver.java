package com.center.pmit.project.rabbitmq.service.email;


import com.center.pmit.project.common.util.JsonUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.center.pmit.project.common.constant.RabbitMqConstants.RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL;

/**
 * 邮件消费端
 *
 * @author Administrator
 */
@Component
@Slf4j
public class EmailReceiver {

    @Autowired
    private EmailSendService emailSendService;

    @RabbitListener(queues = RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL)
    public void processEmailReceiver(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        try {
            log.info("接收端开始准备参数");
            EmailObject paramMap = JsonUtils.readValue(new String(message.getBody(), StandardCharsets.UTF_8), EmailObject.class);
            log.info("准备发送数据:{}", paramMap);
            String processEmailReceiver = emailSendService.processEmailReceiver(paramMap);
            log.info("邮件接收端日志记录,队列标识：{},数据内容：{},邮件发送时间：{}", RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL, message, System.currentTimeMillis());
        } catch (Exception e) {
            log.error("processEmailReceiver error", e);
            channel.basicNack(tag, false, true);
        } finally {
            channel.basicAck(tag, false);
        }
    }
}
