package com.center.pmit.project.rabbitmq.topic;

import org.springframework.context.annotation.Configuration;

/**
 * Topic Exchange 转发消息主要是根据通配符。在这种交换机下，队列列和交换机的绑定会定义⼀一种路路由模式，
 * 那么，通配符就要在这种路路由模式和路路由键之间匹配后交换机才能转发消息。
 * @author Administrator
 */
@Configuration
public class TopicRabbitConfig {

//    final static String message = "topic.message";
//    final static String messages = "topic.messages";
//
//    @Bean
//    public Queue queueMessage() {
//        return new Queue(TopicRabbitConfig.message);
//    }
//
//    @Bean
//    public Queue queueMessages() {
//        return new Queue(TopicRabbitConfig.messages);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("topicExchange");
//    }
//
//    @Bean
//    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }
//
//
//    @Bean
//    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.messages");
//    }

//    /**
//     * # 是通配符表示零个或者多个词
//     * @param queueMessages
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
//    }
}
