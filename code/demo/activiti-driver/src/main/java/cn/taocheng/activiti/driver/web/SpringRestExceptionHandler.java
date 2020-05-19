/**
 * Program  : SpringExceptionHandle.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 2:54:03 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SpringRestExceptionHandler {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ResponseState> handleDefaultException(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<ResponseState>(
				new ResponseState(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
