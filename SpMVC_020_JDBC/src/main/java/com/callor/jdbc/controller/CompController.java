package com.callor.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.CompanyVO;
import com.callor.jdbc.pesistance.CompanyDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/comp")
public class CompController {
	
	protected final CompanyDao compDao;
	public CompController( CompanyDao compDao) {
		// TODO Auto-generated constructor stub
		this.compDao = compDao;
	}
	
	// localhost:8080/jdbc/comp/insert로 호출되는 method(함수)
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		

		return "comp/input"; // WEB-INF/views/comp/input.jsp 를 열어라
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(CompanyVO cpVO) {
		compDao.insert(cpVO);
		
		log.debug("Company VO {}", cpVO.toString());
		return "redirect:/"; // redirect 작동법, 루트패스로 리다이렉트하라
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update() {
		
		
		
		return "comp/input";
	}

}
