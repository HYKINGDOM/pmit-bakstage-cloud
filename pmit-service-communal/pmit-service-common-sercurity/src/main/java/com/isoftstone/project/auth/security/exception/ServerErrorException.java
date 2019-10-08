package com.galaxysoft.project.auth.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.galaxysoft.project.auth.security.component.PigAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 */
@JsonSerialize(using = PigAuth2ExceptionSerializer.class)
public class ServerErrorException extends PigAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
