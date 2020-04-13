package com.dhee.six.index.qa.service;
/**
 * 前台密保service
 * 作者：尹希栋
 * 完成时间：2019/09/05
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhee.six.index.corporate.dao.CorporateDao;
import com.dhee.six.index.qa.dao.QaDao;
import com.dhee.six.index.question.dao.QuestionDao;
import com.dhee.six.vo.Qa;
import com.dhee.six.vo.Question;

@Service
public class QaServiceImpl implements QaService{
	@Autowired
	private QaDao qaDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private CorporateDao corporateDao;
	/*
	 * 重置用户密保
	 * 参数： 密保对象qa
	 * 返回类型：数据库插入影响行数（int）
	 */
	@Override
	public int updProtection(List<Qa> list) {
		// TODO Auto-generated method stub
		return qaDao.updProtection(list);
	}
	/*
	 * 查询密保
	 * 参数： 当前登录企业的session
	 * 返回类型：当前用户的密保，及所有的密保问题Map<String,Object>
	 */
	@Override
	public Map<String,Object> selProtection(String name) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("qa",qaDao.selProtection(name));
		map.put("list",questionDao.selAll());
		return map;
	}
	/*
	 * 增加密保
	 * 参数： 密保集合list
	 * 返回类型：数据库插入影响行数（int）
	 */
	@Override
	public int addProtection(List<Qa> list) {
		// TODO Auto-generated method stub
		String id=corporateDao.selCorporateIdByUsername(list.get(0).getId());
		for(int i=0;i<list.size();i++){
			list.get(i).setUser_id(id);;
		}
		return qaDao.addProtection(list);
	}
	/*
	 * 查询所有密保问题
	 * 参数： 无
	 * 返回类型：所有密保问题集合（List<Question>）
	 */
	@Override
	public List<Question> selQuestion() {
		// TODO Auto-generated method stub
		return questionDao.selAll();
	}
	
	
	//贺丽萍
	/*
	 * 查询是否存在该用户
	 * 参数： 用户名user_id
	 * 返回类型:是否存在(1：存在，0：不存在)  int
	 */
	@Override
	public int selectById(String user_id) {
		int i=qaDao.selectById(user_id);
		return i;
	}
	/*
	 * 查询该用户是否设置密保问题
	 * 参数： 用户id name
	 * 返回类型:是否设置(1：设置，0：无)  int
	 */
	@Override
	public int selectHavaProtection(String name) {
		// TODO Auto-generated method stub
		int i=qaDao.selectHavaProtection(name);
		return i;
	}
	/*
	 * 查询密保问题
	 * 参数： 用户名 name
	 * 返回类型: 用户密保问题的集合 List<Qa>
	 */
	@Override
	public List<Qa> selectProtection(String name) {
		// TODO Auto-generated method stub
		return qaDao.selectProtection(name);
	}
	/*
	 * 查询密保答案是否正确
	 * 参数： 用户名 name，用户id和用户输入答案的集合 List<Qa>
	 * 返回类型:用户密码
	 */
	@Override
	public String checkProtection(List<Qa> list,String name) {
		// TODO Auto-generated method stub
		if(qaDao.checkProtection(list)==1){
			return qaDao.selPassword(name);
		}
		return "no";
	}

}
