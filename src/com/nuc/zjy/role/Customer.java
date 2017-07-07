package com.nuc.zjy.role;

import java.io.Serializable;

/**
 * @项目名称：ticket
 * @类名称：Customer
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:48:57
 * @version 1.0
 */
public class Customer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3132854911786188494L;
	private String type;// 顾客类型

	public Customer() {
	}

	/**
	 * @param iD
	 *            顾客id
	 * @param name
	 *            顾客姓名
	 * @param passwd
	 *            顾客密码
	 * @param cardId
	 *            顾客身份证号
	 * @param type
	 *            顾客类型
	 */
	public Customer(String iD, String name, String passwd, String cardId,
			String type) {
		super(iD, name, passwd, cardId);
		this.type = type;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
