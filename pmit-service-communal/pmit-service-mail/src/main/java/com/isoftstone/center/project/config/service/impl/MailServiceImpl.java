package com.galaxysoft.center.project.config.service.impl;


import com.center.pmit.project.common.pojo.EmailObject;
import com.galaxysoft.center.project.config.queue.MailQueue;
import com.galaxysoft.center.project.config.service.IMailService;
import com.galaxysoft.center.project.config.util.EmailConstants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;


/**
 * @author Administrator
 */
@Service
public class MailServiceImpl implements IMailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration configuration;


    /**
     * //发送者
     */
    @Value("${spring.mail.username}")
    public String receiveMailUserName;


    /**
     * 取消附件名太长导致的截断错误
     */
    static {
        System.setProperty("mail.mime.splitlongparameters", "false");
    }

    @Override
    public void send(EmailObject mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(receiveMailUserName);
        message.setTo(mail.getReceiveMailAddress());
        message.setCc(mail.getCcMailAddress());
        message.setSubject(mail.getSubjectMail());
        message.setText(mail.getContentMail());
        javaMailSender.send(message);
    }

    @Override
    public void sendHtml(EmailObject mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //这里可以自定义邮件发送者
            helper.setFrom(receiveMailUserName, mail.getEmailReceiveUserName());
            helper.setTo(mail.getReceiveMailAddress());
            helper.setSubject(mail.getSubjectMail());
            helper.setCc(mail.getCcMailAddress());

            // 发送内联图片
            String imageMail = mail.getImageMail();
            helper.setText("<html><body><img src=\"cid:" + imageMail + "\" ></body></html>", true);
            File file = ResourceUtils.getFile("classpath:static"
                    + EmailConstants.SF_FILE_SEPARATOR + "image"
                    + EmailConstants.SF_FILE_SEPARATOR + imageMail);
            helper.addInline(imageMail, file);

            // 发送附件
            String fileMail = mail.getFileMail();
            file = ResourceUtils.getFile("classpath:static"
                    + EmailConstants.SF_FILE_SEPARATOR + "file"
                    + EmailConstants.SF_FILE_SEPARATOR + fileMail);
            helper.addAttachment(fileMail, file);
            javaMailSender.send(message);

        } catch (UnsupportedEncodingException | FileNotFoundException | MessagingException e) {
            logger.error("发送失败:" + mail + ":" + e.getMessage());
        }
    }

    @Override
    public void sendFreemarker(EmailObject mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //这里可以自定义发信名称,不是邮件标题
            helper.setFrom(receiveMailUserName, mail.getEmailReceiveUserName());
            helper.setTo(mail.getReceiveMailAddress());
            helper.setSubject(mail.getSubjectMail());
            configuration.setClassForTemplateLoading(this.getClass(), "/static/template");
            configuration.setEncoding(Locale.getDefault(), "UTF-8");
            Locale.setDefault(Locale.ENGLISH);
            Template template = configuration.getTemplate(mail.getTemplateMail(), "UTF-8");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getKvMapMail());
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (MessagingException | TemplateException | IOException e) {
            logger.error("发送失败:" + mail + ":" + e.getMessage());
        }
    }

    @Override
    public void sendQueue(EmailObject mail) {
        try {
            MailQueue.getMailQueue().produce(mail);
        } catch (InterruptedException e) {
            logger.error("发送失败:" + mail + ":" + e.getMessage());
        }
    }

    @Override
    public void sendRedisQueue(EmailObject mail) {

    }

}
