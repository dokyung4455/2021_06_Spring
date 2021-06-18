package com.callor.score.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StuController {
	
		
	@RequestMapping(value="/stuinfo", method = RequestMethod.GET)
	public String stuInfo(HttpSession hSession) {
		
		
		
		
		return "/stuinfo";
	}
	
	@RequestMapping(value="/student/score", method = RequestMethod.GET)
	public String score(String st_num) {
		
		return null;
	}

}
