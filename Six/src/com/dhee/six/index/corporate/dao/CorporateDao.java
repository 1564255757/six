package com.dhee.six.index.corporate.dao;

import java.util.List;

import com.dhee.six.vo.Corporate;
import com.dhee.six.vo.Search;
/**
 * 前台企业接口
 * 作者：尹希栋,李治鑫，贺丽萍
 * 完成时间：2019/08/15
 */
public interface CorporateDao{
	/*尹希栋*/	
	//查询符合条件企业
	public List<Corporate> selCorporate(Search search);
	//查询某企业信息
	public Corporate CorporateInfo(String id);
	//查询某企业信息用户
	public Corporate selCorporateInfo(String usename);
	//符合筛选条件企业数量 
	public int selCorporateTotalSize(Search search);
	//增加企业浏览量
	public int updCorporateClick(String id);
	//前台用户修改企业信息检测企业名称是否重复
	public int selCorporateReapeat(String name);
	//根据企业id查询企业名称
	public String selCorporateNameById(String id);
	//前台用户修改企业信息
	public int updCorporate(Corporate corporate);
	//前台用户修改企业logo
	public int updCorporateLogo(Corporate corporate);
	//前台用户修改企业账户密码
	public int updCorporatePassword(Corporate corporate);
	//查询企业账户密码
	public String selCorporatePassword(String username);
	//查询企业ID
	public String selCorporateIdByUsername(String username);
	
	/*李治鑫*/
	//查询骨干企业
	public List<Corporate> selectGG(String corporate_base);
	
	/*贺丽萍*/
	//前台登录 根据用户名 密码 状态查对象
	public int select(String corporate_username,String corporate_password);
	
	/*葛文涛*/
	// 注册时验证用户名是否相同
	public int Corporate_Username_Repeat(Corporate corporatevo);
	// 注册时验证企业名称是否相同
	public int Corporate_Name_Repeat(Corporate corporatevo);
	// 前台注册
	public int index_Reg(Corporate corporateVo);
}
