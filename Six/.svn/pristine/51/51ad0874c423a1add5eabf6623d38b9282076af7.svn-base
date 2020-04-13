package com.dhee.six.manager.base.service;
/**
 * 后台基地service实现类
 * 作者：尹希栋,葛文涛
 * 完成时间：2019/09/05
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhee.six.index.cities.dao.CitiesDao;
import com.dhee.six.manager.base.dao.M_BaseDao;
import com.dhee.six.manager.corporate.dao.M_CorporateDao;
import com.dhee.six.vo.Base;
import com.dhee.six.vo.Cities;

@Service
public class M_BaseServiceImpl implements M_BaseService{
	@Autowired
	private M_BaseDao m_BaseDao;
	@Autowired
	private M_CorporateDao m_CorporateDao;
	@Autowired
	private CitiesDao citiesDao;
	@Autowired
	private M_BaseDao baseDao;
	/*
	 * 查询某页所有基地
	 * 参数： 页码start
	 * 返回类型：符合条件的企业集合，及总数量 Map<String,Object>
	 */
	@Override
	public Map<String,Object> selBase(int start) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		Integer i=m_BaseDao.selBaseAmount();
		Integer totalPage=0;
		if(i%12==0){
			totalPage=i/12;
		}else{
			totalPage=i/12+1;
		}
		map.put("size", totalPage);
		start=(start-1)*12+1;
		map.put("list", m_BaseDao.selBase(start));
		return map;
	}
	/*
	 * 增加基地
	 * 参数：  基地实体类（base）
	 * 返回类型：数据库插入影响行数int
	 */
	@Override
	public int insBase(Base base) {
		// TODO Auto-generated method stub
		return m_BaseDao.insBase(base);
	}
	/*
	 * 查询某基地信息
	 * 参数： 基地id
	 * 返回类型：基地对象，子公司集合，没有基地公司集合，所有城市集合Map<String,Object>
	 */
	@Override
	public Map<String,Object> selBaseInfo(String id) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("baseInfo",m_BaseDao.selBaseInfo(id));
		map.put("son",m_CorporateDao.selCorporateByBaseId(id));
		map.put("no",m_CorporateDao.selNoBaseCorporate());
		map.put("city",citiesDao.selAll());
		return map;
	}
	/*
	 * 删除基地
	 * 参数： 基地id （id）
	 * 返回类型：数据库删除影响行数int
	 */
	@Override
	public int delBase(String id) {
		// TODO Auto-generated method stub
		return m_BaseDao.delBase(id);
	}
	/*
	 * 检测基地名是否存在
	 * 参数： 基地实体类base
	 * 返回类型：1：不存在 0：存在（int）
	 */
	@Override
	public int checkBaseName(Base base) {
		int flag=0;
		if(m_BaseDao.selBaseNameById(base.getBase_id()).equals(base.getBase_name())){
			flag=1;
		}else if(m_BaseDao.selBaseNameReapeat(base.getBase_name())!=1){
			flag=1;
		}
		return flag;
	}
	/*
	 * 更新基地信息
	 * 参数： 基地实体类base
	 * 返回类型：数据库插入影响行数int
	 */
	@Override
	public int updBase(Base base){
		return m_BaseDao.updBase(base);
	}
	/*
	 * 删除基地下的子企业
	 * 参数：企业id数组  id[]
	 * 返回类型：数据库删除影响行数int
	 */
	@Override
	public int delSon(String[] id) {
		// TODO Auto-generated method stub
		return m_CorporateDao.delCorporateFromBase(id);
	}
	/*
	 * 增加基地的企业
	 * 参数： 企业id数组  （id[]），基地id （base_id）
	 * 返回类型：数据库删除影响行数int
	 */
	@Override
	public int addSon(String[] id,String base_id) {
		// TODO Auto-generated method stub
		return m_CorporateDao.addCorporateToBase(id, base_id);
	}
	/*
	 * 检测增加基地名是否存在
	 * 参数： 基地名base_name
	 * 返回类型：1：不存在 0：存在（int）
	 */
	@Override
	public int checkAddBaseName(String base_name){
		// TODO Auto-generated method stub
		return m_BaseDao.selBaseNameReapeat(base_name);
	}
	/*
	 * 查询所有城市
	 * 参数： 基地名base_name
	 * 返回类型：所有城市集合List<Cities>
	 */
	@Override
	public List<Cities> selAllCity() {
		// TODO Auto-generated method stub
		return citiesDao.selAll();
	}
	
	
	/*葛文涛*/
	
	/*
	 * 作用：前台注册时城市与基地的连接交互
	 * 参数：citiesVo:城市实体类对象，用于获取city_id
	 * 返回类型：城市id对应的基地list
	 */
	public List<Base> Cities_Base(Cities citiesVo) {
		 List<Base> list=baseDao.Cities_Base(citiesVo);
		return list;
	}
	
}
