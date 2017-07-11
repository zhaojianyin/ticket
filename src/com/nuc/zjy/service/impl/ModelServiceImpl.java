package com.nuc.zjy.service.impl;

import java.util.List;
import java.util.Vector;

import com.nu.zjy.entity.EntityContext;
import com.nu.zjy.entity.Model;
import com.nuc.zjy.service.ModelService;

/**
 * @项目名称：ticket
 * @类名称：ModelServiceImpl
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午4:12:58
 * @version 1.0
 */
public class ModelServiceImpl implements ModelService {

	private EntityContext context;

	public void setContext(EntityContext context) {
		this.context = context;
	}

	@Override
	public Model findById(String id) {
		return null;
	}

	@Override
	public boolean save(Model entity) {
		if (entity != null) {
			context.setModel(entity);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(Model entity) {
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	@Override
	public List<Model> findAll() {
		return null;
	}

	@Override
	public Vector<Model> find(String start, String end, String starttime) {
		Vector<Model> list = context.findModel(start, end, starttime);
		return list;
	}
}
