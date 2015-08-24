/**
 * 
 */
package com.xebia.spring4_XTR.exception.advice;

/**
 * @author user
 *
 */
public class ApiError {
	private String message;
	public ApiError(String message) {
		super();
		System.out.println("Exception 111:"+message);
		this.message = message;
	}

}
