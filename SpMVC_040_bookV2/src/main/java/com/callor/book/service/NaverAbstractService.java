package com.callor.book.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.book.config.NaverSecret;

/*
 *  abstract 키워드를 추가함으로써 추상클래스가 된다.
 *  
 *  추상클래스
 *  일반적인 클래스와 인터페이스의 성질을 모두 포함하는 클래스
 *  
 *  목적
 *  1. 상속되는 부모 클래스의 역할, 스스로는 객체로 생성 될 수 없다.
 *  2. 추상method를 포함하는데 상속 받은 곳에서는 반드시 추상 method 를 구현 해야한다.
 *  3. 상속받은 클래스들에 필요한 공통 처리 method는 일반 클래스처럼 자체적으로 구현코드를 가지고 있다.
 *  4. 공통처리 method도 필요에 따라 상속받은 곳에서 재 정의 할 수 있다.
 *  5. 인터페이스의 역할을 수행한다. 여러 클래스의 원형(prototype)역할을 수행하면서 상속받은 클래스들에 공통으로 필요한 코드를 미리 제공한다.
 *  
 *  객체 생성방법
 *  추상클래스 객체 = new 상속받은 클래스();
 *  인터페이스 객체 = new imp클래스();
 *  추상클래스 객체 = new 추상클래스() 는 사용 할 수 없다.
 *  
 */
public abstract class NaverAbstractService<T> {

	public abstract String queryURL(String search) throws UnsupportedEncodingException;

	public abstract List<T> getNaverList(String jsonString) throws ParseException;

	public String getJsonString(String queryURL) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		URL url = new URL(queryURL);

		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);

		int httpStatusCode = httpConn.getResponseCode();

		InputStreamReader is = null;

		if (httpStatusCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			is = new InputStreamReader(httpConn.getInputStream());
		}
		BufferedReader buffer = null;
		buffer = new BufferedReader(is);

		StringBuffer sBuffer = new StringBuffer();

		while (true) {
			String reader = buffer.readLine();
			if (reader == null) {
				break;
			}
			sBuffer.append(reader);
		}
		return sBuffer.toString();
	}

}
