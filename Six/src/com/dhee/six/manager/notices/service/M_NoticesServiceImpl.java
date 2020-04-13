package com.dhee.six.manager.notices.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.manager.notices.dao.M_NoticesDao;
import com.dhee.six.vo.Notices;
/**
 * 公告severice接口（后台）实现类
 * 作者：赵禹博
 * 完成：2019-09-5
 */
@Service
public class M_NoticesServiceImpl implements M_NoticesService{
//自动装配
	@Autowired
	private M_NoticesDao m_NoticesDao;

	@Override
	/*
	 * 插入公告
	 * 参数：String类型的 notice_title,notice_context
	 * 返回类型：int 
	 */
	public int insert(String notice_title,String notice_context) {
		// TODO Auto-generated method stub
		Notices no = new Notices();
		no.setNotice_title(notice_title);
		no.setNotice_context(notice_context);
		return m_NoticesDao.insert(no);
	}

	@Override
	/*
	 * 修改公告
	 * 参数：String类型的 notice_id,notice_context,notice_title
	 * 返回类型：int 
	 */
	public int update(String notice_id,String notice_title,String notice_context) {
		// TODO Auto-generated method stub
		Notices notices = new Notices();
		notices.setNotice_id(notice_id);
		notices.setNotice_title(notice_title);
		notices.setNotice_context(notice_context);
		return m_NoticesDao.update(notices);
	}

	@Override
	/*
	 * 删除公告
	 * 参数：String类型的 notice_id,notice_context,notice_title
	 * 返回类型：int 
	 */
	public int delete(String notice_id) {
		// TODO Auto-generated method stub
		Notices no = new Notices();
		no.setNotice_id(notice_id);
		return m_NoticesDao.delete(no);
	}

	@Override
	/*
	 * 显示全部公告
	 * 参数：int类型的page
	 * 返回类型：Map集合
	 */
	public Map<String,Object> selectall(int page) {
	// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		
		 List<Notices> list = m_NoticesDao.selectAll();
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
	 * 按照id查询公告
	 * 参数：String类型的 notice_id
	 * 返回类型：Notice
	 */
	public Notices selectid(String notice_id) {
		// TODO Auto-generated method stub
		return m_NoticesDao.selectid(notice_id);
	}

}
