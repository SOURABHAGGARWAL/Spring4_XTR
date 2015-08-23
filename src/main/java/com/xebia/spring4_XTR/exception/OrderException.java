package com.xebia.spring4_XTR.exception;

public class OrderException extends Exception {

	private static final long serialVersionUID = 2837536608895057190L;

	public OrderException() {
		super();
	}

	public OrderException(String msg) {
		super(msg);
	}

	public OrderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OrderException(Throwable cause) {
		super(cause);
	}
}
