package com.dhee.six.manager.corporate.service;

import java.util.List;
import java.util.Map;

import com.dhee.six.vo.Corporate;

/**
 * 后台企业server层接口
 * 作者：葛文涛，贺丽萍
 * 完成时间：2019/09/04
 */
public interface M_CorporateService {

	/*葛文涛*/
	// 显示基地企业
	public Map<String,Object> manager_Select_Company(Integer page);
	// 删除企业
	public int manager_Delete_Company(Corporate corporateVo);
	
	// 后台编辑前查询目标基地企业
	public Corporate manager_SelectTarget_Company(Corporate corporateVo);
	
	// 后台编辑基地企业时验证修改后企业名称是否冲突
	public int Manager_Update_Company_Name_Repeat(String str, Corporate corporateVo);
	
	// 后台编辑账户 密码时的账号密码查询Select
	public Corporate manager_Update_Select_Username(Corporate corporateVo);
	
	// 后台编辑基地企业时验用户名是否冲突
	public int Company_Username_Repeat(Corporate corporatevo);
	
	// 后台更改企业logo
	public int Company_Update_company_Logo(Corporate corporateVo);
	
	// 编辑基地企业
	public int manager_Update_Company(Corporate corporateVo);
	
	// 后台编辑账户 密码
	public int manager_Update_Company_Username_password(Corporate corporateVo);
	
	// 添加基地企业
	public int manager_Insert_Company(Corporate corporateVo);
	

	
	/*贺丽萍*/
	//根据企业状态CORPORATE_STATE查询待审核企业
	public int selectCorporatenoAmount();
	//后台company_new 根据企业状态CORPORATE_STATE查询待审核企业
	public List<Corporate> selectByCorporateno();
	//后台company_SH 根据企业ID(CORPORATE_ID)查询企业信息
	public Corporate selectByCorporateId(String corporate_id);	
	//后台company_SH 修改企业状态(审核通过/撤销)
	public int update(String corporate_id,int state);
	
}
