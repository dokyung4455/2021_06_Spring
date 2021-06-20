package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreDTO;

public interface ScoreService {
	
	public void select(String st_num);
	public List<ScoreDTO> findByNum(String st_num);
	public ScoreDTO findByNumAll(String st_num);
	public int insert(ScoreDTO vo);
	public int update(String st_num, String st_subject);
	public int delete();
	
	
}
