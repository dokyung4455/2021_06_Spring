package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;

@Service
public class ScoreServiceImplV1 implements ScoreService{

	private final JdbcTemplate jdbcTemplate;
	public ScoreServiceImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public void select(String st_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ScoreDTO> findByNum(String st_num) {
		// TODO 과목별 점수 조회
		String sql = " SELECT sc_seq,sc_subject,sc_score FROM tbl_score ";
		sql += " WHERE sc_stnum = ? ";
		
		Object[] params = new Object[] {st_num};
		List<ScoreDTO> sList = jdbcTemplate.query(sql, params,new BeanPropertyRowMapper<ScoreDTO>(ScoreDTO.class));
		return sList;
	}
	@Override
	public ScoreDTO findByNumAll(String st_num) {
		// TODO 총 과목 수 및 총점 조회
		String sql = " SELECT COUNT(sc_subject) AS sc_subject,SUM(sc_score) AS sc_score FROM tbl_score ";
		sql += " WHERE sc_stnum = ? ";
		Object[] params = new Object[] {st_num};
		List<ScoreDTO> sList = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<ScoreDTO>(ScoreDTO.class));
		ScoreDTO dto = sList.get(0);
		
		return dto;
	}

	@Override
	public int insert(ScoreDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String st_num, String st_subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
