package com.nu.zjy.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.nuc.zjy.exception.CustomerException;
import com.nuc.zjy.frame.RegisterFrame;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：EntityContext
 * @类描述：实体控制类，读取文件数据，修改和删除文件数据
 * 
 * @author 赵建银
 * @date 2017-7-8
 * @time 上午10:56:22
 * @version 1.0
 */
public class EntityContext {
	private HashMap<String, Customer> customers = new HashMap<String, Customer>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	private List<Model> models = new ArrayList<Model>();
	private List<Order> orders = new ArrayList<Order>();
	private String filename_user;
	private String filename_ticket;
	private String filename_model;
	private String filename_order;
	private RegisterFrame register;

	/**
	 * 初始化文件中的信息，加载配置文件的xin'xi
	 * 
	 * @param config
	 *            配置工具类
	 */
	public EntityContext(Config config) {
		filename_user = config.getString("UserFile");
		filename_ticket = config.getString("TicketFile");
		filename_model = config.getString("ModelFile");
		filename_order = config.getString("OrderFile");
	}

	/**
	 * 加载用户信息
	 */
	public void loadCustomer() {
		loadCustomer(filename_user);
	}

	/**
	 * 加载机票信息
	 */
	public void LoadTicket() {
		LoadTicket(filename_ticket);
	}

	/**
	 * 加载航班信息
	 */
	public void LoadModel() {
		LoadModel(filename_model);
	}

	/**
	 * 加载订单信息
	 */
	public void loadOrder() {
		loadOrder(filename_order);
	}

	/**
	 * 加载订单文件信息
	 * 
	 * @param filename
	 *            订单文件名
	 */
	private void loadOrder(String filename) {
		orders.clear();
		// 将原来的数据清空
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.trim().equals("")) {
					continue;
				}
				Order order = parseOrder(str);
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 转换订单信息
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	private Order parseOrder(String str) throws ParseException {
		String[] data = str.split("/");
		Order order = new Order();
		Ticket ticket = new Ticket();
		Model model = new Model();
		order.setName(data[0]);
		ticket.setIdString(data[1]);
		ticket.setJici(data[2]);
		ticket.setPrice(Double.parseDouble((data[3])));
		ticket.setType(data[4]);
		ticket.setZuowei(data[5]);
		model.setStart(data[6]);
		model.setEnd(data[7]);
		model.setStarttime(data[8]);
		order.setTicket(ticket);
		order.setModel(model);
		order.setBuyTime(data[9]);
		return order;
	}

	/**
	 * 存储订单信息
	 * 
	 * @param filename
	 *            订单信息文件名
	 * @param order
	 *            存储的订单
	 * @param f
	 *            是否追加到原来的文件
	 * @param add
	 *            判断是否为添加订单
	 * @return 是否写入成功
	 */
	public boolean EntryOrder(String filename, Order order, boolean f,
			String add) {
		boolean flag = false;
		BufferedWriter out = null;
		loadOrder(filename_order);// 重新加载文件
		if (ishaveorder(order)) {// 判断是否含有次订单
			return flag;
		}
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename, f), "UTF-8"));
			String modelString = inOrder(order);
			out.write(modelString);
			out.write("\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 添加订单
		if (add.equals("add")) {
			addorder_update(order.getTicket().getJici(), order.getTicket()
					.getType());
		}
		return flag;
	}

	/**
	 * 判断是否含有本订单
	 * 
	 * @param order
	 *            订单
	 * @return 是否含有本订单，根据用户姓名和航班号判断
	 */
	private boolean ishaveorder(Order order) {
		List<Order> list = findOrder();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(order.getName())
					&& list.get(i).getModel().getJici()
							.equals(order.getModel().getJici())) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 将订单信息转换为字符串
	 * 
	 * @param order
	 *            要转换的订单
	 * @return 转换后的订单
	 */
	private String inOrder(Order order) {
		String string = "";
		if (order != null && !order.getTicket().getJici().equals("")) {
			Ticket ticket = order.getTicket();
			Model model = order.getModel();
			string = order.getName() + "/" + ticket.getIdString() + "/"
					+ ticket.getJici() + "/" + ticket.getPrice() + "/"
					+ ticket.getType() + "/" + ticket.getZuowei() + "/"
					+ model.getStart() + "/" + model.getEnd() + "/"
					+ model.getStarttime() + "/" + order.getBuyTime();
		}
		return string;
	}

	/**
	 * 加载用户信息，存入map中
	 * 
	 * @param filename
	 *            用户信息的文件名
	 */
	private void loadCustomer(String filename) {
		customers.clear();// 清空原来的数据
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.trim().equals("")) {
					continue;
				}
				Customer customer = parseCustomer(str);// 将用户解析
				customers.put(customer.getiD(), customer);// 将用户存储到map集合中
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 解析顾客信息-1000:赵建银:1234:1422011999999999:成年
	 * 
	 * @param str
	 *            传入顾客信息字符串
	 * @return 解析到的顾客
	 */
	private Customer parseCustomer(String str) {
		String[] data = str.split(":");
		Customer customer = new Customer();
		customer.setiD(data[0]);
		customer.setName(data[1]);
		customer.setPasswd(data[2]);
		customer.setCardId(data[3]);
		customer.setType(data[4]);
		return customer;
	}

	/**
	 * 存储用户信息
	 * 
	 * @param filename
	 *            用户信息文件名
	 * @param customer
	 *            存储的用户
	 */
	public boolean EntryCustomer(String filename, Customer customer) {
		boolean flag = false;
		BufferedWriter out = null;
		loadCustomer(filename_user);// 加载用户信息
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename, true), "UTF-8"));
			if (customers.get(customer.getiD()) == null) {// 判断用户是否存在
				String str = inUser(customer);
				out.write(str);
				out.write("\n");
				flag = true;
			} else {
				flag = false;
				throw new CustomerException("用户已经存在");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(register, e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * 将顾客信息转换为字符串
	 * 
	 * @param customer
	 *            传入顾客
	 * @return 返回转化的字符串
	 * @throws CustomerException
	 *             用户信息错误
	 */
	private String inUser(Customer customer) throws CustomerException {
		String str = null;
		if (customer != null) {
			str = customer.getiD() + ":" + customer.getName() + ":"
					+ customer.getPasswd() + ":" + customer.getCardId() + ":"
					+ customer.getType();
		} else {
			throw new CustomerException("用户信息错误");
		}
		return str;
	}

	/**
	 * 解析机票信息-CT090:CT09:0:头等舱:980.0:false
	 * 
	 * @param str
	 *            传入机票信息字符串
	 * @return 解析到的机票信息
	 */
	private Ticket parseTicket(String str) {
		String[] data = str.split(":");
		Ticket ticket = new Ticket();
		ticket.setIdString(data[0]);
		ticket.setJici(data[1]);
		ticket.setZuowei(data[2]);
		ticket.setType(data[3]);
		ticket.setPrice(Double.parseDouble(data[4]));
		ticket.setUsed(Boolean.parseBoolean(data[5]));
		return ticket;
	}

	/**
	 * 解析航班信息-CT09/太原/长沙/2017-09-09 09:09/100
	 * 
	 * @param str
	 *            传入航班信息字符串
	 * @return 解析到的航班
	 */
	private Model parseModel(String str) {
		String[] data = str.split("/");
		Model model = new Model();
		model.setJici(data[0]);
		model.setStart(data[1]);
		model.setEnd(data[2]);
		model.setStarttime(data[3]);
		model.setType(data[4]);
		model.setPrice(Double.parseDouble(data[5]));
		model.setNumber(Integer.parseInt(data[6]));
		return model;
	}

	/**
	 * 加载存放机票的文件信息
	 * 
	 * @param filename
	 *            存放机票的文件名
	 */
	private void LoadTicket(String filename) {
		tickets.clear();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.trim().equals("")) {
					continue;
				}
				Ticket ticket = parseTicket(str);// 将机票解析
				tickets.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 加载存放航班的文件信息
	 * 
	 * @param filename
	 *            存放航班信息的文件名
	 */
	private void LoadModel(String filename) {
		models.clear();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.trim().equals("")) {
					continue;
				}
				Model model = parseModel(str);
				models.add(model);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param modelname
	 *            航班文件名
	 * @param model
	 *            航班
	 * @param flag
	 *            是否追加
	 * @return 是否写入成功
	 */
	public boolean EntryModel(String modelname, Model model, boolean flag) {
		BufferedWriter out = null;
		boolean is = isfindByJiandTypeModel(model.getJici(), model.getType());
		if (is) {
			return false;
		}
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(modelname, flag), "UTF-8"));
			String modelString = inModel(model);
			out.write(modelString);
			out.write("\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param ticketname
	 *            票的文件名称
	 * @param ticket
	 *            票
	 * @param flag
	 *            是否追加
	 */
	public void EntryTicket(String ticketname, Ticket ticket, boolean flag) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(ticketname, flag), "UTF-8"));
			String str = inTicket(ticket);
			out.write(str);
			out.write("\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将票的信息转换为字符串
	 * 
	 * @param ticket
	 * @return 转换的字符串
	 */
	private String inTicket(Ticket ticket) {
		String str = "";
		if (ticket != null && !ticket.getJici().equals("")) {
			str = ticket.getIdString() + ":" + ticket.getJici() + ":"
					+ ticket.getZuowei() + ":" + ticket.getType() + ":"
					+ ticket.getPrice() + ":" + ticket.isUsed();
		}
		return str;
	}

	/**
	 * 将飞机的航班信息转换为字符串
	 * 
	 * @param model
	 *            航班
	 * 
	 * @return 转换后的字符串
	 */
	private String inModel(Model model) {
		String str = "";
		if (model != null && !model.getJici().equals("")) {
			str = model.getJici() + "/" + model.getStart() + "/"
					+ model.getEnd() + "/" + model.getStarttime() + "/"
					+ model.getType() + "/" + model.getPrice() + "/"
					+ model.getNumber();

		}
		return str;
	}

	/**
	 * 查找符合要求的航班信息
	 * 
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 * @param starttime
	 *            出发时间
	 * @return 符合条件的航班信息
	 */
	public Vector<Model> findModel(String start, String end, String starttime) {
		Vector<Model> list1 = new Vector<Model>();
		LoadModel();
		for (int i = 0; i < models.size(); i++) {
			Model model = models.get(i);
			if (model.getStart().equals(start) && model.getEnd().equals(end)
					&& model.getStarttime().compareTo(starttime) >= 0) {
				list1.add(model);
			}
		}
		return list1;
	}

	/**
	 * 查找所有的航班信息
	 * 
	 * @return 所有的航班信息
	 */
	public List<Model> findModel() {
		List<Model> list = new ArrayList<Model>();
		LoadModel();
		for (int i = 0; i < models.size(); i++) {
			Model model = models.get(i);
			list.add(model);
		}
		return list;
	}

	/**
	 * 
	 * 查找所有的机票信息
	 * 
	 * @return 所有机票信息
	 */
	public List<Ticket> findTicket() {
		List<Ticket> list = new ArrayList<Ticket>();
		LoadTicket();
		for (int i = 0; i < tickets.size(); i++) {
			Ticket ticket = tickets.get(i);
			list.add(ticket);
		}
		return list;
	}

	/**
	 * 删除航班信息
	 * 
	 * @param jici
	 *            航班号
	 * @return 返回是否删除
	 */
	public boolean deleteModel(String jici) {
		try {
			List<Model> list = findModel();
			if (isfindModelByid(jici)) {
				clearTxt(new Model());
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getJici().equals(jici)) {
						list.remove(i);
						i--;
					}
				}
				for (int i = 0; i < list.size(); i++) {
					EntryModelup(filename_model, list.get(i), true);
				}
				deleteTicket(jici);
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	/**
	 * 根据航班号查找航班
	 * 
	 * @param jici
	 *            查看是否含有航班
	 * @return 是否有本航班
	 */
	private boolean isfindModelByid(String jici) {
		List<Model> list = findModel();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJici().equals(jici)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 删除机票信息
	 * 
	 * @param jici
	 *            航班号
	 */
	public void deleteTicket(String jici) {
		List<Ticket> list = findTicket();
		clearTxt(new Ticket());
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJici().equals(jici)) {
				list.remove(i);
				i--;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			EntryTicket(filename_ticket, list.get(i), true);
		}
		LoadTicket();
	}

	/**
	 * 
	 * 更新航班信息
	 * 
	 * @param model
	 * @return 是否更新成功
	 */
	public boolean updateModel(Model model) {

		if (!isfindModelByid(model.getJici())) {
			return false;
		}
		try {
			List<Model> list = findModel();

			// 清空文件
			clearTxt(new Model());
			// 将本航班信息删除
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getJici().equals(model.getJici())
						&& list.get(i).getType().equals(model.getType())) {
					list.remove(i);
					i--;
				}
			}
			// 将其他航班信息存储
			for (int i = 0; i < list.size(); i++) {
				EntryModelup(filename_model, list.get(i), true);
			}
			// 存储本航班信息
			EntryModelup(filename_model, model, true);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean EntryModelup(String modelname, Model model, boolean flag) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(modelname, flag), "UTF-8"));
			String modelString = inModel(model);
			out.write(modelString);
			out.write("\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新机票信息
	 * 
	 * @param ticket
	 *            机票信息
	 * @param number
	 *            机票数量
	 * @return 是否成功更新
	 */
	public boolean updateTicket(Ticket ticket, int number) {
		if (!isfindModelByid(ticket.getJici())) {
			return false;
		}
		try {
			List<Ticket> list = findTicket();
			// 清空文件
			clearTxt(new Ticket());
			// 将本航班信息删除
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getJici().equals(ticket.getJici())
						&& list.get(i).getType().equals(ticket.getType())) {
					list.remove(i);
					i--;
				}
			}
			// 将其他航班信息存储
			for (int i = 0; i < list.size(); i++) {
				EntryTicket(filename_ticket, list.get(i), true);
			}
			for (int i = 0; i < number; i++) {
				ticket.setIdString(ticket.getJici() + "_" + (i + 1));
				ticket.setZuowei(i + 1 + "");
				EntryTicket(filename_ticket, ticket, true);
			}
			// 存储本航班信息

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 是否含有本航班
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            航班类型
	 * @return 是否含有本航班
	 */
	private boolean isfindByJiandTypeModel(String jici, String type) {
		List<Model> list = findModel();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJici().equals(jici)
					&& list.get(i).getType().equals(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找是否有机票
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            类型
	 * @return 是否含有
	 */
	private boolean isfindByJiandType(String jici, String type) {
		List<Ticket> list = findTicket();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJici().equals(jici)
					&& list.get(i).getType().equals(type)
					&& list.get(i).isUsed() == false) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找机票信息
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            机票类型
	 * @return 机票
	 */
	public Ticket findTicketByjiciandtype(String jici, String type) {
		if (!isfindByJiandType(jici, type)) {
			return null;
		}
		List<Ticket> list = findTicket();
		Ticket ticket = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJici().equals(jici)
					&& list.get(i).getType().equals(type)
					&& list.get(i).isUsed() == false) {
				ticket = list.get(i);
			}
		}
		return ticket;
	}

	/**
	 * 添加订单时进行数据更新
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            航班类型
	 */
	private void addorder_update(String jici, String type) {
		Ticket ticket = findTicketByjiciandtype(jici, type);
		// 将机票设为已购买
		clearTxt(new Ticket());// 清空机票文件
		for (int j = 0; j < tickets.size(); j++) {// 重新写入机票
			if (tickets.get(j).equals(ticket)) {
				tickets.get(j).setUsed(true);
			}
			EntryTicket(filename_ticket, tickets.get(j), true);
		}
		// 重新写入航班信息
		Model model = findModelByjiciandtype(jici, type);
		model.setNumber(model.getNumber() - 1);
		updateModel(model);
	}

	/**
	 * 查找对应航班
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            航班类型
	 * @return 航班信息
	 */
	public Model findModelByjiciandtype(String jici, String type) {
		List<Model> list = findModel();
		Model model = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJici().equals(jici)
					&& list.get(i).getType().equals(type)) {
				model = list.get(i);
			}
		}
		return model;
	}

	/**
	 * 清空文件
	 * 
	 * @param object
	 *            清空此对象的存放的文件
	 */
	private void clearTxt(Object object) {
		if (object instanceof Model) {
			EntryModel(filename_model, new Model("", "", "", "", "", 0.0, 0),
					false);
		} else if (object instanceof Ticket) {
			EntryTicket(filename_ticket,
					new Ticket("", "", "", 0.0, "", false), false);
		} else {
			EntryOrder(filename_order,
					new Order("", new Ticket("", "", "", 0.0, "", false),
							new Model("", "", "", "", "", 0.0, 0), ""), false,
					"");
		}

	}

	/**
	 * 查找用户
	 * 
	 * @param id
	 *            用户账号
	 * @return 用户
	 */
	public Customer getCustomer(String id) {
		return customers.get(id);
	}

	/**
	 * 设置用户信息，将用户信息写入文件
	 * 
	 * @param customer
	 *            用户
	 * @return 是否写入成功
	 */
	public boolean setCustomer(Customer customer) {
		return EntryCustomer(filename_user, customer);
	}

	/**
	 * 设置航班信息，将航班信息写入文件
	 * 
	 * @param model
	 *            航班信息
	 * @param flag
	 *            是否追加
	 */
	public boolean setModel(Model model, boolean flag) {
		return EntryModel(filename_model, model, flag);
	}

	/**
	 * 设置机票信息，将机票信息写入文件
	 * 
	 * @param ticket
	 *            机票信息
	 * @param flag
	 *            是否追加
	 */
	public void setTicket(Ticket ticket, boolean flag) {
		EntryTicket(filename_ticket, ticket, flag);
	}

	public void setRegister(RegisterFrame register) {
		this.register = register;
	}

	/**
	 * 设置订单，将订单信息写入文件
	 * 
	 * @param entity
	 *            订单
	 * @param add
	 *            添加
	 * @return 是否添加成功
	 */
	public boolean setOrder(Order entity, String add) {
		return EntryOrder(filename_order, entity, true, add);
	}

	/**
	 * 查找用户订单
	 * 
	 * @param name
	 *            用户姓名
	 * @return 用户的订单
	 */
	public Vector<Order> findOrderByName(String name) {
		Vector<Order> vector = new Vector<>();
		List<Order> list = findOrder();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				vector.add(list.get(i));
			}
		}
		return vector;
	}

	/**
	 * 查找所有的订单
	 * 
	 * @return 订单信息
	 */
	private List<Order> findOrder() {
		List<Order> list = new ArrayList<Order>();
		loadOrder();
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			list.add(order);
		}
		return list;
	}

	/**
	 * 删除订单信息
	 * 
	 * @param name
	 *            订单文件名
	 * @param jici
	 *            航班号
	 * @return 是否删除成功
	 */
	public boolean deleteOrder(String name, String jici) {
		boolean flag = false;
		List<Order> list = findOrder();
		flag = retuenorder_update(name, jici);
		if (flag) {
			clearTxt(new Order());
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getTicket().getJici().equals(jici)
						&& list.get(i).getName().equals(name)) {
					list.remove(i);
					i--;
					flag = true;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				EntryOrder(filename_order, list.get(i), true, "");
			}
			loadOrder();
		}
		return flag;
	}

	/**
	 * 退票时更新订单信息
	 * 
	 * @param name
	 *            用户名
	 * @param jici
	 *            航班信息
	 * @return 是否更新成功
	 */
	private boolean retuenorder_update(String name, String jici) {
		Vector<Order> v = findOrderByName(name);
		String type = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).getTicket().getJici().equals(jici)) {
				type = v.get(i).getTicket().getType();
			}
		}

		Order order = findOrderByNameAndjc(name, jici);
		int number = Integer.parseInt(order.getTicket().getZuowei());
		LoadTicket();
		clearTxt(new Ticket());// 清空机票文件
		for (int j = 0; j < tickets.size(); j++) {// 重新写入机票
			if (number - 1 == j) {
				tickets.get(j).setUsed(false);
			}
			EntryTicket(filename_ticket, tickets.get(j), true);
		}
		System.out.println(type);
		// 重新写入航班信息
		Model model = findModelByjiciandtype(jici, type);
		if (model != null) {
			model.setNumber(model.getNumber() + 1);
			updateModel(model);
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 查找订单信息
	 * 
	 * @param name
	 *            用户姓名
	 * @param jici
	 *            航班号
	 * @return 订单
	 */
	private Order findOrderByNameAndjc(String name, String jici) {
		Vector<Order> vector = findOrderByName(name);
		Order order = null;
		for (int i = 0; i < vector.size(); i++) {
			if (vector.get(i).getTicket().getJici().equals(jici)) {
				order = vector.get(i);
			}
		}
		return order;
	}

	/**
	 * 
	 * 计算用户金额
	 * 
	 * @param name
	 *            用户名
	 * @return 金额
	 */
	public double getMoney(String name) {
		List<Order> list = findOrder();
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				total += list.get(i).getTicket().getPrice();
			}
		}
		return total;
	}
}
