package com.nu.zjy.entity;

import java.io.Serializable;

/**
 * @项目名称：ticket
 * @类名称：Ticket
 * @类描述： 车票实体类，包括航班号，座位号，票号，票价，机票类型，以及是否使用
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 上午10:16:01
 * @version 1.0
 */
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4618814018233414816L;
	private String jici;
	private String idString;// 票号
	private String zuowei;// 座位号
	private double price;// 票价
	private String type;// 机票类型
	private boolean used;// 是否使用

	public Ticket() {
		super();
	}

	/**
	 * @param jici
	 *            航班号
	 * @param idString
	 *            票号
	 * @param zuowei
	 *            座位号
	 * @param price
	 *            价格
	 * @param type
	 *            类型
	 * @param used
	 *            是否使用
	 */
	public Ticket(String jici, String idString, String zuowei, double price,
			String type, boolean used) {
		super();
		this.jici = jici;
		this.idString = idString;
		this.zuowei = zuowei;
		this.price = price;
		this.type = type;
		this.used = used;
	}

	public String getJici() {
		return jici;
	}

	public void setJici(String jici) {
		this.jici = jici;
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getZuowei() {
		return zuowei;
	}

	public void setZuowei(String zuowei) {
		this.zuowei = zuowei;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}
