package com.zls.im.common.exception;

/**
 * 编码长度超过最大限制
 * 
 * @Description
 * @author huaming.yu
 * @date 2016年4月29日 上午10:38:13
 * @version
 */
public class CodeOutOfRangeException extends BaseException {

	/** @Fields serialVersionUID: */
	
	private static final long serialVersionUID = -2706307527045678892L;

	public CodeOutOfRangeException() {
		super("");
	}

	public CodeOutOfRangeException(String message) {
		super(message);
	}
}
