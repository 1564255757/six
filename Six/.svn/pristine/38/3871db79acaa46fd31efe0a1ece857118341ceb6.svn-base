package com.dhee.six.index.qa.dao;
/**
 * 前台密保dao接口
 * 作者：尹希栋
 * 完成时间：2019/09/05
 */
import java.util.List;

import com.dhee.six.vo.Qa;

public interface QaDao {
	/*更新密保*/
	public int updProtection(List<Qa> list);
	/*查询密保*/
	public List<Qa> selProtection(String username);
	/*添加密保*/
	public int addProtection(List<Qa> list);
	
	//贺丽萍
	/*用户是否存在*/
	public int selectById(String user_id);
	/*用户是否设置密保*/
	public int selectHavaProtection(String name);
	/*查询该用户的密保问题*/
	public List<Qa> selectProtection(String name);
	/*密保答案是否正确*/
	public int checkProtection(List<Qa> list);
	/*查询用户密码*/
	public String selPassword(String name);
	
	
	

}
