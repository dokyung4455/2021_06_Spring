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

import com.callor.book.config.NaverQualifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverAbstractService;
import com.callor.book.service.NaverMovieService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
public class NaverMovieServiceImplV1 extends NaverAbstractService<MovieDTO> {

	@Override
	public String queryURL(String search_text) throws UnsupportedEncodingException {
		// TODO 검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 = URLEncoder.encode(search_text, "UTF-8");
		String queryURL = NaverSecret.Nurl.MOVIE;
		queryURL += "?query=%s&display=10";
		queryURL = String.format(queryURL, searchUTF8);
		log.debug("queryURL {} ", queryURL.toString());
		//StringBuilder queryURL = new StringBuilder();

		return queryURL;
	}

	/*
	 * gSon 을 사용하여 jsonString을 List<MovieDTO>로 변환하기
	 * 
	 */
	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		JsonElement jsonElement = JsonParser.parseString(jsonString);
		JsonElement oItems = jsonElement.getAsJsonObject().get("items");
		Gson gson = new Gson();
		TypeToken<List<MovieDTO>> typeToken = new TypeToken<List<MovieDTO>>() {
		};
		List<MovieDTO> movies = gson.fromJson(oItems, typeToken.getType());
		return movies;

		// 내가한것
		/*JSONParser jParser =new JSONParser();
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
		return movieList;*/
	}

}
