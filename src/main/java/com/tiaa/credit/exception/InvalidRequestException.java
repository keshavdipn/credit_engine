package com.tiaa.credit.exception;

public class InvalidRequestException extends RuntimeException{

	public InvalidRequestException(){
		super("Invalid Credit card Type");
	}
}
