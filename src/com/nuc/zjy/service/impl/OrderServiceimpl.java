package com.nuc.zjy.service.impl;

import java.util.List;
import java.util.Vector;

import com.nu.zjy.entity.EntityContext;
import com.nu.zjy.entity.Order;
import com.nuc.zjy.service.OrderService;

/**
 * @项目名称：ticket
 * @类名称：OrderDaoimpl
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 下午2:57:13
 * @version 1.0
 */
public class OrderServiceimpl implements OrderService {

	private EntityContext context;

	public void setContext(EntityContext context) {
		this.context = context;
	}

	@Override
	public boolean update(Order entity) {
		return false;
	}

	@Override
	public List<Order> findAll() {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	/**
	 * 删除用户订单
	 * 
	 * @param name
	 *            用户姓名
	 * @param jc
	 *            用户订单的航班
	 * @return 是否删除成功
	 */
	public boolean delete(String name, String jc) {
		return context.deleteOrder(name, jc);
	}

	/**
	 * 
	 * 存储订单
	 * 
	 * @param entity
	 *            订单
	 * @param add
	 *            存储标记
	 * @return 是否存储成功
	 */
	public boolean save(Order entity, String add) {
		return context.setOrder(entity, add);
	}

	@Override
	public Order findById(String id) {
		return null;
	}

	/**
	 * 按用户查找订单
	 * 
	 * @param name
	 *            用户姓名
	 * @return 用户的所有订单
	 */
	public Vector<Order> findByName(String name) {
		return context.findOrderByName(name);
	}

	/**
	 * 计算用户订单的总金额
	 * 
	 * @param name
	 *            用户姓名
	 * @return 用户订单总金额
	 */
	public double getMoney(String name) {
		return context.getMoney(name);
	}

	@Override
	public boolean save(Order entity) {
		return false;
	}

}
