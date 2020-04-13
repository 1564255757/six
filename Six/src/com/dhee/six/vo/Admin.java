package com.dhee.six.vo;

/**
 * 管理员实体类
 * 作者： 贺丽萍
 * 完成时间：2019-08-15
 *
 */

public class Admin {
	/* 管理员ID */
	private String admin_id;
	/* 管理员用户名 */
	private String admin_name;
	/* 管理员登录密码 */
	private String admin_password;
	
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	

}
