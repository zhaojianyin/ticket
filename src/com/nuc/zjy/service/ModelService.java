package com.nuc.zjy.service;

import java.util.Vector;

import com.nu.zjy.entity.Model;

/**
 * @项目名称：ticket
 * @类名称：ModelService
 * @类描述：航班接口类
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午4:10:48
 * @version 1.0
 */
public interface ModelService extends BaseDao<Model> {

	/**
	 * 查符合要求的航班信息及起点和终点相同起飞时间为传入的时间之后的航班
	 * 
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 * @param starttime
	 *            起飞时间
	 * @return 符合要求的所有航班
	 */
	public Vector<Model> find(String start, String end, String starttime);
}
