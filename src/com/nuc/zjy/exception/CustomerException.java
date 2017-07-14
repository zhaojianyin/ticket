package com.nuc.zjy.exception;

/**
 * @项目名称：ticket
 * @类名称：CustomerException
 * @类描述：用户异常类
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午2:53:52
 * @version 1.0
 */
public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5076863033569270196L;

	public CustomerException() {
		super();

	}

	public CustomerException(String message) {
		super(message);

	}

}
