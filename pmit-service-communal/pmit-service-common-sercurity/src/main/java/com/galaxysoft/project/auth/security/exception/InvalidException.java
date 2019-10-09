package com.galaxysoft.project.auth.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.galaxysoft.project.auth.security.component.PigAuth2ExceptionSerializer;

/**
 * @author Administrator
 */
@JsonSerialize(using = PigAuth2ExceptionSerializer.class)
public class InvalidException extends PigAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
