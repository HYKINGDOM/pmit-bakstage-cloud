package com.center.pmit.project.common.exception;

import com.center.pmit.project.common.web.controller.AbstractCustomResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.concurrent.Callable;

import static com.center.pmit.project.common.constant.CustomResult.*;

/**
 * 全局的的异常处理器
 * @author Administrator
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends AbstractCustomResult {
	/**
	 * 全局异常.
	 *
	 * @param e the e
	 * @return R
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Callable<Object> exception(Exception e) {
		log.error("全局异常信息 ex={}", e.getMessage(), e);
		return returnGlobalException(RETURN_RESULT_STATUS_CODE_SERVER_EXCEPTION,e.getMessage(),"请求异常!请返回登录重试!");
	}

	/**
	 * validation Exception 验证异常
	 *
	 * @param exception
	 * @return R
	 */
	@ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Callable<Object> bodyValidExceptionHandler(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.warn(fieldErrors.get(0).getDefaultMessage());
		return returnGlobalException(RETURN_RESULT_STATUS_CODE_BAD_REQUEST,fieldErrors.get(0).getDefaultMessage(),"验证失败请重试!");
	}

}
