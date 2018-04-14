package com.zls.im.common.exception;

public class BaseException extends Exception{
    

	/**
	 * 
	 */
	private static final long serialVersionUID = -9216429824058594999L;

	public BaseException(){
		super("");
	}
	
	public BaseException(String message) {
        super(message);
    }
}
