package com.center.pmit.project.common.constant;

public class RabbitMqConstants {


    /********  邮件发送常量 **********/
    /**
     * 邮件发送的交换机标识
     */
    public final static String RABBIT_EXCHANGE_SELF_CHECKING_SEND_EMAIL_STREAM = "ExchangeToSendEmail";


    /**
     * 邮件发送的队列标识
     */
    public final static String RABBIT_QUEUES_SELF_CHECKING_SEND_EMAIL = "queuesToSendEmail";




    /********  邮件发送常量 **********/

    /**
     * 上传系统发送的交换机标识
     */
    public final static String RABBIT_EXCHANGE_SELF_CHECKING_UPLOAD_STREAM = "ExchangeToUpload";


    /**
     * 上传保存试卷队列标识
     */
    public final static String RABBIT_QUEUES_SELF_CHECKING_UPLOAD_SAVE = "queuesToUploadSave";



    /**
     * 上传系统发送的交换机标识
     */
    public final static String RABBIT_EXCHANGE_SELF_CHECKING_UPLOAD_DEAD_STREAM = "ExchangeToUploadDead";

    /**
     * 上传保存试卷死信队列标识
     */
    public final static String RABBIT_QUEUES_SELF_CHECKING_UPLOAD_SAVE_DEAD = "queuesToUploadSaveDead";
}
