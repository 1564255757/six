package com.dhee.six.index.base.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dhee.six.index.base.service.BaseService;
import com.dhee.six.vo.Base;
/**
 * 基地Controller类
 * @author 李治鑫
 * @since 2019.09.04
 */
@Controller
@RequestMapping("index/base")
public class BaseController {
@Autowired
private BaseService baseService;
/**
 * 基地查询所有
 * @param：无
 * @return：Map<String,List<Base>>
 * @author：李治鑫
 */

@RequestMapping("selectAll")
@ResponseBody
public  Map<String,List<Base>> selectAll(){
	return baseService.selectAll();
}

/**
 * 查询某个基地
 * @param：base_id
 * @return：Base
 * @author：李治鑫
 */
@RequestMapping("select")
@ResponseBody
public Base select(String base_id){
	return baseService.select(base_id);
}
/**
 * 查询所有基地
 * @param：base_id
 * @return：Base
 * @author：李治鑫
 */
@RequestMapping("Select_Base.do")
@ResponseBody
public List<Base> Select_Base(){
	return baseService.Select_Base();
	
}

}
