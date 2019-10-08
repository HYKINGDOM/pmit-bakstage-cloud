package com.galaxysoft.center.project.event;


import com.galaxysoft.center.project.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author Administrator
 * 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}
}
