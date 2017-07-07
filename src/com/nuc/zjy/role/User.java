package com.nuc.zjy.role;

/**
 * @项目名称：ticket
 * @类名称：User
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午11:48:02
 * @version 1.0
 */
public class User {

	private String iD;
	private String name;
	private String passwd;
	private String cardId;

	public User() {
		super();
	}

	/**
	 * @param iD
	 *            用户id
	 * @param name
	 *            用户账号
	 * @param passwd
	 *            用户密码
	 */
	public User(String iD, String name, String passwd, String cardId) {
		super();
		this.iD = iD;
		this.name = name;
		this.passwd = passwd;
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
