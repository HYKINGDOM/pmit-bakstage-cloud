package com.center.pmit.project.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String message) {
        System.out.println("rabbitmq Receiver A: " + message);
    }

}
