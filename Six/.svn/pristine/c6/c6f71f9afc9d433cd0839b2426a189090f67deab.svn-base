package com.dhee.six.index.corporate.service;
/**
 * 前台企业server层接口实现类
 * 作者：尹希栋、葛文涛、李治鑫、贺丽萍
 * 完成时间：2019/09/04
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.index.corporate.dao.CorporateDao;
import com.dhee.six.index.scope.dao.ScopeDao;
import com.dhee.six.vo.Corporate;
import com.dhee.six.vo.Search;
@Service
public class CorporateServiceImpl implements CorporateService{
	@Autowired
	private CorporateDao corporateDao;
	@Autowired
	private ScopeDao scopeDao;
	//尹希栋
	@Override
	public Corporate CorporateInfo(String id) {
		corporateDao.updCorporateClick(id);
		// TODO Auto-generated method stub
		return corporateDao.CorporateInfo(id);
	}
	@Override
	/*
	 * 查询所有城市
	 * 参数： 筛选条件实体类search
	 * 返回类型：符合条件的企业集合，及总数量 Map<String,Object>
	 */
	public  Map<String,Object> selCorporate(Search search) {
		// TODO Auto-generated method stub
		search.setStart((search.getPage()-1)*12+1);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("list",corporateDao.selCorporate(search));
		map.put("total", corporateDao.selCorporateTotalSize(search));
		return map;
	}
	/*
	 * 查询某企业信息
	 * 参数： 当前登录企业的账户usename
	 * 返回类型：企业信息对象，及所有企业范围集合 Map<String,Object>
	 */
	@Override
	public Map<String,Object> selCorporateInfo(String usename) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("com", corporateDao.selCorporateInfo(usename));
		map.put("scope",scopeDao.selAll());
		return map;
	}

	@Override
	public void updCorporateClick(String id) {
		// TODO Auto-generated method stub
		corporateDao.updCorporateClick(id);	
	}
	/*
	 * 检测当前用户修改的企业名称是否存在
	 * 参数： 修改的企业名称（name），企业id（id）
	 * 返回类型：是否重复（int）1：可以使用  0：已存在
	 */
	@Override
	public int selCorporateNameReapeat(String username,String id) {
		// TODO Auto-generated method stub
		int flag=0;
		if(corporateDao.selCorporateNameById(id).equals(username)){
			flag=1;
		}else if(corporateDao.selCorporateReapeat(username)!=1){
			flag=1;
		}
		return flag;
	}
	/*
	 * 前台用户更新企业信息
	 * 参数： 修改企业的实体类corporate
	 * 返回类型：返回数据库更新的影响行数（int）
	 */
	@Override
	public int updCorporate(Corporate corporate) {
		// TODO Auto-generated method stub
		corporate.setCorporate_phone(corporate.getCorporate_area()+"-"+corporate.getCorporate_number());
		return corporateDao.updCorporate(corporate);
	}

	@Override
	public int updCorporateLogo(Corporate corporate) {
		// TODO Auto-generated method stub
		return corporateDao.updCorporateLogo(corporate);
	}
	/*
	 * 前台用户更新企业密码
	 * 参数：企业的实体类corporate，修改的密码，当前用户session
	 * 返回类型：返回int 1：原密码与输入密码一致，更新成功1：原密码与输入密码不一致，更新失败
	 */
	@Override
	public int updCorporatePassword(Corporate corporate,String oldPass,HttpSession session) {
		// TODO Auto-generated method stub
		int flag=0;
		String pass=corporateDao.selCorporatePassword(corporate.getCorporate_username());
		if(pass.equals(oldPass)){
			flag=1;
			corporateDao.updCorporatePassword(corporate);
			session.removeAttribute("corporate");
		}else{
			flag=0;
		}
		return flag;
	}
	
	//李治鑫
	/*
	 * 查询骨干企业
	 * 参数：基地的id（base_id）
	 * 返回类型：基地骨干企业集合List<Corporate>
	 */
	@Override
	public List<Corporate> selectGG(String corporate_base) {
		// TODO Auto-generated method stub
		List<Corporate> list = corporateDao.selectGG(corporate_base);
		return list;
	}
	
	//葛文涛
	/*
	 * 方法名：Corporate_Username_Repeat
	 * 作用：注册时验证用户名是否相同
	 * 参数：Corporate实体类对象 corporatevo
	 * 返回类型：int
	 */
	public int Corporate_Username_Repeat(Corporate corporatevo) {
		int i=corporateDao.Corporate_Username_Repeat(corporatevo);
		return i;
	}

	/*
	 * 方法名：Corporate_Name_Repeat
	 * 作用：注册时验证企业名称是否相同
	 * 参数：Corporate实体类对象 corporatevo
	 * 返回类型：int
	 */
	public int Corporate_Name_Repeat(Corporate corporatevo) {
		int i=corporateDao.Corporate_Name_Repeat(corporatevo);
		return i;
	}

	/*
	 * 方法名：index_Reg
	 * 作用：前台注册
	 * 参数：Corporate实体类对象 corporatevo、上传的图片file、HttpServletRequest对象request
	 * 返回类型：int
	 */
	public int index_Reg(Corporate corporateVo) {
		int i=corporateDao.index_Reg(corporateVo);
		if(i>0){
			return 1;
		}else{
			return 0;
		}
			
	}
	
	//贺丽萍
	/*
	 * 方法名：select
	 * 作用：前台企业登录
	 * 参数：城市实体类Cities的corporate_username属性、corporate_password属性、请求会话HttpSession的session
	 * 返回类型：int
	 */
	public int select(String corporate_username, String corporate_password,HttpSession session) {
		
		int i=corporateDao.select(corporate_username, corporate_password);
		if(i==1){
			Corporate c=new Corporate();
			c.setCorporate_username(corporate_username);
			session.setAttribute("corporate",c);
		}
		return i;
		
	}


}
