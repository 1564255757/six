package com.dhee.six.manager.notices.service;

import java.util.Map;
import com.dhee.six.vo.Notices;
/**
 * 公告severice接口（后台）
 * 作者：赵禹博
 * 完成：2019-09-5
 */
public interface M_NoticesService {
	/*
	 * 插入公告
	 */
		public int insert(String notice_title,String notice_context);
		/*
		 * 修改公告
		 */
		public int update(String notice_id,String notice_title,String notice_context);
		/*
		 * 删除公告
		 */
		public int delete(String notice_id);
		/*
		 * 查询所有公告公告
		 */
		public Map<String,Object> selectall(int page);
		/*
		 * 按照id查询公告
		 */
		public Notices selectid(String notice_id);

}
