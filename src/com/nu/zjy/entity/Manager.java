package com.nu.zjy.entity;

import java.io.Serializable;

/**
 * @项目名称：ticket
 * @类名称：Manager
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:48:19
 * @version 1.0
 */
public class Manager implements Serializable {

	private String name;
	private String passwd;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3852805701742829798L;

	public Manager() {
		super();
	}

	/**
	 * @param name
	 *            管理员账号
	 * @param passwd
	 *            管理员密码
	 */
	public Manager(String name, String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
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

}
