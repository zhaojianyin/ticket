package com.nuc.zjy.service.impl;

import java.util.List;

import com.nu.zjy.entity.Customer;
import com.nu.zjy.entity.EntityContext;
import com.nuc.zjy.exception.CustomerException;
import com.nuc.zjy.service.CustomerService;

/**
 * @项目名称：ticket
 * @类名称：CustomerDaoimpl
 * @类描述：顾客接口实现类
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 下午6:30:45
 * @version 1.0
 */
public class CustomerServiceimpl implements CustomerService {

	private EntityContext context;

	@Override
	public boolean login(String id, String password) {
		boolean flag = false;
		Customer customer = null;
		try {
			customer = this.findById(id);
			if (customer == null) {
				throw new CustomerException("查无此人!");
			}
			if (customer.getPasswd().equals(password)) {
				flag = true;// 登录成功
			} else {
				throw new CustomerException("密码错误!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void setContext(EntityContext context) {
		this.context = context;
	}

	@Override
	public Customer findById(String id) {
		Customer customer = context.getCustomer(id);
		return customer;
	}

	@Override
	public boolean save(Customer customer) {
		return context.setCustomer(customer);
	}

	@Override
	public boolean update(Customer entity) {
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	@Override
	public List<Customer> findAll() {
		return null;
	}

}
