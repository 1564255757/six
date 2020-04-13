package com.dhee.six.index.corporate.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dhee.six.vo.Corporate;
import com.dhee.six.vo.Search;

public interface CorporateService {
	/*尹希栋*/	
	//查询符合条件企业
	public Map<String,Object> selCorporate(Search search);
	public Corporate CorporateInfo(String id);
	//查询某企业信息
	public Map<String,Object> selCorporateInfo(String username);
	//符合筛选条件企业数量 
	public void updCorporateClick(String id);
	//前台用户修改企业信息检测企业名称是否重复
	public int selCorporateNameReapeat(String username,String id);
	//前台用户修改企业信息
	public int updCorporate(Corporate corporate);
	//前台用户修改企业logo
	public int updCorporateLogo(Corporate corporate);
	//前台用户修改企业账户密码
	public int updCorporatePassword(Corporate corporate,String oldPass,HttpSession session);
	
	
	/*李治鑫*/
	//查询骨干企业
	public List<Corporate> selectGG(String corporate_base);
	
	/*葛文涛*/
	// 注册时验证用户名是否相同
	public int Corporate_Username_Repeat(Corporate corporatevo);
	// 注册时验证企业名称是否相同
	public int Corporate_Name_Repeat(Corporate corporatevo);
	// 前台注册
	public int index_Reg(Corporate corporateVo);
	
	/*贺丽萍*/
	public int select(String corporate_username, String corporate_password,HttpSession session) ;
}
