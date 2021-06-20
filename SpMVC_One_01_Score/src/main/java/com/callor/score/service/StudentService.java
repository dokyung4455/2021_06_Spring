package com.callor.score.service;

import java.util.List;

import com.callor.score.model.StuDTO;

public interface StudentService {
	
	public void select(String st_num);
	public StuDTO findByNum(String st_num);
	public int insert(StuDTO vo);
	public int update(String st_num);
	public int delete();
	
	
}
