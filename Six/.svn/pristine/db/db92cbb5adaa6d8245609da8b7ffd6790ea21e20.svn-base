package com.dhee.six.index.notices.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.index.notices.dao.NoticesDao;
import com.dhee.six.vo.Notices;
/**
 * 公告severice接口（前台）实现类
 * 作者：赵禹博
 * 完成：2019-09-5
 */
@Service
public class NoticesServiceImpl implements NoticesService {
	@Autowired
	//自动装配
	private NoticesDao noticesdao;
	@Override
	/*
	 * 查询所有公告
	 * 参数：int型 page
	 * 返回类型：所有公告信息List 
	 */
	public Map<String,Object> selectall(int page) {
	// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		 List<Notices> list = noticesdao.selectall();
		 int coutpage = 0;
		 if(list.size()%12==0){
			 coutpage=list.size()/12;
		 }else{
			 coutpage=list.size()/12+1;
		 }
		 map.put("total", coutpage);
		 int fromIndex = (page-1)*12;
		 if(page==coutpage){
			 list = list.subList(fromIndex, list.size());
		 }else if(page<coutpage){
			 list = list.subList(fromIndex, fromIndex+12);
		 }
		 map.put("list", list);
		return map;
	}

	@Override
	/*
	 * 按照时间查询前六条公告信息
	 * 参数：无
	 * 返回类型：前六条公告信息List 
	 */
	public List<Notices> select() {
		// TODO Auto-generated method stub
		return noticesdao.select();
	}

	@Override
	/*
	 * 按照id查询公告信息
	 * 参数：无
	 * 返回类型：查询到的公告信息List 
	 */
	public Notices selectid(String notice_id) {
		// TODO Auto-generated method stub
		return noticesdao.selectid(notice_id);
	}

}
