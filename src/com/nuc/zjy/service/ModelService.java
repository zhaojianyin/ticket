package com.nuc.zjy.service;

import java.util.Vector;

import com.nu.zjy.entity.Model;

/**
 * @项目名称：ticket
 * @类名称：ModelService
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午4:10:48
 * @version 1.0
 */
public interface ModelService extends BaseDao<Model> {

	public Vector<Model> find(String start, String end, String starttime);
}
