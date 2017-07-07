package com.nuc.zjy.dao.impl;

import java.util.Date;
import java.util.List;

import com.nu.zjy.entity.CheCi;
import com.nuc.zjy.dao.CheCiDao;

/** 
 * @项目名称：ticket   
 * @类名称：CheCiDaoimpl   
 * @类描述：  
 *
 * @author 赵建银
 * @email 384144795@qq.com 
 * @date 2017-7-7 
 * @time 下午6:30:17 
 * @version 1.0 
 */
public class CheCiDaoimpl implements CheCiDao{

	@Override
	public List<CheCi> findByAdress(String start, String end) {
		return null;
	}

	@Override
	public List<CheCi> findByTime(Date starttime) {
		return null;
	}

	@Override
	public CheCi findById(String id) {
		return null;
	}

	@Override
	public List<CheCi> findAll() {
		return null;
	}

	@Override
	public boolean update(CheCi entity) {
		return false;
	}

	@Override
	public boolean save(CheCi entity) {
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
