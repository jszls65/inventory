package com.zls.im.common.exception;

public class RecordExistException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6730981390858187713L;

	public RecordExistException() {
		super("");
	}

	public RecordExistException(String message) {
		super(message);
	}
}
