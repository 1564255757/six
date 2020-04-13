package com.dhee.six.manager.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhee.six.manager.admin.service.AdminService;
/**
 * 后台管理员登录controller层 
 * 作者：贺丽萍
 * 完成时间：2019/09/04
 */
@Controller
@RequestMapping("manager/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	/*贺丽萍*/
	/*
	 * 后台管理员登录
	 * 参数： 管理员账户admin_name，管理员登录密码admin_password
	 * 返回类型:是否查询到(1：成功，0：失败)  int
	 */
	@RequestMapping("adm")
	@ResponseBody
	public int admin(String admin_name,String admin_password,HttpSession session){
		int flag=adminService.admin(admin_name,admin_password);
		if(flag>=1){
			session.setAttribute("adminInfo", admin_name);
		}
		return flag;
		
	}

}
