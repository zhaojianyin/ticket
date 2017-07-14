package com.nuc.zjy.test;

import org.junit.Assert;
import org.junit.Test;

import com.nuc.zjy.service.impl.ManagerServiceimpl;

/**
 * @项目名称：ticket
 * @类名称：ManagerDaoimplTest
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 上午8:07:12
 * @version 1.0
 */
public class ManagerDaoimplTest {

	/**
	 * 管理员登录测试
	 */
	@Test
	public void testLogin() {
		ManagerServiceimpl managerDaoimpl = new ManagerServiceimpl();
		Assert.assertTrue(managerDaoimpl.login("admin", "123456"));

	}
}
