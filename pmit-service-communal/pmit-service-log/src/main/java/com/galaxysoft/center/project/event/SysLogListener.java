package com.galaxysoft.center.project.event;

import com.galaxysoft.center.project.annotation.SysLog;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;


/**
 *
 * 异步监听日志事件
 * @author Administrator
 */
@Slf4j
@AllArgsConstructor
public class SysLogListener {

	@Async
	@Order
	@EventListener(SysLogEvent.class)
	public void saveSysLog(SysLogEvent event) {
		SysLog sysLog = (SysLog) event.getSource();
		log.info("日志记录:{}",sysLog);
	}
}
