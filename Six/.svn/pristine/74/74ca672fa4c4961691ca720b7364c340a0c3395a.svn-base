package com.dhee.six.manager.corporate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhee.six.manager.corporate.dao.M_CorporateDao;
import com.dhee.six.vo.Corporate;

/**
 * 后台企业server层接口实现类 
 * 作者：葛文涛,贺丽萍
 * 完成时间：2019/09/04
 */
@Service
public class M_CorporateServiceImpl implements M_CorporateService {

	/* 葛文涛 */
	@Autowired
	private M_CorporateDao m_corporateDao;

	/*
	 * 方法名：manager_Select_Company
	 * 作用：后台select所有企业
	 * 参数：Integer类型的page  给出当前页的页数
	 * 返回类型：Map<String, Object>  返回基地企业集合 和当前页数、总页数
	 */
	public Map<String, Object> manager_Select_Company(Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Corporate> list = m_corporateDao.manager_Select_Company();

		int currpage = 1;// 当前页
		int countPage = 0;
		if (page != null) {
			currpage = page;
		}
		if (list.size() % 6 == 0) {
			countPage = list.size() / 6;
		} else {
			countPage = list.size() / 6 + 1;
		}

		int FormIndex = (currpage - 1) * 6;
		if (currpage >= countPage) {
			list = list.subList(FormIndex, list.size());
		} else {
			list = list.subList(FormIndex, FormIndex + 6);
		}
		map.put("currpage", currpage);
		map.put("list", list);
		map.put("countPage", countPage);
		return map;
	}

	/*
	 * 方法名：manager_Delete_Company
	 * 作用：后台删除基地企业
	 * 参数：corporateVo，用于获取企业id
	 * 返回类型：int
	 */
	public int manager_Delete_Company(Corporate corporateVo) {
		int i = 0;
		i = m_corporateDao.manager_Delete_Company(corporateVo);
		// if(i>0){
		// System.out.println("删除成功");
		// return i;
		// }else{
		// System.out.println("删除失败");
		// return 0;
		// }
		return i;

	}

	/*
	 * 方法名：manager_SelectTarget_Company
	 * 作用：后台编辑前查询目标基地企业
	 * 参数：Corporate corporateVo
	 * 返回类型：Corporate类型的对象
	 */
	public Corporate manager_SelectTarget_Company(Corporate corporateVo) {

		return m_corporateDao.manager_SelectTarget_Company(corporateVo);

	}

	/*
	 * 方法名：Manager_Update_Company_Name_Repeat
	 * 作用：
	 * （manager_SelectCorporate_name_Company）：后台编辑基地企业时验证修改后企业名称是否冲突
	 * （Company_Corporate_Repeat）：检查编辑操作前添写基地企业名时基地企业名是否存在
	 * 参数：String companyName（文本框的企业名称）, Corporate corporateVo
	 * 返回类型：int
	 */
	public int Manager_Update_Company_Name_Repeat(String companyName, Corporate corporateVo) {

		int num = 0;
		int i = m_corporateDao.manager_SelectCorporate_name_Company(companyName, corporateVo);
		if (i == 1) {
			// n = companyDaoImpl.manager_Update_Company(corporateVo);
			// System.out.println("企业名称没有修改");
			num = 1;
		} else {
			int m = m_corporateDao.Company_Corporate_Repeat(companyName);
			if (m == 0) {
				// n = companyDaoImpl.manager_Update_Company(corporateVo);
				// System.out.println("要修改的名称在数据库中不存在");
				num = 2;

			} else {
				// System.out.println("要修改的名称在数据库中已存在");
				num = 3;
			}
		}
		return num;

	}

	/*
	 * 方法名：manager_Update_Select_Username
	 * 作用：后台编辑账户 密码时的账号密码查询Select
	 * 参数：Corporate类型的对象corporateVo
	 * 返回类型：Corporate类型的对象
	 */
	public Corporate manager_Update_Select_Username(Corporate corporateVo) {
		return m_corporateDao.manager_Update_Select_Username(corporateVo);

	}

	/*
	 * 方法名： Company_Username_Repeat
	 * 作用：
	 * （Company_Username_Repeat）：后台编辑基地企业时验用户名是否冲突
	 * （Company_Username_Repeat_Two）：判断修改后的用户名是否冲突
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int Company_Username_Repeat(Corporate corporatevo) {
		int num = 0;
		int i = m_corporateDao.Company_Username_Repeat(corporatevo);
		if (i == 1) {
			// n = companyDaoImpl.manager_Update_Company(corporateVo);
			// System.out.println("用户名称没有修改");
			num = 1;
		} else {
			int m = m_corporateDao.Company_Username_Repeat_Two(corporatevo);
			if (m == 0) {
				// n = companyDaoImpl.manager_Update_Company(corporateVo);
				// System.out.println("要修改的名称在数据库中不存在");
				num = 2;

			} else {
				// System.out.println("要修改的名称在数据库中已存在");
				num = 3;
			}
		}
		return num;

	}

	/*
	 * 方法名：Company_Update_company_Logo
	 * 作用：后台更改企业logo
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int Company_Update_company_Logo(Corporate corporateVo) {
		return m_corporateDao.Company_Update_company_Logo(corporateVo);
	}

	/*
	 * 方法名：manager_Update_Company
	 * 作用：编辑基地企业
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int manager_Update_Company(Corporate corporateVo) {
		// System.out.println(corporateVo.getCorporate_name());
		int i = m_corporateDao.manager_Update_Company(corporateVo);
		return i;
	}
	/*
	 * 方法名：manager_Update_Company_Username_password
	 * 作用：后台编辑账户 密码
	 * 参数：corporatevo
	 * 返回类型：int
	 */
	public int manager_Update_Company_Username_password(Corporate corporateVo) {
		int i = m_corporateDao.manager_Update_Company_Username_password(corporateVo);
		return i;
	}

	
	/*
	 * 方法名：manager_Insert_Company
	 * 作用：添加基地企业
	 * 参数：corporateVo
	 * 返回类型：int
	 */
	public int manager_Insert_Company(Corporate corporateVo) {
		int i = m_corporateDao.manager_Insert_Company(corporateVo);
		return i;
	}

	/* 贺丽萍 */
	/*
	 * 后台查看后台待审核企业
	 * 参数： 无
	 * 返回类型：未通过审核的基地的企业的集合 List<Corporate>
	 */
	public List<Corporate> selectByCorporateno() {
		List<Corporate> list = m_corporateDao.selectByCorporateno();
		return list;
	}
	/*
	 * 后台修改待审核企业状态
	 * 参数： 企业id：corporate_id，企业状态值：state
	 * 返回类型：是否修改成功标志(1：成功，0：失败)  int
	 */
	@Override
	public Corporate selectByCorporateId(String corporate_id) {
		if(corporate_id!=null){
			return m_corporateDao.selectByCorporateId(corporate_id);
		}else{
			return null;
		}
	}
	/*
	 * 后台查看待审核企业的具体信息
	 * 参数： 企业id：corporate_id
	 * 返回类型：未通过审核的基地的企业的所有信息Corporate
	 */
	@Override
	public int update(String corporate_id,int state) {
		
		int i=m_corporateDao.update(corporate_id,state);
		return i;
		}
	/*
	 * 后台企业未审核数量
	 * 参数： 无
	 * 返回类型：待审核企业数量int
	 */
	@Override
	public int selectCorporatenoAmount() {
		// TODO Auto-generated method stub
		List<Corporate> list = m_corporateDao.selectByCorporateno();	
		return list.size();
	}

}
