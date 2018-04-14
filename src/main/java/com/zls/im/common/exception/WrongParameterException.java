package com.zls.im.common.exception;

/**
 * 参数错误异常
 * 
 * @author 卢丛越
 * @date 2016年1月11日
 */
public class WrongParameterException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6095503202088975818L;

	public WrongParameterException() {
		super("");
	}

	public WrongParameterException(String message) {
		super(message);
	}
}
