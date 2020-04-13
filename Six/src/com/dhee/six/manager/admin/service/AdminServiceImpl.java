package com.dhee.six.manager.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.manager.admin.dao.AdminDao;

/**
 * 管理员登录接口实现类
 * @author  贺丽萍
 * @version 2019.09.03
 *
 */

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	/*
	 * 后台管理员登录
	 * 参数： 管理员账户admin_name，管理员登录密码admin_password
	 * 返回类型:是否查询到(1：成功，0：失败)  int
	 */
	public int admin(String admin_name,String admin_password){
		int i=adminDao.select(admin_name, admin_password);
		return i;

	}

}
