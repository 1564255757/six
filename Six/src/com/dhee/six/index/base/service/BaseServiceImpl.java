package com.dhee.six.index.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.index.base.dao.BaseDao;
import com.dhee.six.vo.Base;
/**
 * 基地Service实现类
 * @author 李治鑫
 * @since 2019.09.04
 */
@Service
public class BaseServiceImpl implements BaseService{
	@Autowired
	private BaseDao baseDao;
	/**
	 * 查询所有基地
	 * @param：无
	 * @return： Map<String,List<Base>>
	 * @author：李治鑫
	 */
	@Override
	public Map<String,List<Base>> selectAll() {
		// TODO Auto-generated method stub
		List<Base> list=baseDao.selectAll();
		Map<String,List<Base>> map=new HashMap<String,List<Base>> ();
		for(Base b:list){
			if(map.containsKey(b.getCity_name())){
				map.get(b.getCity_name()).add(b);
			}else{
				List<Base> l=new ArrayList<Base>();
				l.add(b);
				map.put(b.getCity_name(),l);
			}
		}
		//System.out.println(map);
		
		return map;
	}
	/**
	 * 查询基地详情
	 * @param：base_id
	 * @return： Base
	 * @author：李治鑫
	 */
	@Override
	public Base select(String base_id) {
		// TODO Auto-generated method stub
		Base base = baseDao.select(base_id);
		return base;
	}
	
	/*葛文涛*/
	/**
	 * 作用：出口基地下拉框Select
	 * @param：无
	 * @return：基地集合 List<Base>
	 */
	public List<Base> Select_Base() {
		return baseDao.Select_Base();
	}

}
