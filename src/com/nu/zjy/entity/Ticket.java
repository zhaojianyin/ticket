package com.nu.zjy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称：ticket
 * @类名称：Ticket
 * @类描述： 车票试题类
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:16:01
 * @version 1.0
 */
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4618814018233414816L;
	private CheCi checi;// 车次
	private String zuowei;// 座位号
	private String idString;// 票号
	private Date buy_date;// 购买时间
	private double price;// 票价
	private String type;// 车票类型
	private Date starttime;
	private String start;
	private String end;
	private boolean used;// 是否使用
	private int number;// 剩余数量

	public Ticket() {
		super();
	}

	/**
	 * @param checi
	 *            车次
	 * @param zuowei
	 *            座位号
	 * @param idString
	 *            票号
	 * @param buy_date
	 *            购买时间
	 * @param price
	 *            价格
	 * @param type
	 *            车票类型
	 * @param starttime
	 *            发车时间
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 * @param used
	 *            是否使用
	 */
	public Ticket(CheCi checi, String zuowei, String idString, Date buy_date,
			double price, String type, Date starttime, String start,
			String end, boolean used) {
		super();
		this.checi = checi;
		this.zuowei = zuowei;
		this.idString = idString;
		this.buy_date = buy_date;
		this.price = price;
		this.type = type;
		this.starttime = starttime;
		this.start = start;
		this.end = end;
		this.used = used;
	}

	public String getZuowei() {
		return zuowei;
	}

	public String getIdString() {
		return idString;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public Date getStarttime() {
		return starttime;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public CheCi getCheci() {
		return checi;
	}

	public void setCheci(CheCi checi) {
		this.checi = checi;
	}

	public void setZuowei(String zuowei) {
		this.zuowei = zuowei;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Ticket [checi=" + checi + ", zuowei=" + zuowei + ", idString="
				+ idString + ", buy_date=" + buy_date + ", price=" + price
				+ ", type=" + type + ", starttime=" + starttime + ", start="
				+ start + ", end=" + end + ", used=" + used + ", number="
				+ number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((buy_date == null) ? 0 : buy_date.hashCode());
		result = prime * result + ((checi == null) ? 0 : checi.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result
				+ ((idString == null) ? 0 : idString.hashCode());
		result = prime * result + number;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result
				+ ((starttime == null) ? 0 : starttime.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (used ? 1231 : 1237);
		result = prime * result + ((zuowei == null) ? 0 : zuowei.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (buy_date == null) {
			if (other.buy_date != null)
				return false;
		} else if (!buy_date.equals(other.buy_date))
			return false;
		if (checi == null) {
			if (other.checi != null)
				return false;
		} else if (!checi.equals(other.checi))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (idString == null) {
			if (other.idString != null)
				return false;
		} else if (!idString.equals(other.idString))
			return false;
		if (number != other.number)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (used != other.used)
			return false;
		if (zuowei == null) {
			if (other.zuowei != null)
				return false;
		} else if (!zuowei.equals(other.zuowei))
			return false;
		return true;
	}

}
