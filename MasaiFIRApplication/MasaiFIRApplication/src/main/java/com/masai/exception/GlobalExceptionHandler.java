package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



/*
 GlobalException handler is the main exception handler class gives flexible to throw exceptions and 
 own derived response error details and we don't need to handle exceptions and response status code
 and details manually. We can create as many methods we want to handle exceptions here and every method 
 should return ResponseEntity<ErrorDetails> . 
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException exception, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails(); // for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now());// current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error
		
		error.setDetails(request.getDescription(false));// returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FirException.class)
	public ResponseEntity<MyErrorDetails> firExceptionHandler(FirException exception, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails(); // for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now());// current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error
		
		error.setDetails(request.getDescription(false));// returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	


//	LoginException method
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException exception, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
//	validation error exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodValidationExceptionHandler(MethodArgumentNotValidException exception){
		

		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getBindingResult().getFieldError().getDefaultMessage()); // Exception error 
		
		error.setDetails("validation fails"); // returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
//	Handler or Invalid URI exceptions
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> nohandlerFoundhandler(NoHandlerFoundException exception, WebRequest request){
		

		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
//	Default Exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception exception, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
