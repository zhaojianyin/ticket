package com.nuc.zjy.test;

import org.junit.Before;
import org.junit.Test;

import com.nu.zjy.entity.Customer;
import com.nu.zjy.entity.EntityContext;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：EntityContextTest
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-10
 * @time 上午8:28:03
 * @version 1.0
 */
public class EntityContextTest {

	EntityContext entityContext = null;

	@Before
	public void testbefore() {
		String file = "client.properties";
		Config config = new Config(file);
		entityContext = new EntityContext(config);
	}

	@Test
	public void testGetCustomer() {
		System.out.println(entityContext.getCustomer("1000"));
	}

	@Test
	public void testEntryCustomer() {
		entityContext.setCustomer(new Customer("1009", "李志选", "1234",
				"32132132121", "未成年"));
		entityContext.setCustomer(new Customer("1003", "赵建银", "1234",
				"123132131221", "成年"));
	}
}
