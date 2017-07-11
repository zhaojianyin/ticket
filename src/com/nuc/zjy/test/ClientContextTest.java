package com.nuc.zjy.test;

import org.junit.Before;
import org.junit.Test;

import com.nu.zjy.entity.EntityContext;
import com.nuc.zjy.frame.ClientContext;
import com.nuc.zjy.frame.LoginFrame;
import com.nuc.zjy.service.impl.CustomerServiceimpl;
import com.nuc.zjy.service.impl.ModelServiceImpl;
import com.nuc.zjy.service.impl.TicketServiceimpl;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：ClientContextTest
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-8
 * @time 下午3:12:35
 * @version 1.0
 */
public class ClientContextTest {

	CustomerServiceimpl customerDaoimpl;
	ClientContext client;
	LoginFrame loginFrame;
	Config config;
	EntityContext entityContext;
	TicketServiceimpl ticketServiceimpl;
	ModelServiceImpl modelServiceImpl;

	@Before
	public void testbefore() {
		customerDaoimpl = new CustomerServiceimpl();
		client = new ClientContext();
		loginFrame = new LoginFrame();
		config = new Config("client.properties");
		entityContext = new EntityContext(config);
	}

	@Test
	public void testlogin() {
		customerDaoimpl.setContext(entityContext);
		loginFrame.setClientContext(client);
		client.setCustomerServiceimpl(customerDaoimpl);
		client.setLoginFrame(loginFrame);
		loginFrame.setVisible(true);
	}

	@Test
	public void testaddMedelandtestTicket() {
		ticketServiceimpl.setContext(entityContext);
	}

}
