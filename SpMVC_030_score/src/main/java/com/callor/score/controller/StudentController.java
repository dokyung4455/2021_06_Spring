package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StudentController {
	
	protected final StudentService stService;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String basic(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		
		model.addAttribute("STLIST",stList);
		model.addAttribute("BODY","STUDENT_LIST");
		
		return "home";
	}
	
	@RequestMapping(value="/student/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY","STUDENT_INPUT");
		
		return "home";
	}
	
	@RequestMapping(value="/student/insert", method=RequestMethod.POST)
	public String insertPost(StudentVO studentVO, Model model) {
		
		
		return "redirect:/";
	}

}
