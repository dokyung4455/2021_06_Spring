package com.callor.book.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;
import com.callor.book.service.NaverBookService;
import com.callor.book.service.NaverMovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service(NaverQualifier.NAVER_MAIN_SERVICE_V1)
public class NaverMainServiceImpl {
	
	@Qualifier(NaverQualifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	
	@Qualifier(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
	protected final NaverAbstractService<MovieDTO> nMovieService;
	
	@Qualifier(NaverQualifier.NAVER_NEWS_SERVICE_V1)
	protected final NaverAbstractService<NewsDTO> nNewsService;

	public void NaverGetData(String cat, String search, Model model) throws MalformedURLException, IOException, ParseException {
	if(search != null && !search.equals("")) {
			
			if(cat.equalsIgnoreCase("BOOK")) {
				// 도서검색 서비스
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getJsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS", books);
			} else if(cat.equalsIgnoreCase("NEWS")) {
				// 뉴스검색 서비스
				String queryURL = nNewsService.queryURL(search);
				String jSonString = nNewsService.getJsonString(queryURL);
				List<NewsDTO> news = nNewsService.getNaverList(jSonString);
				model.addAttribute("NEWS_LIST", news);
			} else if(cat.equalsIgnoreCase("MOVIE")) {
				// 영화검색 서비스
				String queryURL = nMovieService.queryURL(search);
				String jSonString = nMovieService.getJsonString(queryURL);
				List<MovieDTO> movies = nMovieService.getNaverList(jSonString);
				model.addAttribute("MOVIES", movies);
			}
		}
	}

	public String NaverGetJsonString(String cat, String search) throws Exception {
		// TODO Auto-generated method stub
		String queryURL = nNewsService.queryURL(search);
		String jsonString = nNewsService.getJsonString(queryURL);
		
		return jsonString;
	}
}
