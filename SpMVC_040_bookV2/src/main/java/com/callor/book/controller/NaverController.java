package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.NaverMainServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/naver")
@Controller
@RequiredArgsConstructor
public class NaverController {
	
	/*
	*	web client에서 서버로 Request를 할때 어떤 데이터를 보내는 방법
	*
	*	1. queryString
	*	?변수=값 : GET method 방법으로 queryString으로 데이터 보내기
	*	?username=callor&pw=12345
	*
	*	2. request Body에 담아 보내는 방법
	*	<form method=POST><input name="username">
	*
	*	3. url path(Path Variable) 방식
	*	http://localhost:8080/book/naver/korea
	*	http://localhost:8080/book/naver/callor/12345
	* Mapping(value="/naver/{username}/{password}	
	*/
	
	protected final NaverMainServiceImpl nService;
	
//	protected final BookService myBookService;
	
	@RequestMapping(value="/{CAT}")
	public String home(@PathVariable(name="CAT")String cat,@RequestParam(name = "search", required = false, defaultValue = "")String search, Model model) throws MalformedURLException, IOException, ParseException {
		
		log.debug("CAT {}", cat);
		model.addAttribute("CAT", cat);
//		List<BookDTO> myBookList = myBookService.selectAll();
//		model.addAttribute("MY_BOOKS",myBookList);
		nService.NaverGetData(cat, search, model);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public String getJson() throws Exception {
		String cat = "NEWS";
		String search = "COVID";
		String jsonString = nService.NaverGetJsonString(cat, search);
		return jsonString;
	}

}
