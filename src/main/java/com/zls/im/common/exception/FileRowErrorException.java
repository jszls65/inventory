package com.zls.im.common.exception;

/**
 * 文件解析时，第n行的数据解析出错
 * @author zhang
 *
 */
public class FileRowErrorException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5110008971934967824L;

	public FileRowErrorException() {
		super("");
	}

	public FileRowErrorException(String message) {
		super(message);
	}
}
