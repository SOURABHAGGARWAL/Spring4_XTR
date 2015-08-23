package com.xebia.spring4_XTR.exception;

public class CustomerException extends Exception {

	private static final long serialVersionUID = 3440506627961894681L;

	public CustomerException() {
		super();
	}

	public CustomerException(String msg) {
		super(msg);
	}

	public CustomerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}

}
