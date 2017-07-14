package com.nuc.zjy.frame;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ibm.icu.text.SimpleDateFormat;
import com.nu.zjy.entity.Customer;
import com.nu.zjy.entity.EntityContext;
import com.nu.zjy.entity.Model;
import com.nu.zjy.entity.Order;
import com.nu.zjy.entity.Ticket;
import com.nuc.zjy.service.impl.CustomerServiceimpl;
import com.nuc.zjy.service.impl.ManagerServiceimpl;
import com.nuc.zjy.service.impl.ModelServiceImpl;
import com.nuc.zjy.service.impl.OrderServiceimpl;
import com.nuc.zjy.service.impl.TicketServiceimpl;

/**
 * @项目名称：ticket
 * @类名称：ClientContext
 * @类描述：视图控制类
 * 
 * @author 赵建银
 * @date 2017-7-8
 * @time 上午10:36:15
 * @version 1.0
 */
public class ClientContext {
	private CustomerServiceimpl customerServiceimpl;
	private LoginFrame loginFrame;
	private RegisterFrame register;
	private TicketServiceimpl ticketServiceimpl;
	private ModelServiceImpl modelServiceImpl;
	private ManagerServiceimpl managerServiceimpl;
	private OrderServiceimpl orderServiceimpl;
	private MainFrame mainFrame;
	private Customer login_cuCustomer;
	private EntityContext context;
	private Manager_MainFrame manager_MainFrame;
	private WindowFrame windowFrame = new WindowFrame();

	/**
	 * 显示界面
	 */
	public void show() {
		windowFrame.setVisible(true);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				windowFrame.setVisible(false);
				loginFrame.setVisible(true);
				timer.cancel();
			}
		}, 2000);
	}

	/**
	 * 显示注册界面
	 */
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
				manager_MainFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(loginFrame, "请输入正确的用户名和密码");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(loginFrame, e.getMessage());
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
	 * 
	 * 更新航班信息
	 */
	public void update() {
		String startTime = manager_MainFrame.getupdateStartTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String now = simpleDateFormat.format(new Date());
		now = now.substring(0, 16);
		if (startTime.compareTo(now) > 0) {
			if (startTime.length() == 16 && startTime.indexOf("-") == 4
					&& startTime.lastIndexOf(":") == 13) {
				updateModel();
				updateTicket();
			} else {
				JOptionPane.showMessageDialog(manager_MainFrame,
						"请输入正确的日期格式例如2017-09-09 09:09");
			}
		} else {
			JOptionPane.showMessageDialog(manager_MainFrame, "请输入今天以后的日期");
		}
	}

	/**
	 * 管理员添加航班信息
	 */
	public void add() {
		String startTime = manager_MainFrame.getStartTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String now = simpleDateFormat.format(new Date());
		now = now.substring(0, 16);
		if (startTime.compareTo(now) > 0) {
			if (startTime.length() == 16 && startTime.indexOf("-") == 4
					&& startTime.lastIndexOf(":") == 13) {
				if (addModel()) {
					addTicket();
				}
			} else {
				JOptionPane.showMessageDialog(manager_MainFrame,
						"请输入正确的日期格式例如2017-09-09 09:09");
			}
		} else {
			JOptionPane.showMessageDialog(manager_MainFrame, "请输入今天以后的日期");
		}

	}

	/**
	 * 添加机票
	 */
	public void addTicket() {
		try {
			String jcid = manager_MainFrame.getJici();
			int number = Integer.parseInt(manager_MainFrame.getNumber());
			double price = Double.parseDouble(manager_MainFrame.getPrice());
			String type = manager_MainFrame.getJCType();
			for (int i = 0; i < number; i++) {
				Ticket ticket = new Ticket(jcid, jcid + "_" + (i + 1), i + 1
						+ "", price, type, false);
				ticketServiceimpl.save(ticket);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加航班
	 */
	public boolean addModel() {
		boolean flags = false;
		try {
			String start = manager_MainFrame.getStart();
			String end = manager_MainFrame.getEnd();
			String startTime = manager_MainFrame.getStartTime();
			String jcid = manager_MainFrame.getJici();
			int number = Integer.parseInt(manager_MainFrame.getNumber());
			double price = Double.parseDouble(manager_MainFrame.getPrice());
			String type = manager_MainFrame.getJCType();
			if (!start.equals(end)) {
				Model model = new Model(jcid, startTime, start, end, type,
						price, number);
				boolean flag = modelServiceImpl.save(model);
				if (flag) {
					JOptionPane.showMessageDialog(manager_MainFrame, "添加航班成功");
					flags = true;
				} else {
					JOptionPane
							.showMessageDialog(manager_MainFrame, "已经添加过此航班");
				}
			} else {
				JOptionPane.showMessageDialog(manager_MainFrame, "起点和终点不能相同");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(manager_MainFrame,
					"信息填写格式错误，请正确填写票价，票数量");
			e.printStackTrace();
		}
		return flags;
	}

	/**
	 * 用户注册
	 */
	public void register() {
		try {
			String passwd = register.getPassWord();
			String passwd_ok = register.getPasswordOK();
			String name = register.getCustomrtName();
			String carid = register.getCarId();
			String account = register.getAccount();
			int age = Integer.parseInt(carid.substring(6, 10));
			String dateString = new Date().toString();
			int date = Integer.parseInt(dateString.substring(dateString
					.length() - 4));
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
					boolean flag = customerServiceimpl.save(customer);
					if (flag) {
						context.loadCustomer();// 登陆后重新加载用户信息
						register.setVisible(false);
						loginFrame.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(register, "两次密码输入不同");
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(register, "身份证号码格式不正正确，请输入18位身份证");
		}
	}

	/**
	 * 查找航班信息
	 * 
	 * @param model
	 *            航班
	 * @return 所有航班信息
	 */
	public Vector<Model> findModel(Model model) {
		Vector<Model> list = null;
		String startTime = model.getStarttime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String now = simpleDateFormat.format(new Date());
		now = now.substring(0, 16);
		if (!startTime.equals("")) {
			if (startTime.compareTo(now) > 0) {
				if (startTime.length() == 10 && startTime.indexOf("-") == 4) {
					if (null != model.getEnd() && null != model.getStart()) {
						list = modelServiceImpl.find(model.getStart(),
								model.getEnd(), model.getStarttime());
					} else {
						JOptionPane.showMessageDialog(manager_MainFrame,
								"请输入正确的信息");
					}

				} else {
					JOptionPane.showMessageDialog(manager_MainFrame,
							"请输入正确的日期格式例如2017-09-09");
				}
			} else {
				JOptionPane.showMessageDialog(manager_MainFrame, "请输入今天以后的日期");
			}
		}
		return list;
	}

	/**
	 * 删除航班信息
	 */
	public void deleteModel() {
		String jici = manager_MainFrame.getDeleteJici().trim();
		if (!jici.equals("")) {
			boolean flag = modelServiceImpl.delete(jici);
			if (flag) {
				JOptionPane.showMessageDialog(manager_MainFrame, "删除成功");
			} else {
				JOptionPane.showMessageDialog(manager_MainFrame, "删除失败");
			}
		} else {
			JOptionPane.showMessageDialog(manager_MainFrame, "没有输入信息");
		}
	}

	/**
	 * 
	 * 更新航班信息
	 */
	public void updateModel() {
		try {
			Model model = new Model();
			String jici = manager_MainFrame.getupdateJici();
			String start = manager_MainFrame.getupdateStart();
			String end = manager_MainFrame.getupdateEnd();
			String starttime = manager_MainFrame.getupdateStartTime();
			int number = Integer.parseInt(manager_MainFrame.getupdateNumber());
			double price = Double.parseDouble(manager_MainFrame
					.getupdatePrice());
			String type = manager_MainFrame.getJCupdateType();
			if (!start.equals(end)) {
				model.setJici(jici);
				model.setStart(start);
				model.setStarttime(starttime);
				model.setEnd(end);
				model.setNumber(number);
				model.setType(type);
				model.setPrice(price);
				modelServiceImpl.update(model);
			} else {
				JOptionPane.showMessageDialog(manager_MainFrame, "起点和终点不能相同");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(manager_MainFrame, "请正确填写信息");
		}

	}

	/**
	 * 更新机票信息
	 */
	public void updateTicket() {
		String jici = manager_MainFrame.getupdateJici();
		int number = Integer.parseInt(manager_MainFrame.getupdateNumber());
		double price = Double.parseDouble(manager_MainFrame.getupdatePrice());
		String type = manager_MainFrame.getJCupdateType();
		Ticket ticket = new Ticket();
		ticket.setJici(jici);
		ticket.setPrice(price);
		ticket.setType(type);
		ticket.setUsed(false);
		boolean flag = ticketServiceimpl.update(ticket, number);
		if (flag) {
			JOptionPane.showMessageDialog(manager_MainFrame, "更新成功");
		} else {
			JOptionPane.showMessageDialog(manager_MainFrame,
					"更新失败,请确认是否存在该航班，以及航班类型");
		}
	}

	/**
	 * 添加订单
	 * 
	 * @param jici
	 *            航班
	 * @param type
	 *            类型
	 */
	public void addOrder(String jici, String type, String add) {
		try {
			Order order = new Order();
			order.setName(login_cuCustomer.getName());
			Ticket ticket = findTicket(jici, type);
			Model model = findModel(jici, type);
			order.setTicket(ticket);
			order.setModel(model);
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			order.setBuyTime(sim.format(new Date()));
			if (orderServiceimpl.save(order, add)) {
				JOptionPane.showMessageDialog(mainFrame, "添加成功");
			} else {
				JOptionPane.showMessageDialog(mainFrame, "您已购买本次航班");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(mainFrame,
					"订单添加失败,请确认是否存在该航班，以及航班类型,及其您是否购买本次航班");
		}
	}

	/**
	 * 退订单
	 * 
	 * @param jcstr
	 *            航班号
	 */
	public void returnorder(String jcstr) {
		if (!jcstr.equals("")) {
			boolean flag = orderServiceimpl.delete(login_cuCustomer.getName(),
					jcstr);
			if (flag) {
				JOptionPane.showMessageDialog(mainFrame, "退订成功");
			} else {
				JOptionPane.showMessageDialog(mainFrame,
						"您没有本次航班的机票,或航班已取消，请联系管理员");
			}

		} else {
			JOptionPane.showMessageDialog(mainFrame, "请输入要退订的航班");
		}

	}

	/**
	 * 获得订单金额
	 * 
	 * @return
	 */
	public double getMoney() {
		return orderServiceimpl.getMoney(login_cuCustomer.getName());
	}

	/**
	 * 查找航班
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            类型
	 * @return 航班
	 */
	private Model findModel(String jici, String type) {
		return modelServiceImpl.findByJiandtype(jici, type);

	}

	/**
	 * 查找所有订单
	 * 
	 * @param name
	 * @return 所有订单
	 */
	public Vector<Order> findOrder(String name) {
		return orderServiceimpl.findByName(name);

	}

	/**
	 * 查找机票
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            类型
	 * @return 机票
	 */
	private Ticket findTicket(String jici, String type) {
		return ticketServiceimpl.findByJiandtype(jici, type);

	}

	/**
	 * 当前登录用户
	 * 
	 * @return 当前登录用户
	 */
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

	public void setManager_MainFrame(Manager_MainFrame manager_MainFrame) {
		this.manager_MainFrame = manager_MainFrame;
	}

	public void setOrderServiceimpl(OrderServiceimpl orderServiceimpl) {
		this.orderServiceimpl = orderServiceimpl;
	}

}
