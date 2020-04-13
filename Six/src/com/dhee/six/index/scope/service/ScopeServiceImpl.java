package com.dhee.six.index.scope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.index.scope.dao.ScopeDao;
import com.dhee.six.vo.Scope;
/**
 * 前台经营范围service实现类
 * 作者：尹希栋
 * 完成时间：2019/09/05
 */
@Service
public class ScopeServiceImpl implements ScopeService{
	@Autowired
	private ScopeDao scopeDao;
	@Override
	/*
	 * 查询所有经营范围
	 * 参数：无
	 * 返回类型：所有经营范围List<Scope>
	 */
	public List<Scope> selAll() {
		// TODO Auto-generated method stub
		return scopeDao.selAll();
	}

}
