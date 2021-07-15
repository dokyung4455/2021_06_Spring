package com.callor.gallery.service.impl;

import org.springframework.stereotype.Service;

import com.callor.gallery.model.PageDTO;
import com.callor.gallery.service.PageService;

@Service("pageServiceV1")
public class PageServiceImplV1 implements PageService{

	protected int navsPerPage = 5;
	protected int listPerPage = 10;
	
	@Override
	public PageDTO makePagination(int totalListSize, int currentPage) {
		// TODO Auto-generated method stub
		if(totalListSize < 1) return null;
		// 이 연산을 수행하면 전체 리스트를 표현하는데 몇페이지가 필요한가를 계산
		// 이 연산은 int 형 데이터로 연산을 수행하므로 소수점이하를 무조건 자른다.
		// 마지막 페이지 개수가 listPerPage 보다 작으면 마지막 페이즈는 무시하는 totalPage 값이 계산된다.
		// Math.round() : 반올림 
		// Math.floor() : 소수점이하 무조건 버림
		// Math.ceil() : 소수점이하 무조건 올림
		int totalPages= (int)Math.round((double)totalListSize / (double)this.listPerPage);
		
		int startPage = currentPage - (navsPerPage/2);
		
		// 네비 시작페이지를 계산하여 1보다 작으면 무조건 1부터 시작
		startPage = startPage <1 ? 1 : startPage;
		int endPage = startPage + this.navsPerPage;
		// 마지막 페이지가 전체 페이지 수보다 커지면 마지막 페이지로 세팅
		endPage = endPage > totalPages ? totalPages : endPage;
		
		// 데이터를 자르기 위한 변수 생성
		// 몇번 데이터부터 몇개를 자를지 선택하기
		// 전체 데이터가 685개 라고 가정하면
		// 마지막 페이지를 표현하기 위한 offset limit은
		// offset:680
		// limit : 5가 되어야 하는데 아래 연산에서 limit 690이 되어 버린다.
		// 데이터를 자르는 과정에서 exception 이 발생할 것이다.
		int offset = (currentPage - 1) * this.listPerPage;
		int limit = offset + this.listPerPage;
		
		// 마지막 위치 값이 전체 리스트보다 크면
		// 전체 리스트 끝 값으로 세팅하기
		limit = limit > totalListSize ? totalListSize : limit;
		
		// offset : 680, limit : 685가 되도록 만들었다.
		
		PageDTO pageDTO = PageDTO.builder()
				.totalPages(totalPages)
				.startPage(startPage)
				.endPage(endPage)
				.offset(offset)
				.limit(limit)
				.build();
		return pageDTO;
	}

}
