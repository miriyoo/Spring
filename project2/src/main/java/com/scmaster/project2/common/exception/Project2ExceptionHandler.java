package com.scmaster.project2.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Project2ExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e){
		e.printStackTrace();
		
		return "/error";
	}
}
