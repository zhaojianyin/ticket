package com.nu.zjy.entity;

import java.io.Serializable;

/**
 * @项目名称：ticket
 * @类名称：Customer
 * @类描述：顾客实体类,包括用户账号，用户姓名，用户密码，用户身份证号，以及用户类型(成年|未成年)
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 上午10:48:57
 * @version 1.0
 */
public class Customer implements Serializable {

	private String iD;
	private String name;
	private String passwd;
	private String cardId;
	private String type;// 顾客类型(成年|未成年)

	/**
	 * 
	 */
	private static final long serialVersionUID = 3132854911786188494L;

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
		super();
		this.iD = iD;
		this.name = name;
		this.passwd = passwd;
		this.cardId = cardId;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
