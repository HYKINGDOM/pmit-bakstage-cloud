package com.galaxysoft.project.auth.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.galaxysoft.project.auth.security.component.PigAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 */
@JsonSerialize(using = PigAuth2ExceptionSerializer.class)
public class MethodNotAllowed extends PigAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
