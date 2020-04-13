package com.dhee.six.manager.notices.dao;

import java.util.List;

import com.dhee.six.vo.Notices;
/**
 * 公告（后台）接口
 * 作者：赵禹博
 * 完成：2019-08-15
 */
public interface M_NoticesDao {
	/*
	 * 新增公告信息
	 */
	public int insert(Notices no);
	/*
	 * 修改公告信息 
	 */
	public int update(Notices no);
	/*
	 * 删除公告信息
	 */
	public int delete(Notices no);
	/*
	 * 显示所有公告
	 */
	public List<Notices> selectAll();
	/*
	 * 按照id查询公告详情
	 */
		public Notices selectid(String notice_id);

}
