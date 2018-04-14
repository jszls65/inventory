package com.zls.im.common.exception;

public class SessionTimeoutException extends  BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -722027582215435933L;

	public SessionTimeoutException(){
		super("");
	}
	
	public SessionTimeoutException(String message) {
		super(message);
	}

}
