package com.zls.im.common.exception;

public class WrongPasswordException extends  BaseException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -422018960641184657L;

	public WrongPasswordException(String message) {
        super(message);
    }
}
