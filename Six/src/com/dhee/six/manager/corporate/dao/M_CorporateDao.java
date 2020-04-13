package com.dhee.six.manager.corporate.dao;

import java.util.List;

import com.dhee.six.vo.Corporate;
/**
 * 后台企业接口
 * 作者：尹希栋，贺丽萍,葛文涛
 * 完成时间：2019/08/15
 */
public interface M_CorporateDao{
	/*尹希栋*/
	//查询某基地旗下的企业
	public List<Corporate> selCorporateByBaseId(String id);
	//查询没有基地的企业
	public List<Corporate> selNoBaseCorporate();
	//移除基地中某些企业
	public int delCorporateFromBase(String[] id);
	//企业增加基地
	public int addCorporateToBase(String[] id,String base_id);
	
	
	/*贺丽萍*/
	//后台company_new 根据企业状态CORPORATE_STATE查询待审核企业
	public List<Corporate> selectByCorporateno();
	//后台company_SH 根据企业ID(CORPORATE_ID)查询企业信息
	public Corporate selectByCorporateId(String corporate_id);	
	//后台company_SH 修改企业状态(审核通过/撤销)
	public int update(String corporate_id,int state);	
	
	/*葛文涛*/
	// 显示基地企业
	public List<Corporate> manager_Select_Company();
	// 删除企业
	public int manager_Delete_Company(Corporate corporateVo);
	// 添加基地企业
	public int manager_Insert_Company(Corporate corporateVo);
	// 查询目标基地企业
	public Corporate manager_SelectTarget_Company(Corporate corporateVo);
	// 查询目标基地企业的企业名称
	public int manager_SelectCorporate_name_Company(String str, Corporate corporateVo);
	// 后台更改企业logo
	public int Company_Update_company_Logo(Corporate corporateVo);
	// 后台编辑基地企业时验用户名是否冲突
	public int Company_Username_Repeat(Corporate corporatevo);
	// 判断修改后的用户名是否冲突
	public int Company_Username_Repeat_Two(Corporate corporatevo);
	// 编辑基地企业
	public int manager_Update_Company(Corporate corporateVo);
	// 后台编辑账户 密码时的账号密码查询Select
	public Corporate manager_Update_Select_Username(Corporate corporate);
	// 后台编辑账户 密码
	public int manager_Update_Company_Username_password(Corporate corporateVo);
	public int Company_Corporate_Repeat(String companyName);

}
