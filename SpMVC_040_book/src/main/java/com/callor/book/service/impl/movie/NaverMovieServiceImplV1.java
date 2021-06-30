package com.callor.book.service.impl.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverSecret;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverMovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("naverMovieServieV1")
public class NaverMovieServiceImplV1 implements NaverMovieService{

	@Override
	public String queryURL(String search_text) {
		// TODO 검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 = null;
		
		try {
			searchUTF8 = URLEncoder.encode(search_text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String queryURL = NaverSecret.Nurl.MOVIE;
		String queryString = String.format("?query=%s", searchUTF8);
		queryURL += queryString;
		queryString = String.format("&display=%d", 20);
		queryURL += queryString;
		
		log.debug("queryURL {} ", queryURL.toString());
		//StringBuilder queryURL = new StringBuilder();
		
		return queryURL.toString();
	}

	@Override
	public String getJsonString(String queryURL) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		URL url = null;
		
		HttpURLConnection httpConn = null;
		url = new URL(queryURL);
		
		httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		
		int httpStatusCode = httpConn.getResponseCode();
		
		InputStreamReader is = null;
		
		if(httpStatusCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			is = new InputStreamReader(httpConn.getInputStream());
		}
		BufferedReader buffer = null;
		buffer = new BufferedReader(is);
		
		StringBuffer sBuffer = new StringBuffer();
		
		while (true) {
			String reader = buffer.readLine();
			if(reader == null) {
				break;
			}
			sBuffer.append(reader);
		}
		return sBuffer.toString();
	}

	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		JSONParser jParser =new JSONParser();
		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		JSONArray items = (JSONArray) jObject.get("items");
		List<MovieDTO> movieList = new ArrayList<MovieDTO>();
		int nSize = items.size();
		for(int i = 0 ; i < nSize ; i++) {
			JSONObject item = (JSONObject) items.get(i);
			String title = (String) item.get("title");
			String link = (String) item.get("link");
			String image = (String) item.get("image");
			String subtitle = (String) item.get("subtitle");
			String pubDate = (String) item.get("pubDate");
			String director = (String) item.get("director");
			String actor = (String) item.get("actor");
			String userRating = (String) item.get("userRating");
			MovieDTO movieDTO = MovieDTO.builder()
					.title(title)
					.link(link)
					.image(image)
					.subtitle(subtitle)
					.pubDate(pubDate)
					.director(director)
					.actor(actor)
					.userRating(userRating)
					.build();
			
			movieList.add(movieDTO);
					
					
			
		}
		return movieList;
	}

}
