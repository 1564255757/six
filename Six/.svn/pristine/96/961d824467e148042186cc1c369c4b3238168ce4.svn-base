package com.dhee.six.manager.base.service;
/**
 * 后台基地service接口
 * 作者：尹希栋，葛文涛
 * 完成时间：2019/09/05
 */
import java.util.List;
import java.util.Map;

import com.dhee.six.vo.Base;
import com.dhee.six.vo.Cities;

public interface M_BaseService {
	/*尹希栋*/
	//分页遍历基地
	public Map<String,Object> selBase(int start);
	//增加基地
	public int insBase(Base base);
	//某基地详细信息
	public Map<String,Object> selBaseInfo(String id);
	//删除某基地
	public int delBase(String id);
	//基地名是否重复
	public int checkBaseName(Base base);
	//增加时基地名是否重复
	public int checkAddBaseName(String base_name);
	//修改基地
	public int updBase(Base base);
	//删除基地下企业
	public int delSon(String[] id);
	//增加基地下企业
	public int addSon(String[] id,String base_id);
	//增加基地下企业
	public List<Cities> selAllCity();
	
	/*葛文涛*/
	// 前台注册时城市与基地的连接交互
	public List<Base> Cities_Base(Cities citiesVo);
}
