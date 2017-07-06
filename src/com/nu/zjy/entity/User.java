package com.nu.zjy.entity;

/**
 * @项目名称：ticket
 * @类名称：User
 * @类描述： 用户的实体类
 * 
 * @author 赵建银-邮箱：384144795@qq.com
 * @date 创建时间：2017-7-6 上午11:43:03
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class User {
	private String name;

	private String passwd;

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

}
