package com.dhee.six.manager.base.dao;

import java.util.List;

import com.dhee.six.vo.Base;
import com.dhee.six.vo.Cities;
/**
 * 后台基地接口
 * 作者：尹希栋
 * 完成时间：2019/08/15
 */
public interface M_BaseDao {
	/*尹希栋*/
	//分页遍历基地
	public List<Base> selBase(int start);
	//分页遍历基地
	public int selBaseAmount();
	//增加基地
	public int insBase(Base base);
	//某基地详细信息
	public Base selBaseInfo(String id);
	//删除某基地
	public int delBase(String id);
	//基地名是否重复
	public int selBaseNameReapeat(String basename);
	//根据基地id查询基地name
	public String selBaseNameById(String id);
	//修改基地
	public int updBase(Base base);
	
	
	/*葛文涛*/
	// 前台注册时城市与基地的连接交互
	public List<Base> Cities_Base(Cities citiesVo);

}
