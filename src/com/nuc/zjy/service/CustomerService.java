package com.nuc.zjy.service;

import com.nu.zjy.entity.Customer;

/**
 * @项目名称：ticket
 * @类名称：CustomerDao
 * @类描述：顾客的接口
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 上午10:47:13
 * @version 1.0
 */
public interface CustomerService extends BaseDao<Customer> {
	/**
	 * 顾客登录,包含用户名，密码
	 * 
	 * @param id
	 *            用户名
	 * @param password
	 *            密码
	 * @return 是否登录成功
	 */
	boolean login(String id, String password);


}
