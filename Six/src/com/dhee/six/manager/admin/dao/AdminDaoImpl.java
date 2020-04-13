package com.dhee.six.manager.admin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 管理员登录接口实现类
 * 作者： 贺丽萍
 * 时间：2019-08-15
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	 * 后台管理员登录
	 * 参数： 管理员账户admin_name，管理员登录密码admin_password
	 * 返回类型:是否查询到(1：成功，0：失败)  int
	 */

	@Override
	public int select(String admin_name, String admin_password) {
		
		String sql="SELECT count(*) FROM ADMIN WHERE ADMIN_NAME='"+admin_name+"' AND ADMIN_PASSWORD='"+admin_password+"'";
		int i=jdbcTemplate.queryForObject(sql,Integer.class);
		return i;
	}
}
