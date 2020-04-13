package com.dhee.six.index.notices.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Notices;
/**
 * 公告（dao）接口（前台）实现类
 * 作者：赵禹博
 * 完成：2018-08-15
 */
@Repository
public class NoticesDaoImpl implements NoticesDao {
	
	/*
	 * 查询所有公告信息
	 * 参数：无
	 * 返回类型：所有公告信息List 
	 */
	@Autowired
	private JdbcTemplate JdbcTemplate;
	@Override
	public List<Notices> selectall() {
		return JdbcTemplate.query("select * from notices order by notice_time desc", new BeanPropertyRowMapper<Notices>(Notices.class));
	}

	/*
	 * 按招发布时间查询最新发布的六条信息
	 * 参数：无
	 * 返回类型：最新的六条公告信息List
	 */
	@Override
	public List<Notices> select() {
		// TODO Auto-generated method stub
		return JdbcTemplate.query("select rownum,e.* from(select * from notices order by notice_time desc)e where rownum<=6", new BeanPropertyRowMapper<Notices>(Notices.class));
		
	}
	/*
	 * 按照公告id查询公告的所有信息
	 * 参数：公告id   notice_id
	 * 返回类型：一条公告信息Notice
	 */
	@Override
	public Notices selectid(String notice_id) {
		// TODO Auto-generated method stub
		Notices n= (Notices)JdbcTemplate.queryForObject("select * from notices where notice_id=?", new BeanPropertyRowMapper<Notices>(Notices.class),new Object[]{notice_id});
		return n;
	}


	}

