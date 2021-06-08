package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

public interface AuthorDao extends GenericDao<AuthorVO, String>{
	
	public AuthorVO findByCode(String code);
	public List<AuthorVO> findByName(String name);
	public List<AuthorVO> findByGenre(String genre);

}
