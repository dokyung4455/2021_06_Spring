package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("bookDao")
public class BookDaoImplV1 implements BookDao {
	
	protected final JdbcTemplate JdbcTemplate;
	public BookDaoImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.JdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_books ";
		
		List<BookVO> books = JdbcTemplate.query(sql, new BeanPropertyRowMapper<BookVO>(BookVO.class));
		
		log.debug("SELECT {}",books.toString());
		return null;
	}

	@Override
	public BookVO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
