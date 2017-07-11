package com.nuc.zjy.service;

/**
 * @项目名称：ticket
 * @类名称：ManagerDao
 * @类描述：管理员接口
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:47:03
 * @version 1.0
 */
public interface ManagerService {

	/**
	 * 管理员登录,包含管理员id，密码
	 * 
	 * @param id
	 *            管理员id
	 * @param password
	 *            密码
	 * @return 是否登录成功
	 */
	boolean login(String id, String password);

}
