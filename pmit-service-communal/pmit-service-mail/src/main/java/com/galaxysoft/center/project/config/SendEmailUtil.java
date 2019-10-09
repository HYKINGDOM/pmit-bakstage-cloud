package com.galaxysoft.center.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 *
 * 旧版邮件发送配置类
 *
 * @author blliul
 * @date 2018-12-31
 */
@Component
public class SendEmailUtil {


    /**
     * 发件箱密码
     */
    @Value("${emailconfig.emailAccount}")
    private String emailAccount;

    /**
     * 发件箱密码
     */
    @Value("${emailconfig.emailPassword}")
    private String emialPassword;

    /**
     * 发件箱SMTP配置
     */
    @Value("${emailconfig.myEmailSMTPHost}")
    private String emailSMTPHost;

    /**
     * 发邮件服务器地址
     */
    @Value("${emailconfig.serverIP}")
    private String emailServerIP;

    /**
     * 不带抄送人的发件
     *
     * @param receiveMailAccountList 收件人邮箱列表
     * @param subject                邮件标题
     * @param tempContent            邮件正文内容
     * @param excelList              附件内容
     */
    public void sendEmail(List<String> receiveMailAccountList, String subject, String tempContent, List<File> excelList) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String localIP = address.getHostAddress();
            String tempAllContent = tempContent + "<br/>" + "-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~ " + "<br/>" + "这是一封系统的邮件，请勿直接回复！" + "<br/>" + "-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~";
            if (localIP.equals(emailServerIP)) {
                if (null == receiveMailAccountList || receiveMailAccountList.size() < 1) {
                    return;
                }
                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.host", emailSMTPHost);
                Session session = Session.getDefaultInstance(props);
                session.setDebug(false);
                /* 关闭限制附件过长（附件名过长而被被截断，导致接收端解析失败的异常） */
                System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
                /* 创建一封邮件 */
                MimeMessage message = createMimeMessage(session, receiveMailAccountList, subject, tempAllContent, excelList);
                /* 根据 Session 获取邮件传输对象 */
                Transport transport = session.getTransport();
                /* 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错 */
                transport.connect(emailAccount, emialPassword);
                /*
                 * 发送邮件, 发到所有的收件地址, message.getAllRecipients()
                 * 获取到的是在创建邮件对象时添加的所有收件人,抄送人, 密送人
                 */
                transport.sendMessage(message, message.getAllRecipients());
                /* 关闭连接 */
                transport.close();
            }
        } catch (UnknownHostException | MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建一封只包含附件与文本的邮件
     *
     * @param session                和服务器交互的会话
     * @param receiveMailAccountList 收件人邮箱列表
     * @param subject                邮件标题
     * @param tempContent            邮件内容
     * @return
     */
    public MimeMessage createMimeMessage(Session session, List<String> receiveMailAccountList,
                                         String subject, String tempContent,
                                         List<File> excelList) {
        /* 创建邮件 */
        MimeMessage message = new MimeMessage(session);
        try {
            /* 添加发件人 */
            dealWithSimple(receiveMailAccountList, message);
            /* 设置邮件标题 */
            message.addHeader("charset", "UTF-8");
            message.setSubject(subject, "UTF-8");
            /* 设置邮件内容 */
            dealWithSimplar2(tempContent, excelList, message);

        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * @param tempContent
     * @param excelList
     * @param message
     * @throws MessagingException
     */
    private void dealWithSimplar2(String tempContent, List<File> excelList, MimeMessage message){

        try{
            Multipart multipart = new MimeMultipart();
            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setText(tempContent, "UTF-8");
            contentPart.setHeader("Content-Type", "text/html; charset=UTF-8");
            multipart.addBodyPart(contentPart);
            if (null != excelList && excelList.size() > 0) {
                for (File file : excelList) {
                    /* 添加附件 */
                    MimeBodyPart fileBody = new MimeBodyPart();
                    DataSource source = new FileDataSource(file);
                    fileBody.setDataHandler(new DataHandler(source));
                    String fileName = file.getName();
                    if (!"".equals(fileName) && fileName.contains("V1.1")) {
                        fileName = fileName.substring(fileName.lastIndexOf("附"), fileName.lastIndexOf("V1.1") + 4) + ".docx";
                    }
                    try {
                        fileName = MimeUtility.encodeText(fileName);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    fileBody.setFileName(fileName);
                    multipart.addBodyPart(fileBody);
                }
            }
            /* 邮件正文（包含附件） */
            message.setContent(multipart);
            /* 设置发件时间 */
            message.setSentDate(new Date());
            /* 保存设置 */
            message.saveChanges();

        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 带抄送人的发送邮件方法
     *
     * @param receiveMailAccountList   收件人
     * @param receiveCCMailAccountList 抄送人
     * @param subject                  标题
     * @param tempContent              内容
     * @param excelList                附件
     */
    public void sendCCEmail(List<String> receiveMailAccountList, List<String> receiveCCMailAccountList,
                            String subject, String tempContent,
                            List<File> excelList) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String localIp = address.getHostAddress();
            if (localIp.equals(emailServerIP)) {
                if (null == receiveMailAccountList || receiveMailAccountList.size() < 1) {
                    System.out.println("收件人为空!");
                    return;
                }
                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");
                props.setProperty("mail.smtp.host", emailSMTPHost);
                props.setProperty("mail.smtp.auth", "true");
                Session session = Session.getDefaultInstance(props);
                session.setDebug(false);
                /* 关闭限制附件过长（附件名过长而被被截断，导致接收端解析失败的异常） */
                System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
                MimeMessage message = null;
                if (null == receiveCCMailAccountList || receiveCCMailAccountList.size() < 1) {
                    message = createMimeMessage(session, receiveMailAccountList, subject, tempContent, excelList);
                } else {
                    message = createCCMimeMessage(session,receiveMailAccountList, receiveCCMailAccountList, subject, tempContent, excelList);
                }
                Transport transport;
                transport = session.getTransport();
                transport.connect(emailAccount, emialPassword);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
        } catch (MessagingException | UnknownHostException e) {
            e.printStackTrace();
        }

    }


    /**
     * 创建一封包含附件与文本和抄送人的邮件
     *
     * @param session                  和服务器会话
     * @param receiveMailAccountList   收件人邮箱
     * @param receiveCCMailAccountList 抄送人邮箱
     * @param subject                  邮件标题
     * @param tempContent              邮件内容
     * @param excelList                Excel附件
     * @return message
     */
    public MimeMessage createCCMimeMessage(Session session, List<String> receiveMailAccountList, List<String> receiveCCMailAccountList, String subject, String tempContent, List<File> excelList) {
        /* 创建邮件 */
        MimeMessage message = new MimeMessage(session);
        try {
            dealWithSimple(receiveMailAccountList, message);
            for (String s : receiveCCMailAccountList) {
                message.addRecipient(MimeMessage.RecipientType.CC,
                        new InternetAddress(s,
                                s, "UTF-8"));
            }
            /* 设置邮件标题 */
            message.setSubject(subject, "UTF-8");
            message.addHeader("charset", "UTF-8");
            /* 设置邮件内容 */
            dealWithSimplar2(tempContent, excelList, message);

        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * @param receiveMailAccountList
     * @param message
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private void dealWithSimple(List<String> receiveMailAccountList, MimeMessage message) throws MessagingException, UnsupportedEncodingException {
        /* 添加发件人 */
        message.setFrom(new InternetAddress(emailAccount, emailAccount,
                "UTF-8"));
        /* 添加收件人 */
        for (String s : receiveMailAccountList) {
            message.addRecipient(MimeMessage.RecipientType.TO,
                    new InternetAddress(s,
                            s, "UTF-8"));
        }
    }

}
