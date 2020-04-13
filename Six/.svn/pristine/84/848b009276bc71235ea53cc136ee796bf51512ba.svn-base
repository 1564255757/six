package com.dhee.six.manager.base.controller;
/**
 * 后台基地controller
 * 作者：尹希栋
 * 完成时间：2019/09/05
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhee.six.manager.base.service.M_BaseService;
import com.dhee.six.vo.Base;
import com.dhee.six.vo.Cities;

@Controller
@RequestMapping("manager/base")
public class M_BaseController {
	@Autowired
	private M_BaseService m_BaseService;
	/*
	 * 查询某页所有基地
	 * 参数： 页码page
	 * 返回类型：符合条件的企业集合，及总页码Map<String,Object>
	 */
	@RequestMapping("selAllBase")
	@ResponseBody
	public Map<String,Object> selAllBase(Integer page){
		return m_BaseService.selBase(page);
	}
	/*
	 * 查询某基地信息
	 * 参数： 基地id
	 * 返回类型：基地对象，子公司集合，没有基地公司集合，所有城市集合Map<String,Object>
	 */
	@RequestMapping("selBaseInfo")
	@ResponseBody
	public Map<String,Object> selBaseInfo(String id){
		return m_BaseService.selBaseInfo(id);
	}
	/*
	 * 更新基地信息
	 * 参数： 基地实体类base
	 * 返回类型：数据库插入影响行数int
	 */
	@RequestMapping("updBaseInfo")
	@ResponseBody
	public int updBaseInfo(Base base){
		return m_BaseService.updBase(base);
	}
	/*
	 * 检测基地名是否存在
	 * 参数： 基地实体类base
	 * 返回类型：1：不存在 0：存在（int）
	 */
	@RequestMapping("checkBaseName")
	@ResponseBody
	public int checkBaseName(Base base){
		return m_BaseService.checkBaseName(base);
	}
	/*
	 * 删除基地下的子企业
	 * 参数： 企业id数组  id[]
	 * 返回类型：数据库删除影响行数int
	 */
	@RequestMapping("delBaseSon")
	@ResponseBody
	public int delBaseSon(@RequestParam("id[]") String[] id){
		return m_BaseService.delSon(id);
	}
	/*
	 * 增加基地的企业
	 * 参数： 企业id数组  （id[]） 基地id （base_id）
	 * 返回类型：数据库删除影响行数int
	 */
	@RequestMapping("addBaseSon")
	@ResponseBody
	public int addBaseSon(@RequestParam("id[]") String[] id,String base_id){
		return m_BaseService.addSon(id, base_id);
	}
	/*
	 * 增加基地
	 * 参数：  基地实体类（base）
	 * 返回类型：数据库插入影响行数int
	 */
	@RequestMapping("addBase")
	@ResponseBody
	public int addBase(Base base){
		return m_BaseService.insBase(base);
	}
	/*
	 * 检测增加基地名是否存在
	 * 参数： 基地名base_name
	 * 返回类型：1：不存在 0：存在（int）
	 */
	@RequestMapping("checkAddBaseName")
	@ResponseBody
	public int checkAddBaseName(String base_name){
		return m_BaseService.checkAddBaseName(base_name);
	}
	/*
	 * 查询所有城市
	 * 参数： 基地名base_name
	 * 返回类型：所有城市集合List<Cities>
	 */
	@RequestMapping("selAllCity")
	@ResponseBody
	public List<Cities> selAllCity(){
		return m_BaseService.selAllCity();
	}
	/*
	 * 删除基地
	 * 参数： 基地id （id）
	 * 返回类型：数据库删除影响行数int
	 */
	@RequestMapping("delBase")
	@ResponseBody
	public int delBase(String id){
		return m_BaseService.delBase(id);
	}
	
	

}
