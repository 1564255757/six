package com.dhee.six.manager.base.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Base;
import com.dhee.six.vo.Cities;

/**
 * 企业接口实现类
 * 作者：尹希栋
 * 完成时间：2019/08/15
 */
@Repository
public class M_BaseDaoImpl implements M_BaseDao{
   @Autowired
   private JdbcTemplate jdbcTemplate;
	/*葛文涛*/
	/*
	 * 作用：前台注册时城市与基地的连接交互
	 * 参数：citiesVo:城市实体类对象，用于获取city_id
	 * 返回类型：城市id对应的基地list
	 */
   @Override
	public List<Base> Cities_Base(Cities citiesVo) {
		String sql = "select * from base where base_city=?";

		List<Base> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Base>(Base.class),citiesVo.getCity_id());
		return list;
	}
	
	/*尹希栋*/
	/*
	 * 分页遍历基地
	 * 参数： 分页起始索引(start)
	 * 返回类型：某页的所有基地集合 List<Base>
	 */
	@Override
	public List<Base> selBase(int start) {
		String sql="SELECT A.* FROM(SELECT ROWNUM R,BASE_ID,BASE_NAME FROM BASE)A "
				+ "WHERE R BETWEEN ? AND ?";
		return jdbcTemplate.query(sql,new Object[]{start,start+11},new BeanPropertyRowMapper<Base>(Base.class));
	}
	/*
	 * 增加基地
	 * 参数： 基地信息实体类(base)
	 * 返回类型：insert语句影响的行数 int
	 */
	@Override
	public int insBase(Base base) {
		String sql="INSERT INTO BASE VALUES(SYS_GUID(),?,?,?)";
		return jdbcTemplate.update(sql,new Object[]{base.getBase_name(),base.getBase_city(),base.getBase_profile()});
	}
	/*
	 * 某基地详细信息
	 * 参数： 要查询的基地id(id)
	 * 返回类型：基地信息实体类 Base
	 */
	@Override
	public Base selBaseInfo(String id) {
		String sql="SELECT * FROM BASE,CITIES WHERE BASE_CITY=CITY_ID AND BASE_ID=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Base>(Base.class));
	}
	/*
	 * 删除某基地
	 * 参数： 要删除的基地id(id)
	 * 返回类型：delete语句影响的行数 int
	 */
	@Override
	public int delBase(String id) {
		String sql="DELETE FROM BASE WHERE BASE_ID=?";
		return jdbcTemplate.update(sql,id);
	}
	/*
	 * 修改基地
	 * 参数： 基地信息实体类 Base（base）
	 * 返回类型：UPDATE语句影响的行数 int
	 */
	@Override
	public int updBase(Base base) {
		String sql="UPDATE BASE SET BASE_NAME=?,BASE_CITY=?,BASE_PROFILE=?"
				+ " WHERE BASE_ID=?";
		return jdbcTemplate.update(sql,new Object[
		                                          ]{base.getBase_name(),base.getBase_city(),base.getBase_profile(),base.getBase_id()});
	}
	/*
	 * 基地名是否重复
	 * 参数： 要检测的基地名字(name)
	 * 返回类型：该name在数据库中的数量 int
	 */
	@Override
	public int selBaseNameReapeat(String basename) {
		String sql="SELECT count(*) FROM BASE WHERE BASE_NAME=?";	
		return jdbcTemplate.queryForObject(sql,Integer.class,basename);
	}
	/*
	 * 根据基地id查询基地name
	 * 参数： 要查询的基地id(id)
	 * 返回类型：查询到的基地名 string
	 */
	@Override
	public String selBaseNameById(String id) {
		String sql="SELECT BASE_NAME FROM BASE WHERE BASE_ID=?";
		return jdbcTemplate.queryForObject(sql,String.class,id);
	}

	@Override
	public int selBaseAmount() {
		String sql="SELECT COUNT(*) FROM BASE";
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(sql.toString(),Integer.class);
	}

}
