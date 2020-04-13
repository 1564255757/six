package com.dhee.six.index.notices.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhee.six.index.notices.service.NoticesService;
import com.dhee.six.vo.Notices;
/**
 * 公告（前台）Controller类
 * 作者：赵禹博
 * 完成：2019-09-5
 */
@Controller
@RequestMapping("index/notice")
public class NoticesController {
	@Autowired
	//自动装配
	private NoticesService noticesService;
	@RequestMapping("selectAll")
	@ResponseBody
	/*
	 * 查询所有公告信息
	 * 参数：Integ类型的page
	 * 返回类型：所有公告信息List 
	 */
	public Map<String,Object> selectAll(Integer page){
		return noticesService.selectall(page);
	}
	@RequestMapping("select")
	@ResponseBody
	/*
	 * 按照时间查询前六条公告信息
	 * 参数：无
	 * 返回类型：前六条公告信息List 
	 */
	public List<Notices> select(){
		return noticesService.select();
	}
	@RequestMapping("selectid")
	@ResponseBody
	/*
	 * 按照id查询公告信息
	 * 参数：String类型的 notice_id
	 * 返回类型：公告信息List 
	 */
	public Notices selectid(String notice_id){
		return noticesService.selectid(notice_id);
	}

}
