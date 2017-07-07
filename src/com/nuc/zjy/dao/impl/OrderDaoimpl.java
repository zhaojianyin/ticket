package com.nuc.zjy.dao.impl;

import java.util.List;

import com.nu.zjy.entity.Order;
import com.nuc.zjy.dao.OrderDao;

/**
 * @项目名称：ticket
 * @类名称：OrderDaoimpl
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 下午2:57:13
 * @version 1.0
 */
public class OrderDaoimpl implements OrderDao {

	@Override
	public boolean update(Order entity) {
		
		return false;
	}

	@Override
	public List<Order> findAll() {
		
		return null;
	}

	@Override
	public List<Order> findOrderById(String userid) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	@Override
	public boolean save(Order entity) {
		return false;
	}

	@Override
	public Order findById(String id) {
		
		return null;
	}

}
