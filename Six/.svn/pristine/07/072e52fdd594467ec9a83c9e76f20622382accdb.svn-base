package com.dhee.six.index.corporate.dao;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Corporate;
import com.dhee.six.vo.Search;
/**
 * 前台企业接口实现类
 * 作者：尹希栋，李治鑫，葛文涛，贺丽萍
 * 完成时间：2019/08/15
 */
@Repository
public class CorporateDaoImpl implements CorporateDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Corporate CorporateInfo(String id) {
		// TODO Auto-generated method stub
		String sql="SELECT SCOPE_NAME,BASE_NAME,A.* FROM CORPORATE A,SCOPE,BASE WHERE "
				+ "A.CORPORATE_BASE=BASE_ID(+) AND A.CORPORATE_SCOPE=SCOPE_ID AND CORPORATE_ID=?";	
		return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Corporate>(Corporate.class));
	}
	/*尹希栋*/
	/*
	 * 查询符合条件企业
	 * 参数：筛选条件实体类(search)
	 * 返回类型：所有符合条件的企业集合 List<Corporate>
	 */
	@Override
	public List<Corporate> selCorporate(Search search){
		String scope=search.getScope();
		String city=search.getCity();
		Integer click=search.getClick();
		StringBuilder sql=new StringBuilder("SELECT * FROM (SELECT A.*,ROWNUM R FROM (SELECT CORPORATE_ID,CORPORATE_NAME,CORPORATE_LOGO_PATH,"
				+ "CORPORATE_LOGO_NAME FROM CORPORATE,BASE WHERE CORPORATE_BASE=BASE_ID(+) AND CORPORATE_STATE=1");
		if(scope!=null&&scope!=" "){
			sql.append("AND CORPORATE_SCOPE='"+scope+"'");
		}
		if(city!=null&&scope!=" "){
			sql.append("AND BASE_CITY='"+city+"'");
		}
		if(click==1){
			sql.append("ORDER BY CORPORATE_CLICK DESC");
		}else if(click==2){
			sql.append("ORDER BY CORPORATE_CLICK");
		}
		sql.append(") A ) WHERE R BETWEEN "+search.getStart()+" AND "+(search.getStart()+11)+"");
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<Corporate>(Corporate.class));
	}
	/*
	 * 前台用户修改企业信息
	 * 参数： 修改企业信息实体类(corporate)
	 * 返回类型：SQL语句影响行数  int
	 */
	@Override
	public int updCorporate(Corporate corporate) {
		String sql = "update corporate set corporate_name=?,"
				+ "corporate_legal_person=?,corporate_phone=?,corporate_scope=?,"
				+ "corporate_time=?,corporate_address=?,corporate_textarea=? where corporate_id=?";
		Object[] o={corporate.getCorporate_name(),corporate.getCorporate_legal_person(),
				corporate.getCorporate_phone(),corporate.getCorporate_scope(),corporate.getCorporate_time(),
				corporate.getCorporate_address(),corporate.getCorporate_textarea(),
				corporate.getCorporate_id()};
		return jdbcTemplate.update(sql,o);
	}
	/*
	 * 前台用户更新企业logo
	 * 参数：企业的实体类corporate
	 * 返回类型：返回数据库更新的影响行数（int）
	 */
	@Override
	public int updCorporateLogo(Corporate corporate) {
		String sql = "update corporate set CORPORATE_LOGO_PATH=?,"
				+ "CORPORATE_LOGO_NAME=? where corporate_id=?";
		return jdbcTemplate.update(sql,new Object[]{corporate.getCorporate_logo_path(),corporate.getCorporate_logo_name(),corporate.getCorporate_id()});
	}
	/*
	 * 前台用户修改企业信息检测企业名称是否重复
	 * 参数： 要查询的企业名称(name)
	 * 返回类型：该名在数据库中的数量  int
	 */
	@Override
	public int selCorporateReapeat(String name) {
		String sql="SELECT COUNT(*) FROM CORPORATE  WHERE CORPORATE_NAME=?";
		return jdbcTemplate.queryForObject(sql,Integer.class,name);
	}
	/*
	 * 根据企业id查询企业名称
	 * 参数： 要查询的企业id(id)
	 * 返回类型：企业名称  String
	 */
	@Override
	public String selCorporateNameById(String id) {
		String sql="SELECT CORPORATE_NAME FROM CORPORATE  WHERE CORPORATE_ID=?";
		
		return jdbcTemplate.queryForObject(sql,String.class,id);
	}
	
	/*
	 * 查询某企业信息
	 * 参数： 要查询的企业id(id)
	 * 返回类型：某企业的实体类对象  Corporate
	 */
	@Override
	public Corporate selCorporateInfo(String usename) {
		String sql="SELECT SCOPE_NAME,BASE_NAME,A.* FROM CORPORATE A,SCOPE,BASE WHERE "
				+ "A.CORPORATE_BASE=BASE_ID AND A.CORPORATE_SCOPE=SCOPE_ID AND CORPORATE_USERNAME=?";	
		return jdbcTemplate.queryForObject(sql,new Object[]{usename},new BeanPropertyRowMapper<Corporate>(Corporate.class));
	}
	/*
	 * 前台用户修改企业账户密码
	 * 参数：企业实体类(corporate)
	 * 返回类型：修改影响行数  int
	 */
	@Override
	public int updCorporatePassword(Corporate corporate) {
		String sql = "update corporate set CORPORATE_PASSWORD=? where CORPORATE_USERNAME=?";	
		return jdbcTemplate.update(sql,new Object[]{corporate.getCorporate_password(),corporate.getCorporate_username()});
	}
	/*
	 * 查询用户的密码
	 * 参数：用户名username
	 * 返回类型：返回查询到的密码（String）
	 */
	@Override
	public String selCorporatePassword(String username) {
		String sql = "select corporate_password from CORPORATE where CORPORATE_USERNAME=?";	
		return jdbcTemplate.queryForObject(sql,String.class,username);
	}
	/*
	 * 查询符合筛选条件企业数量
	 * 参数： 筛选条件实体类(search)
	 * 返回类型：符合筛选条件企业数量  int
	 */
	@Override
	public int selCorporateTotalSize(Search search) {
		String scope=search.getScope();
		String city=search.getCity();
		StringBuilder sql=new StringBuilder("SELECT COUNT(*) FROM"
				+ " CORPORATE,BASE WHERE CORPORATE_BASE=BASE_ID AND CORPORATE_STATE=1");
		if(scope!=null){
			sql.append("AND CORPORATE_SCOPE='"+scope+"'");
		}
		if(city!=null){
			sql.append("AND BASE_CITY='"+city+"'");
		}
		return jdbcTemplate.queryForObject(sql.toString(),Integer.class);
	}
	/*
	 * 浏览企业访问量+1
	 * 参数： 企业ID(id)
	 * 返回类型：语句影响数据库记录数量  int
	 */
	@Override
	public int updCorporateClick(String id) {
		String sql="UPDATE CORPORATE SET CORPORATE_CLICK=CORPORATE_CLICK+1 WHERE CORPORATE_ID=?";
		return jdbcTemplate.update(sql, id);
	}
	/*
	 * 查询企业id
	 * 参数： 企业账户(username)
	 * 返回类型：企业id String
	 */
	@Override
	public String selCorporateIdByUsername(String username) {
		// TODO Auto-generated method stub
		String sql="select corporate_id from corporate where corporate_username=?";
		return jdbcTemplate.queryForObject(sql, String.class,username);
	}

	
	/*李治鑫*/
	/*
	 * 查询骨干企业
	 * 参数：基地中的企业(corporate_base)
	 * 返回类型：骨干企业集合 List<Corporate>
	 */
	@Override
	public List<Corporate> selectGG(String corporate_base) {
		// TODO Auto-generated method stub
		System.out.println(corporate_base);
		String sql = "SELECT * FROM (SELECT A.*,ROWNUM R FROM (SELECT CORPORATE_ID,CORPORATE_NAME,CORPORATE_LOGO_PATH,CORPORATE_LOGO_NAME FROM CORPORATE WHERE CORPORATE_BASE=? ORDER BY CORPORATE_CLICK DESC)A) WHERE R<=8";
		List<Corporate> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Corporate>(Corporate.class),new Object[]{corporate_base});
		return list;
	}
	
	
	/*贺丽萍*/
	/*
	 * 企业登录，根据用户名，密码，状态查对象
	 * 参数：企业用户名 corporate_username，企业用户登录密码 corporate_password
	 * 返回类型：返回相应企业用户信息corp
	 * 
	 */
	
	public int select(String corporate_username, String corporate_password) {
		
		String sql="SELECT count(*) FROM CORPORATE WHERE CORPORATE_USERNAME='"+corporate_username+"' AND CORPORATE_PASSWORD='"+corporate_password+"' AND CORPORATE_STATE='1'";
		int i=jdbcTemplate.queryForObject(sql,Integer.class);
		return i;
		
	}
	
	
	/*葛文涛*/
	/*
	 * 方法名：Corporate_Username_Repeat
	 * 作用：注册时验证用户名是否相同
	 * 参数：corporatevo:基地企业实体类对象，用于获取符合查询条件的个数
	 * 返回类型：int
	 */
	public int Corporate_Username_Repeat(Corporate corporatevo) {
		String sql = "select count(*) from corporate where corporate_username=?";
		int i=jdbcTemplate.queryForObject(sql, new Object[]{corporatevo.getCorporate_username()}, Integer.class);
		return i;

	}
	
	/*
	 * 方法名：Corporate_Name_Repeat
	 * 作用：注册时验证企业名称是否相同
	 * 参数：corporatevo:基地企业实体类对象，用于获取符合查询条件的个数
	 * 返回类型：int
	 */
	public int Corporate_Name_Repeat(Corporate corporatevo) {
		String sql = "select count(*) from corporate where corporate_name=?";
		 int i=jdbcTemplate.queryForObject(sql, new Object[]{corporatevo.getCorporate_name()},Integer.class);
		 return i;
	}
	/*
	 * 方法名：index_Reg
	 * 作用：前台注册
	 * 参数：corporatevo:基地企业实体类对象，用于获取基地企业实体表中的所有属性值
	 * 返回类型：int
	 */
	public int index_Reg(Corporate corporateVo) {
		String sql = "insert into corporate (corporate_id,corporate_username,corporate_password,corporate_name,corporate_legal_person,corporate_scope,corporate_base,corporate_time,"
				+ "corporate_phone,corporate_logo_path,corporate_logo_name,corporate_textarea,corporate_apply_time,corporate_address) values"
				+ "(SYS_GUID(),?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int i=jdbcTemplate.update(sql,
				corporateVo.getCorporate_username(),
				corporateVo.getCorporate_password(),
				corporateVo.getCorporate_name(),
				corporateVo.getCorporate_legal_person(),
				corporateVo.getCorporate_scope(),
				corporateVo.getCorporate_base(),
				new Timestamp(corporateVo.getCorporate_time().getTime()),
				corporateVo.getCorporate_phone(),
				corporateVo.getCorporate_logo_path(),
				corporateVo.getCorporate_logo_name(),
				corporateVo.getCorporate_textarea(),
				new Timestamp(new Date().getTime()),
				corporateVo.getCorporate_address());
		return i;

	}

	



	

	
}
