package com.xebia.spring4_XTR.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(annotations = RestController.class)
class ApiExceptionHandlerAdvice{
 
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> exception(Exception exception, WebRequest request) {
    	System.out.println("Exception :"+exception.getMessage());
    	return new ResponseEntity<String>("Api ExceptionHandler Advice : " +  HttpStatus.EXPECTATION_FAILED , HttpStatus.EXPECTATION_FAILED);
    }
	
}
