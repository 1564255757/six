package com.dhee.six.index.question.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dhee.six.vo.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Question> selAll() {
		// TODO Auto-generated method stub
		String sql="select * from question";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
	}

}
