package com.nuc.zjy.service.impl;

import java.util.List;

import com.nu.zjy.entity.EntityContext;
import com.nu.zjy.entity.Ticket;
import com.nuc.zjy.service.TicketService;

/**
 * @项目名称：ticket
 * @类名称：TicketDaoimpl
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 下午6:31:25
 * @version 1.0
 */
public class TicketServiceimpl implements TicketService {

	private EntityContext context;

	public EntityContext getContext() {
		return context;
	}

	public void setContext(EntityContext context) {
		this.context = context;
	}

	@Override
	public List<Ticket> findCheciById(String checiid) {
		
		return null;
	}

	@Override
	public boolean delete(String id) {
		
		return false;
	}

	@Override
	public Ticket findById(String id) {
		return null;
	}

	@Override
	public boolean save(Ticket entity) {
		if (entity != null) {
			context.setTicket(entity);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Ticket> findAll() {
		return null;
	}

	@Override
	public boolean update(Ticket entity) {
		return false;
	}

}
