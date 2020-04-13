package com.dhee.six.index.cities.service;
/**
 * 前台城市service接口实现类
 * 作者：尹希栋
 * 完成时间：2019/09/06
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.index.cities.dao.CitiesDao;
import com.dhee.six.vo.Cities;
@Service
public class CitiesServiceImpl implements CitiesService{
	@Autowired
	private CitiesDao citiesDao;
	
	/*
	 * 查询所有城市
	 * 参数： 无
	 * 返回类型：所有城市集合 List<Cities>
	 */
	@Override
	public List<Cities> selAll() {
		// TODO Auto-generated method stub
		return citiesDao.selAll();
	}

}
