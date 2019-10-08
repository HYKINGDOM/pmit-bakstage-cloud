package com.center.pmit.project.common.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import static com.center.pmit.project.common.util.DateUtils.getNowDate;

/**
 * 邮件对象类
 */
public class EmailObject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接收方邮件地址
     */
    private String[] receiveMailAddress;

    /**
     * 抄送人邮件地址
     */
    private String[] ccMailAddress;

    /**
     * 自定义邮件发送者
     */
    private String emailReceiveUserName;


    /**
     * 邮件主题
     */
    private String subjectMail;

    /**
     * 邮件内容
     */
    private String contentMail;

    /**
     * 邮件内联图片
     */
    private String imageMail;

    /**
     * 邮件附件设置
     */
    private String fileMail;

    /**
     * 邮件模板设置
     */
    private String templateMail;

    /**
     * 邮件发送时间
     */
    private Date sendMailDate;

    /**
     * 自定义参数
     */
    private Map<String, Object> kvMapMail;


    public String getEmailReceiveUserName() {
        return emailReceiveUserName;
    }

    public void setEmailReceiveUserName(String emailReceiveUserName) {
        this.emailReceiveUserName = emailReceiveUserName;
    }

    public Date getSendMailDate() {
        return sendMailDate;
    }

    /**
     * 默认当前时间
     */
    public void setSendMailDate() {
        this.sendMailDate = getNowDate();
    }

    public String[] getReceiveMailAddress() {
        return receiveMailAddress;
    }

    public void setReceiveMailAddress(String[] receiveMailAddress) {
        this.receiveMailAddress = receiveMailAddress;
    }

    public String[] getCcMailAddress() {
        return ccMailAddress;
    }

    public void setCcMailAddress(String[] ccMailAddress) {
        this.ccMailAddress = ccMailAddress;
    }

    public String getSubjectMail() {
        return subjectMail;
    }

    public void setSubjectMail(String subjectMail) {
        this.subjectMail = subjectMail;
    }

    public String getContentMail() {
        return contentMail;
    }

    public void setContentMail(String contentMail) {
        this.contentMail = contentMail;
    }

    public String getImageMail() {
        return imageMail;
    }

    public void setImageMail(String imageMail) {
        this.imageMail = imageMail;
    }

    public String getFileMail() {
        return fileMail;
    }

    public void setFileMail(String fileMail) {
        this.fileMail = fileMail;
    }

    public String getTemplateMail() {
        return templateMail;
    }

    public void setTemplateMail(String templateMail) {
        this.templateMail = templateMail;
    }

    public Map<String, Object> getKvMapMail() {
        return kvMapMail;
    }

    public void setKvMapMail(Map<String, Object> kvMapMail) {
        this.kvMapMail = kvMapMail;
    }
}
