package com.tiaa.credit.controller.advise;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tiaa.credit.domain.ErrorInfo;
import com.tiaa.credit.exception.InvalidRequestException;

@EnableWebMvc
@ControllerAdvice
public class ControllerAdvise {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo handleBadRequest(HttpRequest request , InvalidRequestException exception){
		
		return new ErrorInfo(exception.getMessage());
	}

}
