package com.nuc.zjy.service;

import java.util.List;

import com.nu.zjy.entity.Order;

/**
 * @项目名称：ticket
 * @类名称：OrderDao
 * @类描述：订单接口类
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:55:06
 * @version 1.0
 */
public interface OrderService extends BaseDao<Order> {

	/**
	 * 根据用户id查询用户的所有订单
	 * 
	 * @param userid
	 *            用户id
	 * @return 用户的所有订单
	 */
	List<Order> findOrderById(String userid);

	@Override
	public boolean delete(String id);

	@Override
	public boolean save(Order entity);

	@Override
	public Order findById(String id);

}
