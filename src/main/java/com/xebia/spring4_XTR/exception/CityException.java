package com.xebia.spring4_XTR.exception;

public class CityException extends Exception {

	private static final long serialVersionUID = 6175021560585444761L;

	public CityException() {
		super();
	}

	public CityException(String msg) {
		super(msg);
	}

	public CityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CityException(Throwable cause) {
		super(cause);
	}
}
