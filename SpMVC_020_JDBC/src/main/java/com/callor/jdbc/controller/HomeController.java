package com.callor.jdbc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.service.RentService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	// protected BookDao bookDao;
	
	// String.properties 파일에 설정된 속성값 가져와서 변수에 setting
	@Value("${user.name}")
	protected String user_name;
	
	@Value("${user.name}")
	protected String user_email;
	
	
	protected RentService rentSerivce;
	
	public HomeController(RentService rentService) {
		// TODO Auto-generated constructor stub
		this.rentSerivce = rentService;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		log.debug("User Name : {}", user_name);
		log.debug("User email : {}", user_email);
		
		
		rentSerivce.viewBookAndComp();
		return "home";
	}
	
}
