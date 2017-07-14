package com.nuc.zjy.service.impl;

import java.util.List;

import com.nu.zjy.entity.EntityContext;
import com.nu.zjy.entity.Ticket;
import com.nuc.zjy.service.TicketService;

/**
 * @项目名称：ticket
 * @类名称：TicketDaoimpl
 * @类描述：机票接口实现类
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 下午6:31:25
 * @version 1.0
 */
public class TicketServiceimpl implements TicketService {

	private EntityContext context;

	public void setContext(EntityContext context) {
		this.context = context;
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
			context.setTicket(entity, true);
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

	/**
	 * @param entity
	 *            机票
	 * @param number
	 *            数量
	 * @return 是否存储成功
	 */
	public boolean update(Ticket entity, int number) {
		return context.updateTicket(entity, number);
	}

	/**
	 * 按航班号和类型查找机票
	 * 
	 * @param jici
	 *            航班号
	 * @param type
	 *            类型
	 * @return 机票
	 */
	public Ticket findByJiandtype(String jici, String type) {
		Ticket ticket = context.findTicketByjiciandtype(jici, type);
		return ticket;
	}

}
