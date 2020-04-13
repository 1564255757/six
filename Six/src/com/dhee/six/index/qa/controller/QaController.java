package com.dhee.six.index.qa.controller;
/**
 * 前台密保controller
 * 作者：尹希栋，贺丽萍
 * 完成时间：2019/09/05
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhee.six.index.qa.service.QaService;
import com.dhee.six.vo.Corporate;
import com.dhee.six.vo.Qa;
import com.dhee.six.vo.Question;

@Controller
@RequestMapping("index/qa")
public class QaController {
	@Autowired
	private QaService qaService;
	/*
	 * 查询密保
	 * 参数： 当前登录企业的session
	 * 返回类型：当前用户的密保，及所有的密保问题Map<String,Object>
	 */
	@RequestMapping("selProtection")
	@ResponseBody
	public Map<String,Object> selProtection(HttpSession session){
		Corporate c=(Corporate)session.getAttribute("corporate");
		return qaService.selProtection(c.getCorporate_username());
	}
	/*
	 * 增加密保
	 * 参数： 企业实体类co，当前登录企业的session
	 * 返回类型：数据库插入影响行数（int）
	 */
	@RequestMapping("addProtection")
	@ResponseBody
	public int addProtection(Corporate co,HttpSession session){
		Corporate c=(Corporate)session.getAttribute("corporate");
		String name=c.getCorporate_username();
		List<Qa> qa=co.getQa();
		for(int i=0;i<qa.size();i++){
			qa.get(i).setId(name);
		}
		return qaService.addProtection(co.getQa());
	}
	/*
	 * 查询所有密保问题
	 * 参数： 无
	 * 返回类型：所有密保问题集合（List<Question>）
	 */
	@RequestMapping("selQuestion")
	@ResponseBody
	public List<Question> selQuestion(){
		return qaService.selQuestion();
	}
	/*
	 * 重置用户密保
	 * 参数： 密保对象qa
	 * 返回类型：数据库插入影响行数（int）
	 */
	@RequestMapping("resetProtection")
	@ResponseBody
	public int resetProtection(Corporate co){
		return qaService.updProtection(co.getQa());
	}
	
	
	//贺丽萍
	/*
	 * 查询是否存在该用户
	 * 参数： 用户名user_id
	 * 返回类型:是否存在(1：存在，0：不存在)  int
	 */
	@RequestMapping("select")
	@ResponseBody
	public int select(String user_id){
		return qaService.selectById(user_id);
		}
	/*
	 * 查询该用户是否设置密保问题
	 * 参数： 用户id name
	 * 返回类型:是否设置(1：设置，0：无)  int
	 */
	@RequestMapping("select1")
	@ResponseBody
	public int select1(String name){
		return qaService.selectHavaProtection(name);
		}
	/*
	 * 查询该用户密保问题
	 * 参数： 用户名 name
	 * 返回类型:用户的密保问题的集合 List<Qa>
	 */
	@RequestMapping("selectProtection")
	@ResponseBody
	public List<Qa> selectProtection(String name){
		System.out.println(name);
		return qaService.selectProtection(name);
	}
	/*
	 * 查询密保答案是否正确
	 * 参数： 企业实体类c,用户名 name
	 * 返回类型:用户密码
	 */
	@RequestMapping("checkProtection")
	@ResponseBody
	public String checkProtection(Corporate c, String name){
		return qaService.checkProtection(c.getQa(), name);
	}
}
