package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Service;

import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompanyDao;
import com.callor.jdbc.service.RentService;

@Service("rentV1")
public class RentServiceImplV1 implements RentService {

	
	protected BookDao bookDao;
	protected CompanyDao compDao;
	public RentServiceImplV1(BookDao bookDao, CompanyDao compDao) {
		// TODO Auto-generated constructor stub
		this.bookDao = bookDao;
		this.compDao = compDao;
	}
	
	
	@Override
	public void viewBookAndComp() {
		// TODO Auto-generated method stub
		bookDao.selectAll();
		compDao.selectAll();
		
	}
	

}
