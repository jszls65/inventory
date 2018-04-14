package com.zls.im.common.exception;


public class NotFoundException extends BaseException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5213847321639454382L;

	public NotFoundException(String message) {
        super(message);
    }
	
	public NotFoundException() {
        super("");
    }

}
