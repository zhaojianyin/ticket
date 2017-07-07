package com.nuc.zjy.role;

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
public class Manager extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3852805701742829798L;

	public Manager() {
	}

	/**
	 * @param iD
	 *            管理员ID
	 * @param name
	 *            管理员账号
	 * @param passwd
	 *            管理员密码
	 * @param cardId
	 *            身份证号
	 */
	public Manager(String iD, String name, String passwd, String cardId) {
		super(iD, name, passwd, cardId);
	}

}
