package com.zls.im.common.exception;

/**
 * 计算库存异常
 * 
 * @Description
 * @author congyue.lu
 * @date 2016年4月15日 上午10:38:13
 * @version
 */
public class StoreException extends BaseException {

	/** @Fields serialVersionUID: */

	private static final long serialVersionUID = 255176267304738531L;

	public StoreException() {
		super("");
	}

	public StoreException(String message) {
		super(message);
	}
}
