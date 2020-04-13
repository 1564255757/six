package com.dhee.six.manager.notices.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhee.six.manager.notices.service.M_NoticesService;
import com.dhee.six.vo.Notices;
@Controller
@RequestMapping("manager/notice")
/**
 * 公告（后台）Controller类
 * 作者：赵禹博
 * 完成：2019-09-5
 */
public class M_NoticesController {
	@Autowired
	//自动装配
	private M_NoticesService m_NoticesService;
	@RequestMapping("insert")
	@ResponseBody
	/*
	 * 插入公告
	 * 参数：String类型的 notice_title,notice_context
	 * 返回类型：int 
	 */
	public int insert(String notice_title,String notice_context){
		return m_NoticesService.insert(notice_title,notice_context);
	}
	@RequestMapping("delete")
	@ResponseBody
	/*
	 * 插入公告
	 * 参数：String类型的 notice_title,notice_context
	 * 返回类型：int 
	 */
	public int delete(String notice_id){
		return m_NoticesService.delete(notice_id);
	}
	@RequestMapping("update")
	@ResponseBody
	/*
	 * 更新公告
	 * 参数：String类型的 notice_id,notice_title,notice_context
	 * 返回类型：int 
	 */
	public int update(String notice_id,String notice_title,String notice_context){
		return m_NoticesService.update(notice_id,notice_title,notice_context);
	}
	@RequestMapping("selectAll")
	@ResponseBody
	/*
	 * 查询所有公告
	 * 参数：Integ类型的page
	 * 返回类型：Map集合
	 */
	public Map<String,Object> selectAll(Integer page){
		return m_NoticesService.selectall(page);
	}
	@RequestMapping("selectid")
	@ResponseBody
	/*
	 * 按照id查询公告信息
	 * 参数：String类型的 notice_id
	 * 返回类型：Notices
	 */
	public Notices selectid(String notice_id){
		return m_NoticesService.selectid(notice_id);
	}

}
