package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.model.ViewDTO;
import com.callor.score.service.RentService;

@Service
public class RentServiceImplV1 implements RentService{
	
	private final JdbcTemplate jdbcTemplate;
	public RentServiceImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<ViewDTO> StudentScoreList() {
		// TODO 성적 리스트 보여주기
		String sql = " SELECT * FROM view_성적일람표 ";
		List<ViewDTO> vList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ViewDTO>(ViewDTO.class));
		System.out.println(vList.get(0).toString());
		return vList;
	}

}
