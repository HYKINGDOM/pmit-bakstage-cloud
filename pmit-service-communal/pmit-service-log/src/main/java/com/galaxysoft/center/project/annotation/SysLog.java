package com.galaxysoft.center.project.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 * @author Administrator
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 描述
	 *
	 * @return {String}
	 */
	String value();
}
