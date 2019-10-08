package com.center.pmit.project.rabbitmq.topic;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class TopicSender {

	private final static String QUEUE_NAME = "hello";

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private CachingConnectionFactory connectionFactory;

	/**
	 * convertAndSend参数(交换机,routing key(路由),消息参数)
	 */
	public void send() {
		try{
			ConnectionFactory factory = new ConnectionFactory();
			// 设置MabbitMQ所在主机ip或者主机名
			//factory.setHost("127.0.0.1");
			// 创建一个连接
			Connection connection = factory.newConnection();
			// 创建一个频道
			Channel channel = connection.createChannel();
			// 指定一个队列
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			int prefetchCount = 1;
			//限制发给同一个消费者不得超过1条消息
			channel.basicQos(prefetchCount);
			for (int i = 0; i < 5; i++) {
				// 发送的消息
				String message = "Hello World"+".";
				// 往队列中发出一条消息
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
				System.out.println(" [x] Sent '" + message + "'");
			}
			// 关闭频道和连接
			channel.close();
			connection.close();
		}catch (TimeoutException | IOException e) {
			e.printStackTrace();
		}
	}


	public void recovercy(){
		try {
			ConnectionFactory factory = new ConnectionFactory();
			// 打开连接和创建频道，与发送端一样
			Connection connection = factory.newConnection();
			final Channel channel = connection.createChannel();

			// 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
			//保证一次只分发一个
			channel.basicQos(1);
			// 创建队列消费者
			final Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, StandardCharsets.UTF_8);

					System.out.println(" [x] Received '" + message + "'");
					try {
						for (char ch: message.toCharArray()) {
							if (ch == '.') {
								Thread.sleep(1000);
							}
						}
					} catch (InterruptedException ignored) {
						log.error(ignored.toString());
					} finally {
						System.out.println(" [x] Done! at " +new Date().toString());
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}
			};
			channel.basicConsume(QUEUE_NAME, false, consumer);
		} catch (TimeoutException | IOException e) {
			e.printStackTrace();
		}
	}





	public void send1() {

		List<String> list = new ArrayList<>();
		list.add("yihur@galaxysoft.com");
		list.add("llzhaon@galaxysoft.com");
		System.out.println("Sender : " + "send1");
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", list);

	}




	public void send2() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		System.out.println("Sender : " + "send2");
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}

}