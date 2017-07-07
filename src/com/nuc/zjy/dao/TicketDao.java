package com.nuc.zjy.dao;

import java.util.List;

import com.nu.zjy.entity.Ticket;

/**
 * @项目名称：ticket
 * @类名称：TicketDao
 * @类描述：车票接口类
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:16:09
 * @version 1.0
 */
public interface TicketDao extends BaseDao<Ticket> {

	/**
	 * 根据车次的id查询本车次的所有车票
	 * 
	 * @param checiid
	 *            车次的id
	 * @return 本车次的所有车票
	 */
	List<Ticket> findCheciById(String checiid);

	@Override
	public boolean delete(String id);

	@Override
	public Ticket findById(String id);

	@Override
	public boolean save(Ticket entity);

	@Override
	public List<Ticket> findAll();

	@Override
	public boolean update(Ticket entity);

}
