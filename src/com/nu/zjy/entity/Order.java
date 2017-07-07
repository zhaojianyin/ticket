package com.nu.zjy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @项目名称：ticket
 * @类名称：Order
 * @类描述：订单实体类
 * 
 * @author 赵建银
 * @email 384144795@qq.com
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
	private List<Ticket> list;// 用户车票
	private double total;//订单总金额

	public Order() {
		super();
	}

	public List<Ticket> getList() {
		return list;
	}

	public void setList(List<Ticket> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Order other = (Order) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
