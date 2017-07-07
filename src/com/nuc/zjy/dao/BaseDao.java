package com.nuc.zjy.dao;

import java.util.List;

/**
 * @项目名称：ticket
 * @类名称：BaseDao
 * @类描述：接口基类
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午11:01:28
 * @version 1.0
 */
public interface BaseDao<T> {
	/**
	 * 根据id查询实体
	 * 
	 * @param id
	 * @return 返回实体
	 */
	T findById(String id);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return 是否保存成功
	 */
	boolean save(T entity);

	/**
	 * 修改实体类
	 * 
	 * @param entity
	 *            实体类
	 * @return 是否修改成功
	 */
	boolean update(T entity);

	/**
	 * 根据id删除实体
	 * 
	 * @param id
	 *            id号
	 * @return
	 */
	boolean delete(String id);

	/**
	 * 获取所有实体
	 * 
	 * @return 所有实体
	 */
	List<T> findAll();

}
