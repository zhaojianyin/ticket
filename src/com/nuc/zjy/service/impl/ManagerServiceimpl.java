package com.nuc.zjy.service.impl;

import com.nuc.zjy.service.ManagerService;

/**
 * @项目名称：ticket
 * @类名称：ManagerDaoimpl
 * @类描述：管理员的接口实现类
 * 
 * @author 赵建银
 * @date 2017-7-7
 * @time 下午6:31:01
 * @version 1.0
 */
public class ManagerServiceimpl implements ManagerService {

	@Override
	public boolean login(String id, String password) {
		if (id.equals("admin") && password.equals("123456")) {
			return true;
		}
		return false;
	}

}
