package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;




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
	



	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException exception, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodValidationExceptionHandler(MethodArgumentNotValidException exception){
		

		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getBindingResult().getFieldError().getDefaultMessage()); // Exception error 
		
		error.setDetails("validation fails"); // returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> nohandlerFoundhandler(NoHandlerFoundException exception, WebRequest request){
		

		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception exception, WebRequest request){
		
		MyErrorDetails error = new MyErrorDetails();// for sending user understandable format of exceptions and errors
		
		error.setTimestamp(LocalDateTime.now()); // current time when exception happen
		
		error.setErrorMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
