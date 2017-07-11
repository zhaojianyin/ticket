package com.nu.zjy.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.nuc.zjy.exception.CustomerException;
import com.nuc.zjy.util.Config;

/**
 * @项目名称：ticket
 * @类名称：EntityContext
 * @类描述：实体控制类
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-8
 * @time 上午10:56:22
 * @version 1.0
 */
public class EntityContext {
	private HashMap<String, Customer> customers = new HashMap<String, Customer>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	private List<Model> models = new ArrayList<Model>();
	private Config config;
	private String filename_user;
	private String filename_ticket;
	private String filename_model;

	// 加载信息，在使用时加载，在之前加载会造成数据错误
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

	public EntityContext(Config config) {
		this.config = config;
		filename_user = config.getString("UserFile");
		filename_ticket = config.getString("TicketFile");
		filename_model = config.getString("ModelFile");
	}

	/**
	 * 加载用户信息，存入map中
	 * 
	 * @param filename
	 *            用户信息的文件名
	 */
	private void loadCustomer(String filename) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.startsWith("#")) {
					continue;
				}
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
	 * @return 解析到的当前顾客
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
	public void EntryCustomer(String filename, Customer customer) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename, true), "UTF-8"));
			if (customers.get(customer.getiD()) == null) {// 判断用户是否存在
				String str = inUser(customer);
				out.write(str);
				out.write("\n");
			} else {
				throw new CustomerException("用户已经存在");
			}
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
	 * 将顾客信息转换为字符串
	 * 
	 * @param customer
	 *            传入顾客
	 * @return 返回转化的字符串
	 */
	private String inUser(Customer customer) {
		String str = null;
		if (customer != null) {
			str = customer.getiD() + ":" + customer.getName() + ":"
					+ customer.getPasswd() + ":" + customer.getCardId() + ":"
					+ customer.getType();
		} else {
			throw new NullPointerException();
		}
		return str;
	}

	/**
	 * 解析机票信息-CT090:CT09:0:头等舱:980.0:false
	 * 
	 * @param str
	 *            传入机票信息字符串
	 * @return 解析到的当前机票
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
	 * @return 解析到的当前航班
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
	 * 加载存放票的文件信息
	 * 
	 * @param filename
	 *            存放票的文件名
	 */
	private void LoadTicket(String filename) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.startsWith("#")) {
					continue;
				}
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
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					filename), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.startsWith("#")) {
					continue;
				}
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
	 *            model文件名
	 * @param model
	 *            航班
	 */
	public void EntryModel(String modelname, Model model) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(modelname, true), "UTF-8"));
			String modelString = inModel(model);
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
	}

	/**
	 * @param ticketname
	 *            票的文件名称
	 * @param ticket
	 *            票
	 */
	public void EntryTicket(String ticketname, Ticket ticket) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(ticketname, true), "UTF-8"));
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
		String str = null;
		if (ticket != null) {
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
		String str = null;
		if (model != null) {
			str = model.getJici() + "/" + model.getStart() + "/"
					+ model.getEnd() + "/" + model.getStarttime() + "/"
					+ model.getNumber();

		}
		return str;
	}

	/**
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 * @param starttime
	 *            出发时间
	 * @return 符合条件的航班信息
	 */
	public Vector<Model> findModel(String start, String end, String starttime) {
		Vector<Model> list = new Vector<Model>();
		LoadModel();
		for (int i = 0; i < models.size(); i++) {
			Model model = models.get(i);
			if (model.getStart().equals(start) && model.getEnd().equals(end)
					&& model.getStarttime().compareTo(starttime) > 0) {
				list.add(model);
			}
		}
		return list;

	}

	public Customer getCustomer(String id) {
		return customers.get(id);
	}

	public void setCustomer(Customer customer) {
		EntryCustomer(filename_user, customer);
	}

	public void setModel(Model model) {
		EntryModel(filename_model, model);
	}

	public void setTicket(Ticket ticket) {
		EntryTicket(filename_ticket, ticket);
	}

}
