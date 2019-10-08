package com.center.pmit.project.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String message) {
        System.out.println("rabbitmq Receiver C: " + message);
    }

}
