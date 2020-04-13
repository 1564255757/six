package com.dhee.six.manager.corporate.dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Corporate;
/**
 * 后台企业接口实现类
 * 作者：尹希栋，贺丽萍
 * 完成时间：2019/08/15
 */
@Repository
public class M_CorporateDaoImpl implements M_CorporateDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*尹希栋*/
	/*
	 * 查询某基地旗下的企业
	 * 参数： 基地的id(id)
	 * 返回类型：某基地旗下的企业的集合 List<Corporate>
	 */
	@Override
	public List<Corporate> selCorporateByBaseId(String id) {
		String sql="SELECT CORPORATE_ID,CORPORATE_NAME FROM CORPORATE WHERE CORPORATE_BASE=? AND CORPORATE_STATE=1";		
		return jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<Corporate>(Corporate.class));
	}
	/*
	 * 查询没有基地的企业
	 * 参数： 无
	 * 返回类型：没有基地的企业的集合 List<Corporate>
	 */
	@Override
	public List<Corporate> selNoBaseCorporate() {
		String sql="SELECT CORPORATE_ID,CORPORATE_NAME FROM CORPORATE WHERE CORPORATE_BASE IS NULL";
		
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Corporate>(Corporate.class));
	}
	/*
	 * 移除基地中某些企业
	 * 参数：要移除企业的id集合（list）
	 * 返回类型：是否移除成功标志(1：成功，0：失败)  int
	 */
	@Override
	public int delCorporateFromBase(String[] id) {
		String sql="UPDATE CORPORATE SET CORPORATE_BASE=NULL WHERE CORPORATE_ID=?";
		List<Object[]> l=new ArrayList<Object[]>();
		for(int i=0;i<id.length;i++){
			l.add(new Object[]{id[i]});
		}
		jdbcTemplate.batchUpdate(sql, l);
		return 1;
	}
	/*
	 * 企业增加基地
	 * 参数：要添加到基地的企业id集合（list）,添加的基地id(id)
	 * 返回类型：是否添加成功标志(1：成功，0：失败)  int
	 */
	@Override
	public int addCorporateToBase(String[] id,String base_id) {
		String sql="UPDATE CORPORATE SET CORPORATE_BASE=? WHERE CORPORATE_ID=?";
		List<Object[]> l=new ArrayList<Object[]>();
		for(int i=0;i<id.length;i++){
			l.add(new Object[]{base_id,id[i]});
		}
		jdbcTemplate.batchUpdate(sql, l);
		return 1;
	}
	
	
	
	 /*贺丽萍*/
	/*
	 * 后台查看后台待审核企业
	 * 参数： 无
	 * 返回类型：未通过审核的基地的企业的集合 List<Corporate>
	 */
	@Override
	public List<Corporate> selectByCorporateno() {
	
		String sql="SELECT CORPORATE_ID,CORPORATE_NAME,CORPORATE_APPLY_TIME FROM CORPORATE WHERE CORPORATE_STATE=0 ORDER BY CORPORATE_APPLY_TIME DESC";
		List<Corporate> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Corporate>(Corporate.class));
		

	
	return list;
}
	
	/*
	 * 后台查看待审核企业的具体信息
	 * 参数： 企业id：corporate_id
	 * 返回类型：未通过审核的基地的企业的所有信息Corporate
	 */
	@Override
	public Corporate selectByCorporateId(String corporate_id) {
		
		String sql="select c.corporate_logo_name,c.corporate_name,c.corporate_legal_person,c.corporate_phone,s.scope_name,b.base_name,c.corporate_time ,c.corporate_textarea from CORPORATE c ,base b ,scope s where c.corporate_base=b.base_id AND c.corporate_scope=s.scope_id and  CORPORATE_ID=?";
		Corporate corp=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Corporate>(Corporate.class), new Object[]{corporate_id});
		return corp;
	}
	
	
	/*
	 * 后台修改待审核企业状态
	 * 参数： 企业id：corporate_id，企业状态值：state
	 * 返回类型：是否修改成功标志(1：成功，0：失败)  int
	 */
	@Override
	public int update(String corporate_id,int state) {
		String sql="UPDATE CORPORATE SET CORPORATE_STATE=? WHERE CORPORATE_ID=?";
		int i=jdbcTemplate.update(sql,state,corporate_id);
		return i;
	}
	
	/*葛文涛*/
	/*
	 * 方法名：manager_Select_Company
	 * 作用：后台select所有企业
	 * 参数：无
	 * 返回类型：List<Corporate>
	 */
	public List<Corporate> manager_Select_Company() {
		
		String sql = "select * from corporate WHERE CORPORATE_STATE=1 order by corporate_apply_time desc ";
		 List<Corporate> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Corporate>(Corporate.class));
		return list;
	}

	/*
	 * 方法名：manager_Delete_Company
	 * 作用：删除基地企业
	 * 参数：corporateVo，用于获取企业id
	 * 返回类型：int
	 */
	public int manager_Delete_Company(Corporate corporateVo) {
		String sql = "delete from corporate where corporate_id=?";
		int i = 0;
		i=jdbcTemplate.update(sql,new  Object[]{corporateVo.getCorporate_id()});
		return i;
	}


	/*
	 * 方法名：manager_Insert_Company
	 * 作用：添加基地企业
	 * 参数：corporateVo
	 * 返回类型：int
	 */
	public int manager_Insert_Company(Corporate corporateVo) {
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
	
	/*
	 * 方法名：manager_SelectTarget_Company
	 * 作用：查询目标基地企业
	 * 参数：Corporate corporateVo
	 * 返回类型：Corporate类型的对象
	 */

	public Corporate manager_SelectTarget_Company(Corporate corporateVo) {
		String sql = "select corporate.*, scope_name ,base_name from corporate ,scope ,base where corporate_scope=scope.scope_id and corporate_base=base.base_id(+) and corporate_id=?";

		return jdbcTemplate.queryForObject(sql,new Object[]{corporateVo.getCorporate_id()},new BeanPropertyRowMapper<Corporate>(Corporate.class));
	}

	
	
	/*
	 * 方法名：manager_SelectCorporate_name_Company
	 * 作用：查询目标基地企业的企业名称
	 * 参数：String str, Corporate corporateVo
	 * 返回类型：int
	 */

	public int  manager_SelectCorporate_name_Company(String companyName, Corporate corporateVo) {
		
		String sql = "select corporate_name from corporate where corporate_id=?";
		Corporate corporateVo1=jdbcTemplate.queryForObject(sql,new Object[]{corporateVo.getCorporate_id()},new BeanPropertyRowMapper<Corporate>(Corporate.class));
		if (companyName.equals(corporateVo1.getCorporate_name())) {
			return 1;
		} else {
			return 0;
		}

	}
	
	/*
	 * 方法名：Company_Corporate_Repeat
	 * 作用：检查编辑操作前添写基地企业名时基地企业名是否存在
	 * 参数：String str
	 * 返回类型：int
	 */
	public int Company_Corporate_Repeat(String companyName) {
		String sql = "select count(*) from corporate where corporate_name='"+companyName+"'";
		int i=jdbcTemplate.queryForObject(sql,Integer.class);
		return i;
	}
	
	/*
	 * 方法名：manager_Update_Company
	 * 作用：编辑基地企业(企业名称改变)
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int manager_Update_Company(Corporate corporateVo) {
		String sql = "update corporate set corporate_name=?,"
				+ "corporate_legal_person=?,corporate_phone=?,corporate_scope=?,"
				+ "corporate_base=?,corporate_time=?,corporate_address=?,corporate_textarea=? where corporate_id=?";
		int i = 0;
		i=jdbcTemplate.update(sql, corporateVo.getCorporate_name(),corporateVo.getCorporate_legal_person(),corporateVo.getCorporate_phone(),
				corporateVo.getCorporate_scope(),corporateVo.getCorporate_base(),corporateVo.getCorporate_time(),corporateVo.getCorporate_address(),corporateVo.getCorporate_textarea(),
				corporateVo.getCorporate_id());
		return i;
	}

	
	/*
	 * 方法名：Company_Update_company_Logo
	 * 作用：后台更改企业logo
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int Company_Update_company_Logo(Corporate corporateVo) {
		String sql = "update corporate set corporate_logo_path=?,corporate_logo_name=? where corporate_id=?";
		int i = 0;
		i=jdbcTemplate.update(sql, corporateVo.getCorporate_logo_path(),corporateVo.getCorporate_logo_name(),corporateVo.getCorporate_id());
		return i;
	}
	
	/*
	 * 方法名：manager_Update_Select_Username_Password
	 * 作用：后台编辑账户 密码时的账号密码查询Select
	 * 参数：无
	 * 返回类型：基地企业信息list
	 */

	public Corporate manager_Update_Select_Username(Corporate corporate) {
	
		String sql = "select corporate_username from corporate where corporate_id=?";
		Corporate corporateVo1=jdbcTemplate.queryForObject(sql,new Object[]{corporate.getCorporate_id()},new BeanPropertyRowMapper<Corporate>(Corporate.class));
		return corporateVo1;
	}
	
	/*
	 * 方法名：Company_Username_Repeat
	 * 作用：后台编辑基地企业时验用户名是否冲突
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int Company_Username_Repeat(Corporate corporatevo) {
		String sql = "select corporate_username from corporate where corporate_id=?";
		Corporate corporateVo1=jdbcTemplate.queryForObject(sql, new Object[]{corporatevo.getCorporate_id()}, new BeanPropertyRowMapper<Corporate>(Corporate.class));
		if ((corporatevo.getCorporate_username()).equals(corporateVo1.getCorporate_username())) {
			return 1;
		} else {
			return 0;
		}
	}
	// 判断修改后的用户名是否冲突
	public int Company_Username_Repeat_Two(Corporate corporatevo) {
		String sql = "select count(*) from corporate where corporate_username='"+corporatevo.getCorporate_username()+"'";
		int i=jdbcTemplate.queryForObject(sql,Integer.class);
		return i;
	}
	
	/*
	 * 方法名：manager_Update_Company_Username_password
	 * 作用：后台编辑账户 密码
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int manager_Update_Company_Username_password(Corporate corporateVo) {
		String sql = "update corporate set corporate_username=?,corporate_password=? where corporate_id=?";
		int i = 0;
		i=jdbcTemplate.update(sql, corporateVo.getCorporate_username(),corporateVo.getCorporate_password(),corporateVo.getCorporate_id());
		return i;
	}

}
