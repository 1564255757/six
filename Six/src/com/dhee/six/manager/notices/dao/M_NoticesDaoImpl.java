package com.dhee.six.manager.notices.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Notices;
/**
 * 公告接口（后台）实现类
 * 作者：赵禹博
 * 完成：2019-08-15
 */
@Repository
public class M_NoticesDaoImpl implements M_NoticesDao{
	@Autowired
	private JdbcTemplate JdbcTemplate;
	/*
	 * 新增公告信息
	 * 参数：Notices 类型的 no
	 * 返回类型：是否插入成功（0为失败，1为成功） 
	 */
	@Override
	public int insert(Notices no) {
		// TODO Auto-generated method stub
		String sql = "insert into notices (notice_id,notice_time,notice_title,notice_context) values (sys_guid(),sysdate,'"+no.getNotice_title()+"','"+no.getNotice_context()+"')";
		return JdbcTemplate.update(sql);
	}
	/*
	 * 修改公告信息
	 * 参数：int 类型 
	 * 返回类型：是否插入成功（0为失败，1为成功） 
	 */
	@Override
	public int update(Notices no) {

		// TODO Auto-generated method stub
		String sql = "update Notices set Notice_time=sysdate,Notice_title='"+no.getNotice_title()+"',Notice_context='"+no.getNotice_context()+"' where Notice_id='"+no.getNotice_id()+"'";
		return JdbcTemplate.update(sql);
	}
	/*
	 * 删除公告信息
	 * 参数：int 类型 
	 * 返回类型：是否插入成功（0为失败，1为成功） 
	 */
	@Override
	public int delete(Notices no) {
		// TODO Auto-generated method stub
		System.out.println(no.getNotice_id());
		String sql = "delete from Notices where Notice_id =?";
		return JdbcTemplate.update(sql,no.getNotice_id());
	}
	/*
	 * 查询所有公告信息
	 * 参数：无
	 * 返回类型：所有公告信息List 
	 */
	@Override
	public List<Notices> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from notices order by notice_time desc";
		return JdbcTemplate.query(sql, new BeanPropertyRowMapper<Notices>(Notices.class));
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
