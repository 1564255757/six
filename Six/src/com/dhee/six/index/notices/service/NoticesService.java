package com.dhee.six.index.notices.service;

import java.util.List;
import java.util.Map;

import com.dhee.six.vo.Notices;
/**
 * 公告（前台）service类
 * 作者：赵禹博
 * 完成：2019-09-5
 */
public interface NoticesService {
	//查询所有公告
		public Map<String,Object> selectall(int page);
		//查询前六条公告（按时间查询最新的六条）
		public List<Notices> select();
		//按照公告id查询公告信息
		public Notices selectid(String notice_id);

}
