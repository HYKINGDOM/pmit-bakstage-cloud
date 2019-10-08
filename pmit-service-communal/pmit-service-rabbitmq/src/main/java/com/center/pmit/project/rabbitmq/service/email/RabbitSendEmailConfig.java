package com.center.pmit.project.rabbitmq.service.email;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.center.pmit.project.common.constant.RabbitMqConstants.RABBIT_EXCHANGE_SELF_CHECKING_SEND_EMAIL_STREAM;
import static com.center.pmit.project.common.constant.RabbitMqConstants.RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL;

/**
 * 配置交换机和队列的绑定
 * @author Administrator
 */
@Configuration
public class RabbitSendEmailConfig {


    /**
     * 配置邮件队列
     * @return
     */
    @Bean
    public Queue queueSendEmailMessage() {
        return new Queue(RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL);
    }

    /**
     * 配置邮件交换机
     * @return
     */
    @Bean
    TopicExchange exchangeToEmail() {
        return new TopicExchange(RABBIT_EXCHANGE_SELF_CHECKING_SEND_EMAIL_STREAM);
    }

    /**
     * 交换机绑定队列
     * @param queueSendEmailMessage
     * @param exchangeToEmail
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueSendEmailMessage, TopicExchange exchangeToEmail) {
        return BindingBuilder.bind(queueSendEmailMessage).to(exchangeToEmail).with(RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL);
    }
}
