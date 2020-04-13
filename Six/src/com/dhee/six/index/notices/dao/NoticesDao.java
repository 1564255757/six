package com.dhee.six.index.notices.dao;

import java.util.List;

import com.dhee.six.vo.Notices;
/**
 * 公告（前台）接口
 * 作者：赵禹博
 * 完成：2018-08-15
 */
public interface NoticesDao {
	//查询所有公告
	public List<Notices> selectall();
	//查询前六条公告（按时间查询最新的六条）
	public List<Notices> select();
	//按照公告id查询公告信息
	public Notices selectid(String notice_id);
}
