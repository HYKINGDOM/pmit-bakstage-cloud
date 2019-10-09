package com.galaxysoft.project.auth.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.galaxysoft.project.auth.security.component.PigAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 */
@JsonSerialize(using = PigAuth2ExceptionSerializer.class)
public class ForbiddenException extends PigAuth2Exception {

	public ForbiddenException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}

