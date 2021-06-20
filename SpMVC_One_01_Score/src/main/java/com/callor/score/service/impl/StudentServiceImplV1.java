package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.model.StuDTO;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{
	
	protected final JdbcTemplate jdbcTemplate;
	public StudentServiceImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
		
	}
	@Override
	public void select(String st_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StuDTO findByNum(String st_num) {
		// TODO 학생정보 조회
		String sql = " SELECT * FROM view_학생정보 ";
		sql += " WHERE st_num=? ";
		Object[] params = new Object[] {st_num};
		List<StuDTO> sList = jdbcTemplate.query(sql, params,new BeanPropertyRowMapper<StuDTO>(StuDTO.class));
		StuDTO vo = sList.get(0);
		return vo;
	}

	@Override
	public int insert(StuDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String st_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
