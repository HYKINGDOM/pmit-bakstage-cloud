package com.galaxysoft.center.project.queue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author Administrator
 */
@Slf4j
@Component
public class RabbitMqQueueMailReceiver {

//    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic.message"), exchange = @Exchange("topicExchange")))
//    public void process(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
//
//        try {
//            log.info("收到消息: {}", message.toString());
//            log.info("接收到的参数为: {}", Arrays.toString(message.getBody()));
//            String str = new String(message.getBody(), StandardCharsets.UTF_8);
//            List<String> list = JSON.parseObject(str, List.class);
//
//            System.out.println(Arrays.toString(list.toArray()));
//
//            EmailObject emailObject = new EmailObject();
//            emailObject.setReceiveMailAddress(new String[]{list.get(0)});
//            emailObject.setCcMailAddress(new String[]{list.get(1)});
//            emailObject.setSubjectMail("这是一封MQ测试邮件");
//            emailObject.setContentMail("邮件内容");
//            emailObject.setTemplateMail("message.ftl");
//            emailObject.setImageMail("springcloud.png");
//            emailObject.setFileMail("eqweqdasdasddasdasdasdasdasdasdasdasdasdweqwe.xls");
//            emailObject.setEmailReceiveUserName(EMAIL_RECEIVE_USER_NAME_PM_IT);
//            Map<String, Object> map = new HashMap<>(3);
//            map.put("messageCode", 500);
//            map.put("MessageStatus", "正常");
//            map.put("Cause", "邮件已发送");
//            emailObject.setKvMapMail(map);
//            iMailService.send(emailObject);
//
//            log.info("send mail message ---> ReceiveMailAddress : {} , CcMailAddress : {} ", list.get(0), list.get(1));
//            System.out.println("Topic Receiver1  : " + str);
//        } catch (Exception e){
//            log.error("logUserConsumer error", e);
//            channel.basicNack(tag, false, true);
//        } finally {
//            channel.basicAck(tag, false);
//        }
//
//    }


}
