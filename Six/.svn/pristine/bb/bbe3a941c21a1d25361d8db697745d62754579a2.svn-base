package com.dhee.six.index.scope.controller;
/**
 * 前台经营范围controller
 * 作者：尹希栋
 * 完成时间：2019/09/05
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dhee.six.index.scope.service.ScopeService;
import com.dhee.six.vo.Scope;

@Controller
@RequestMapping("index/scope")
public class ScopeController {
	@Autowired
	private ScopeService scopeService;
	/*
	 * 查询所有经营范围
	 * 参数：无
	 * 返回类型：所有经营范围List<Scope>
	 */
	@RequestMapping("allScope")
	@ResponseBody
	public List<Scope> allScope(){
		
		return scopeService.selAll();
		
	}
	
	
}
