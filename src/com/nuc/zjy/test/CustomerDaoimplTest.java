package com.nuc.zjy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nu.zjy.entity.EntityContext;
import com.nuc.zjy.service.impl.CustomerServiceimpl;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：CustomerDaoimplTest
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-8
 * @time 下午3:35:14
 * @version 1.0
 */
public class CustomerDaoimplTest {

	CustomerServiceimpl customerDaoimpl = null;

	@Before
	public void Beforetest() {
		customerDaoimpl = new CustomerServiceimpl();
		Config config = new Config("client.properties");
		EntityContext context = new EntityContext(config);
		customerDaoimpl.setContext(context);
	}

	@Test
	public void testlogin() {
		boolean flag = customerDaoimpl.login("1000", "1234");
		Assert.assertTrue(flag);
	}
}
