package com.nu.zjy.entity;

import java.io.Serializable;

/**
 * @项目名称：ticket
 * @类名称：Order
 * @类描述：订单实体类，包括用户名，用户机票，用户航班，购买时间
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 上午10:15:52
 * @version 1.0
 */
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 368731947052249099L;
	private String name;// 用户名
	private Ticket ticket;// 用户机票
	private Model model;
	private String buyTime;

	public Order() {
		super();
	}

	/**
	 * @param name
	 *            用户姓名
	 * @param ticket
	 *            购买的机票
	 * @param model
	 *            购买的航班信息
	 * @param buyTime
	 *            购买时间
	 */
	public Order(String name, Ticket ticket, Model model, String buyTime) {
		super();
		this.name = name;
		this.ticket = ticket;
		this.buyTime = buyTime;
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

}
