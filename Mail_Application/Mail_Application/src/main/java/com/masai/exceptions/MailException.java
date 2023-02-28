package com.masai.exceptions;

public class MailException extends RuntimeException{
	
	public MailException() {
		
	}
	
	public MailException(String str) {
		super(str);
	}

}
