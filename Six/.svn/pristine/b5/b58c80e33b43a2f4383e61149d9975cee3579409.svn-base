package com.dhee.six.index.cities.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Cities;

/**
 * 前台城市dao接口实现类
 * 作者：尹希栋
 * 完成时间：2019/08/15
 */
@Repository
public class CitiesDaoImpl implements CitiesDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	 * 查询所有城市
	 * 参数： 无
	 * 返回类型：所有城市集合 List<Cities>
	 */
	@Override
	public List<Cities> selAll(){
		String sql="SELECT * FROM CITIES";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Cities>(Cities.class));
	}

}
