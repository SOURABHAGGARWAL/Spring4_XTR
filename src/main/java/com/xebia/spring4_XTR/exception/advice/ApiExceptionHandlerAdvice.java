package com.xebia.spring4_XTR.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.google.common.base.Throwables;

@ControllerAdvice(annotations = RestController.class)
class ApiExceptionHandlerAdvice{
 
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> exception(Exception exception, WebRequest request) {
    	System.out.println("Exception :"+exception.getMessage());
    	return new ResponseEntity<String>("Wrong error: ", HttpStatus.EXPECTATION_FAILED);
    }
	
}
