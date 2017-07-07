package com.nuc.zjy.dao;

import java.util.Date;
import java.util.List;

import com.nu.zjy.entity.CheCi;

/**
 * @项目名称：ticket
 * @类名称：CheCiDao
 * @类描述：车次的接口
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:55:39
 * @version 1.0
 */
public interface CheCiDao extends BaseDao<CheCi> {

	/**
	 * 根据起点和终点查询车次
	 * 
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 * @return 返回所有对应信息的所有车次
	 */
	List<CheCi> findByAdress(String start, String end);

	/**
	 * 根据车次的起始时间查询
	 * 
	 * @param starttime
	 *            起始时间
	 * 
	 * @return
	 */
	List<CheCi> findByTime(Date starttime);

	@Override
	public CheCi findById(String id);

	@Override
	public List<CheCi> findAll();

	@Override
	public boolean update(CheCi entity);

	@Override
	public boolean save(CheCi entity);

	@Override
	public boolean delete(String id);

}
