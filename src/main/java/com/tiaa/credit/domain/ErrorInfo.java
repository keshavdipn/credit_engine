package com.tiaa.credit.domain;

public class ErrorInfo {
	
	private String message;
	private String description;
	
	public ErrorInfo(String message){
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
