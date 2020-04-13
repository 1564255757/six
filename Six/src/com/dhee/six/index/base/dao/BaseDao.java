package com.dhee.six.index.base.dao;

import java.util.List;
import com.dhee.six.vo.Base;
/**
 * 基地接口
 * @author：李治鑫，葛文涛
 * @since:2019.8.16
 */
public interface BaseDao {
	/*李治鑫*/
	//查詢所有城市的基地
	public List<Base> selectAll();
    //查询基地标题与详情
	public Base select(String base_id);
	
	
	/*葛文涛*/
	// 出口基地下拉框Select
	public List<Base> Select_Base();
	
}
