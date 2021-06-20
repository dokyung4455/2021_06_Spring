package com.callor.score.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ViewDTO;
import com.callor.score.service.HomeService;

@Controller
public class HomeController {
	
	protected final HomeService rService;
	public HomeController(HomeService rService) {
		// TODO Auto-generated constructor stub
		this.rService = rService;
		
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<ViewDTO> vList = rService.StudentScoreList();
		
		model.addAttribute("LIST",vList);
		
		return "home";
	}
	
}
