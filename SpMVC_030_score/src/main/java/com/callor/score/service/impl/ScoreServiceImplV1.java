package com.callor.score.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("scoreServiceV1")
public class ScoreServiceImplV1 implements ScoreService{

		protected final ScoreDao sDao;
	@Override
	public List<ScoreDTO> selectAll() {
		// TODO Auto-generated method stub
		
		List<ScoreDTO> scoreList = sDao.selectViewAll();
		return scoreList;
	}
	@Override
	public List<SubjectAndScoreDTO> selectScore(String st_num) {
		List<SubjectAndScoreDTO> ssList = sDao.selectSubjectAndScore(st_num);
		
		return ssList;
	}

	
	
}
