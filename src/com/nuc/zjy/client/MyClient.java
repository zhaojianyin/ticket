package com.nuc.zjy.client;

import com.nu.zjy.entity.EntityContext;
import com.nuc.zjy.frame.ClientContext;
import com.nuc.zjy.frame.LoginFrame;
import com.nuc.zjy.frame.MainFrame;
import com.nuc.zjy.frame.Manager_MainFrame;
import com.nuc.zjy.frame.RegisterFrame;
import com.nuc.zjy.service.impl.CustomerServiceimpl;
import com.nuc.zjy.service.impl.ManagerServiceimpl;
import com.nuc.zjy.service.impl.ModelServiceImpl;
import com.nuc.zjy.service.impl.OrderServiceimpl;
import com.nuc.zjy.service.impl.TicketServiceimpl;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：MyClient
 * @类描述：初始化组件
 * 
 * @author 赵建银
 * @date 2017-7-8
 * @time 上午8:07:25
 * @version 1.0
 */
public class MyClient {

	public static void start() {
		// 初始化组件
		LoginFrame loginFrame = new LoginFrame();
		RegisterFrame registerFrame = new RegisterFrame();
		MainFrame mainFrame = new MainFrame();
		Manager_MainFrame manager_main = new Manager_MainFrame();
		// 加载文件
		Config config = new Config("client.properties");
		// 配置文件
		EntityContext entityContext = new EntityContext(config);
		entityContext.setRegister(registerFrame);

		// 初始化实现
		CustomerServiceimpl customerServiceimpl = new CustomerServiceimpl();
		ManagerServiceimpl managerServiceimpl = new ManagerServiceimpl();
		ModelServiceImpl modelServiceImpl = new ModelServiceImpl();
		TicketServiceimpl ticketServiceimpl = new TicketServiceimpl();
		OrderServiceimpl orderServiceimpl = new OrderServiceimpl();

		// 初始化界面管理
		ClientContext clientContext = new ClientContext();

		// 界面注册管理
		registerFrame.setClientContext(clientContext);
		loginFrame.setClientContext(clientContext);
		mainFrame.setClientContext(clientContext);
		manager_main.setClientContext(clientContext);
		// 注册实现
		clientContext.setManagerServiceimpl(managerServiceimpl);
		clientContext.setModelServiceImpl(modelServiceImpl);
		clientContext.setTicketServiceimpl(ticketServiceimpl);
		clientContext.setOrderServiceimpl(orderServiceimpl);
		clientContext.setCustomerServiceimpl(customerServiceimpl);
		clientContext.setRegister(registerFrame);
		clientContext.setMainFrame(mainFrame);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setManager_MainFrame(manager_main);
		clientContext.setContext(entityContext);
		// 接口注册管理
		customerServiceimpl.setContext(entityContext);
		modelServiceImpl.setContext(entityContext);
		ticketServiceimpl.setContext(entityContext);
		orderServiceimpl.setContext(entityContext);
		// 显示
		clientContext.show();
	}
}
