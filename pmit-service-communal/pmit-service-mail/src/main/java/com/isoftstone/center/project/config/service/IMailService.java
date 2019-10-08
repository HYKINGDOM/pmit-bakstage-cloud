package com.galaxysoft.center.project.config.service;


import com.center.pmit.project.common.pojo.EmailObject;

/**
 * @author Administrator
 */
public interface IMailService {
	/**
	 * 纯文本
	 * @param mail
	 */
	 void send(EmailObject mail);

	/**
	 * 富文本
	 * @param mail
	 */
	  void sendHtml(EmailObject mail);

	/**
	 * 模版发送 freemarker
	 * @param mail
	 */
	  void sendFreemarker(EmailObject mail);

	/**
	 * 队列
	 * @param mail
	 */
	 void sendQueue(EmailObject mail);

	/**
	 * Redis 队列
	 * @param mail
	 * @throws Exception
	 */
	 void sendRedisQueue(EmailObject mail) throws Exception;

}
