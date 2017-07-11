package com.nu.zjy.entity;

/**
 * @项目名称：ticket
 * @类名称：Model
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-10
 * @time 上午11:27:51
 * @version 1.0
 */
public class Model {
	private String jici;// 车次
	private String starttime;
	private String start;
	private String end;
	private String type;
	private double price;
	private int number;// 剩余数量

	public Model() {
		super();
	}

	public Model(String jici, String starttime, String start, String end,
			String type, double price, int number) {
		super();
		this.jici = jici;
		this.starttime = starttime;
		this.start = start;
		this.end = end;
		this.type = type;
		this.price = price;
		this.number = number;
	}

	public String getJici() {
		return jici;
	}

	public void setJici(String jici) {
		this.jici = jici;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Model [jici=" + jici + ", starttime=" + starttime + ", start="
				+ start + ", end=" + end + ", type=" + type + ", price="
				+ price + ", number=" + number + "]";
	}

	
}
