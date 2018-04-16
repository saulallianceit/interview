package com.example.interview.interview.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

	private static final String ISE_VIEW = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalError(){
		return ISE_VIEW;
	}
}