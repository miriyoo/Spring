package com.scmaster.web6.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Web6ExceptionHandler {
	
	@ExceptionHandler(Exception.class) // 모든 예외를 포함, 나누고 싶다면 종류별로 나눠서 처리
	public String errorHandler(Exception e){
		e.printStackTrace();
		
		return "/error";
	}
}
