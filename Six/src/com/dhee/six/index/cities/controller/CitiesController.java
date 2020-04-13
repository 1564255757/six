package com.dhee.six.index.cities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhee.six.index.cities.service.CitiesService;
import com.dhee.six.vo.Cities;
/**
 * 前台城市controller
 * @author：尹希栋
 * @since：2019/09/05
 */
@Controller
@RequestMapping("index/cities")
public class CitiesController {
	@Autowired
	private CitiesService citiesService;
	
	/**
	 * 查询所有城市
	 * @param： 无
	 * @return：所有城市集合 List<Cities>
	 */
	@RequestMapping("allCities")
	@ResponseBody
	public List<Cities> allCities(){
		return citiesService.selAll();
		
	}
	
	
}
