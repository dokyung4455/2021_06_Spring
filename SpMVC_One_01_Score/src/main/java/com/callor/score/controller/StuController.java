package com.callor.score.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.StuDTO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

@Controller
public class StuController {
	
		protected final ScoreService sService;
		protected final StudentService stuService;
		public StuController(ScoreService sService, StudentService stuService) {
			// TODO Auto-generated constructor stub
			this.sService = sService;
			this.stuService = stuService;
		}
	@RequestMapping(value="/stuinfo", method = RequestMethod.GET)
	public String stuInfo(HttpSession hSession) {
		
		
		
		
		return "/stuinfo";
	}
	
	@RequestMapping(value="/student/score", method = RequestMethod.GET)
	public String score(String st_num, Model model) {
		StuDTO stDto = stuService.findByNum(st_num);
		List<ScoreDTO> sList = sService.findByNum(st_num);
		ScoreDTO sDto = sService.findByNumAll(st_num);
		model.addAttribute("STU", stDto);
		model.addAttribute("SLIST", sList);
		model.addAttribute("TOTAL", sDto);
		
		return "/student/score";
	}

}
