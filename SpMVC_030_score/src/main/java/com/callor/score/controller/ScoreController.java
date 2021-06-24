

package com.callor.score.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ScoreController {

	protected final StudentService stService;
	protected final ScoreService sService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String score( Model model) {
		List<ScoreDTO> sList = sService.selectAll();
		model.addAttribute("LIST",sList);
		model.addAttribute("BODY","SCORE_VIEW");
		
		return "home";
	}
}
