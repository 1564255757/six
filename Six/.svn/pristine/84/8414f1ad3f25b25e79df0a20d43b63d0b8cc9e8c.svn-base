package com.dhee.six.index.base.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.dhee.six.vo.Base;
/**
 * 出口基地实现类
 * @author 李治鑫 葛文涛
 * @since 2019.09.04
 * @author
 */
@Component
public class BaseDaoImpl implements BaseDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 查询所有基地
	 * @param：无
	 * @return：所有基地集合 List<Base>
	 * @author：李治鑫 
	 */
	@Override
	public List<Base> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select base_id,base_name,city_name from base,cities where base.base_city=cities.city_id order by city_name";
		List<Base> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Base>(Base.class));
		return list;
	}
	/**
	 * 查询基地详情
	 * @param：基地id(base_id)
	 * @return：某基地信息  Base
	 * @author：李治鑫
	 */
	@Override
	public Base select(String base_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT BASE_NAME,BASE_PROFILE FROM BASE WHERE BASE_ID=?";
		Base base = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Base>(Base.class) ,new Object[]{base_id});
		return base;
	}
	
	/*葛文涛*/
	/**
	 * 出口基地下拉框Select
	 * @param：无
	 * @return：基地集合 List<Base>
	 */
	public List<Base> Select_Base() {
		String sql = "select * from base";

		List<Base> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Base>(Base.class));
		return list;
	}
	

}
