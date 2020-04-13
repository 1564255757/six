package com.dhee.six.index.scope.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Scope;
/**
 * 前台经营范围接口实现类
 * 作者：尹希栋
 * 完成时间：2019/08/15
 */
@Repository
public class ScopeDaoImpl implements ScopeDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	 * 查询所有经营范围
	 * 参数： 无
	 * 返回类型：所有经营范围集合 List<Scope>
	 */
	@Override
	public List<Scope> selAll() {
		String sql="SELECT * FROM SCOPE";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Scope>(Scope.class));
	}

}
