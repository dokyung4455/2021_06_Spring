package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.CompanyVO;

public interface CompanyDao extends GenericDao<CompanyVO, String>{
	
	public String findByMaxCode();
	public BookDao findByCode(String code);
	public List<CompanyVO> findByTitle(String title);
	public List<CompanyVO> findByCeo(String ceo);
	public List<CompanyVO> findByGenre(String genre);

}
