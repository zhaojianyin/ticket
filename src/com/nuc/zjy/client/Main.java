package com.nuc.zjy.client;

import com.nu.zjy.entity.EntityContext;
import com.nuc.zjy.frame.AddTicketFrame;
import com.nuc.zjy.frame.ClientContext;
import com.nuc.zjy.frame.LoginFrame;
import com.nuc.zjy.frame.MainFrame;
import com.nuc.zjy.frame.Manager_MainFrame;
import com.nuc.zjy.frame.RegisterFrame;
import com.nuc.zjy.service.impl.CustomerServiceimpl;
import com.nuc.zjy.service.impl.ManagerServiceimpl;
import com.nuc.zjy.service.impl.ModelServiceImpl;
import com.nuc.zjy.service.impl.TicketServiceimpl;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：Main
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午7:19:49
 * @version 1.0
 */
public class Main {
	// 初始化组件

	public static void main(String[] args) throws Exception {
		// 初始化组件
		LoginFrame loginFrame = new LoginFrame();
		RegisterFrame registerFrame = new RegisterFrame();
		AddTicketFrame addTicketFrame = new AddTicketFrame();
		MainFrame mainFrame = new MainFrame();
		Manager_MainFrame manager_main = new Manager_MainFrame();
		// 加载文件
		Config config = new Config("client.properties");
		// 配置文件
		EntityContext entityContext = new EntityContext(config);

		// 初始化实现
		CustomerServiceimpl customerServiceimpl = new CustomerServiceimpl();
		ManagerServiceimpl managerServiceimpl = new ManagerServiceimpl();
		ModelServiceImpl modelServiceImpl = new ModelServiceImpl();
		TicketServiceimpl ticketServiceimpl = new TicketServiceimpl();

		// 初始化界面管理
		ClientContext clientContext = new ClientContext();

		// 界面注册管理
		registerFrame.setClientContext(clientContext);
		addTicketFrame.setClientContext(clientContext);
		loginFrame.setClientContext(clientContext);
		mainFrame.setClientContext(clientContext);
		// 注册实现
		clientContext.setManagerServiceimpl(managerServiceimpl);
		clientContext.setModelServiceImpl(modelServiceImpl);
		clientContext.setTicketServiceimpl(ticketServiceimpl);
		clientContext.setAddTicket(addTicketFrame);
		clientContext.setCustomerServiceimpl(customerServiceimpl);
		clientContext.setRegister(registerFrame);
		clientContext.setMainFrame(mainFrame);

		// 接口注册管理
		customerServiceimpl.setContext(entityContext);
		modelServiceImpl.setContext(entityContext);
		ticketServiceimpl.setContext(entityContext);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setContext(entityContext);
		// 显示
		clientContext.show();
	}
}
