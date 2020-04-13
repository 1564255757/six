package com.dhee.six.index.qa.dao;
/**
 * 前台密保dao接口实现类
 * 作者：尹希栋
 * 完成时间：2019/09/05
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Qa;

@Repository
public class QaDaoImpl  implements QaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	 * 重置用户密保
	 * 参数： 密保集合list
	 * 返回类型：数据库插入影响行数（int）
	 */
	@Override
	public int updProtection(List<Qa> list) {
		String sql = "UPDATE QA SET QUESTION_ID=?,QUESTION_ANSWER=? "
				+ "WHERE ID=?";
		List<Object[]> l=new ArrayList<Object[]>();
		for(Qa a:list){
			l.add(new Object[]{a.getQuestion_id(),a.getQuestion_answer(),a.getId()});
		}
		jdbcTemplate.batchUpdate(sql, l);
		return 1;		
	}
	/*
	 * 查询密保
	 * 参数： 当前登录企业的账户名
	 * 返回类型：当前用户的密保集合List<Qa> 
	 */
	@Override
	public List<Qa> selProtection(String username) {
		String sql = "select a.*,q.question_name question_name  from qa a,question q,corporate c where a.question_id=q.id "
				+ "and a.user_id=c.corporate_id and c.corporate_username=?";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Qa>(Qa.class),username);
	}
	/*
	 * 增加密保
	 * 参数： 企业实体类co，当前登录企业的session
	 * 返回类型：数据库插入影响行数（int）
	 */
	@Override
	public int addProtection(List<Qa> list) {
		String sql = "INSERT INTO QA VALUES(SYS_GUID(),?,?,?)";
		List<Object[]> l=new ArrayList<Object[]>();
		for(Qa a:list){
			l.add(new Object[]{a.getQuestion_id(),a.getQuestion_answer(),a.getUser_id()});
		}
		jdbcTemplate.batchUpdate(sql, l);
		return 1;
	}
	
	
	//贺丽萍
	/*
	 * 查询是否存在该用户
	 * 参数： 用户名user_id
	 * 返回类型:是否存在(1：存在，0：不存在)  int
	 */
	@Override
	public int selectById(String user_id) {
		String sql="select count(*) from corporate where corporate_username=?";
		int i=jdbcTemplate.queryForObject(sql,Integer.class,user_id);
		return i;
	}
	/*
	 * 查询该用户是否设置密保问题
	 * 参数： 用户的id name
	 * 返回类型:是否设置(1：设置，0：无)  int
	 */
	@Override
	public int selectHavaProtection(String name) {
		String sql="select  count(*) from qa,corporate  where qa.user_id=corporate.corporate_id and corporate_username=?";
		int i=jdbcTemplate.queryForObject(sql,Integer.class,name);
		return i;
	}
	/*
	 * 查询该用户密保问题
	 * 参数： 用户名name
	 * 返回类型:用户的密保问题的集合 List<Qa>
	 */
	@Override
	public List<Qa> selectProtection(String name) {
		// TODO Auto-generated method stub
		String sql="select qa.*,question.question_name from qa,corporate,question where qa.user_id=corporate.corporate_id"
				+" and question.id=qa.question_id and corporate_username=?";
		return jdbcTemplate.query(sql,new Object[]{name},new BeanPropertyRowMapper<Qa>(Qa.class));
	}
	/*
	 * 查询该用户密保答案
	 * 参数： 用户id和用户输入答案的集合 List<Qa>
	 * 返回类型:是否存在(1：存在，0：不存在)  int
	 */
	@Override
	public int checkProtection(List<Qa> list) {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(*) FROM QA WHERE ID =? AND question_answer =? AND "
				+ "EXISTS( SELECT * FROM QA WHERE ID =? and question_answer =?)";
		List<String> l=new ArrayList<String>();
		for(Qa q:list){
			l.add(q.getId());
			l.add(q.getQuestion_answer());
		}
		
		return jdbcTemplate.queryForObject(sql,l.toArray(),Integer.class);
	}
	/*
	 * 查询用户密码
	 * 参数：用户名 name
	 * 返回类型:用户密码
	 */
	@Override
	public String selPassword(String name) {
		// TODO Auto-generated method stub
		String sql="select corporate_password from corporate where corporate_username=?";
		
		return jdbcTemplate.queryForObject(sql, String.class,name);
	}

}
