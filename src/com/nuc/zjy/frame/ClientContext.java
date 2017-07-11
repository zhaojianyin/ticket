package com.nuc.zjy.frame;

import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.nu.zjy.entity.Customer;
import com.nu.zjy.entity.EntityContext;
import com.nu.zjy.entity.Model;
import com.nu.zjy.entity.Ticket;
import com.nuc.zjy.service.impl.CustomerServiceimpl;
import com.nuc.zjy.service.impl.ManagerServiceimpl;
import com.nuc.zjy.service.impl.ModelServiceImpl;
import com.nuc.zjy.service.impl.TicketServiceimpl;

/**
 * @项目名称：ticket
 * @类名称：ClientContext
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-8
 * @time 上午10:36:15
 * @version 1.0
 */
public class ClientContext {
	private CustomerServiceimpl customerServiceimpl;
	private LoginFrame loginFrame;
	private RegisterFrame register;
	private AddTicketFrame addTicketFrame;
	private TicketServiceimpl ticketServiceimpl;
	private ModelServiceImpl modelServiceImpl;
	private ManagerServiceimpl managerServiceimpl;
	private MainFrame mainFrame;
	private Customer login_cuCustomer;
	private EntityContext context;

	public void show() {
		// final Timer timer = new Timer();
		// timer.schedule(new TimerTask() {
		// public void run() {
		// loginFrame.setVisible(true);
		// timer.cancel();
		// }
		// }, 1000);
		loginFrame.setVisible(true);
		login();
	}

	public void testadd() throws Exception {
		addTicketFrame.setVisible(true);
	}

	public void show_register() {
		loginFrame.setVisible(false);
		register.setVisible(true);
	}

	/**
	 * 用户登录
	 */
	public void login() {
		context.loadCustomer();// 加载用户信息
		try {
			boolean flag_customer = false;
			boolean flag_manager = false;
			String type = loginFrame.getCmtype();
			String id = loginFrame.getuerid();
			String pwd = loginFrame.getPassword();
			if (type.equals("管理员")) {
				flag_manager = managerServiceimpl.login(id, pwd);
			} else {
				flag_customer = customerServiceimpl.login(id, pwd);
				login_cuCustomer = customerServiceimpl.findById(id);
			}
			if (flag_customer) {
				loginFrame.setVisible(false);
				mainFrame.setVisible(true);
			} else if (flag_manager) {
				loginFrame.setVisible(false);
				// TODO 管理员界面
			} else {
				JOptionPane.showMessageDialog(loginFrame, "登录失败");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(loginFrame, "产生错误");
			e.printStackTrace();
		}
	}

	/**
	 * 退出程序
	 * 
	 * @param from
	 *            当前窗体
	 */
	public void exit(JFrame from) {
		int val = JOptionPane.showConfirmDialog(from, "退出吗？");
		if (val == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * 添加机票
	 */
	public void addTicket() {
		boolean flag = false;
		try {
			String jcid = addTicketFrame.getJici();
			int number = addTicketFrame.getNumber();
			double price = addTicketFrame.getPrice();
			String type = addTicketFrame.getJCType();
			for (int i = 0; i < number; i++) {
				Ticket ticket = new Ticket(jcid, jcid + i, i + "", price, type,
						false);
				flag = ticketServiceimpl.save(ticket);
				if (flag) {
					addTicketFrame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(loginFrame, "添加机票失败");
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(loginFrame, "产生错误");
			e.printStackTrace();
		}
	}

	/**
	 * 添加航班
	 */
	public void addModel() {
		try {
			String start = addTicketFrame.getStart();
			String end = addTicketFrame.getEnd();
			String startTime = addTicketFrame.getStartTime();
			String jcid = addTicketFrame.getJici();
			int number = addTicketFrame.getNumber();
			double price = addTicketFrame.getPrice();
			String type = addTicketFrame.getJCType();
			Model model = new Model(jcid, startTime, start, end, type, price,
					number);
			boolean flag = modelServiceImpl.save(model);
			if (flag) {
				addTicketFrame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(loginFrame, "添加航班失败");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(loginFrame, "产生错误");
			e.printStackTrace();
		}
	}

	/**
	 * 用户注册
	 */
	public void register() {
		String passwd = register.getPassWord();
		String passwd_ok = register.getPasswordOK();
		String name = register.getCustomrtName();
		String carid = register.getCarId();
		String account = register.getAccount();
		int age = Integer.parseInt(carid.substring(6, 10));
		String dateString = new Date().toString();
		int date = Integer
				.parseInt(dateString.substring(dateString.length() - 4));
		Customer customer = new Customer();
		if (carid.length() != 18) {
			JOptionPane.showMessageDialog(register, "身份证号码长度不对");
		} else {
			if (passwd.equals(passwd_ok)) {
				customer.setiD(account);
				customer.setName(name);
				customer.setPasswd(passwd);
				customer.setCardId(carid);
				if (date - age >= 18) {
					customer.setType("成年");
				} else {
					customer.setType("未成年");
				}
				customerServiceimpl.save(customer);
				context.loadCustomer();// 登陆后重新加载用户信息
				register.setVisible(false);
				loginFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(register, "两次密码输入不同");
			}
		}
	}

	public Vector<Model> findTicket(Model model) {
		Vector<Model> list = null;
		if (null != model.getStart() && null != model.getEnd()
				&& null != model.getStarttime()) {
			list = modelServiceImpl.find(model.getStart(), model.getEnd(),
					model.getStarttime());
		} else {
			JOptionPane.showMessageDialog(mainFrame, "信息输入不正确");
		}
		return list;
	}

	public Customer getLogin_cuCustomer() {
		return login_cuCustomer;
	}

	public void setRegister(RegisterFrame register) {
		this.register = register;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public void setCustomerServiceimpl(CustomerServiceimpl customerServiceimpl) {
		this.customerServiceimpl = customerServiceimpl;
	}

	public void setAddTicket(AddTicketFrame addTicketFrame) {
		this.addTicketFrame = addTicketFrame;
	}

	public void setTicketServiceimpl(TicketServiceimpl ticketServiceimpl) {
		this.ticketServiceimpl = ticketServiceimpl;
	}

	public void setModelServiceImpl(ModelServiceImpl modelServiceImpl) {
		this.modelServiceImpl = modelServiceImpl;
	}

	public void setManagerServiceimpl(ManagerServiceimpl managerServiceimpl) {
		this.managerServiceimpl = managerServiceimpl;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setContext(EntityContext context) {
		this.context = context;
	}

}
