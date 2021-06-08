package com.callor.jdbc.pesistance;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompanyVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompanyDao{

	protected final JdbcTemplate jdbctemplate;
	public CompDaoImplV1(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated constructor stub
		this.jdbctemplate = jdbctemplate;
	}
	
	@Override
	public List<CompanyVO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_company ";
		List<CompanyVO> compList = jdbctemplate.query(sql, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		log.debug(" Comp Select {}  ", compList.toString());
		
		
		return compList;
	}

	@Override
	public CompanyVO findById(String pk) {
		String sql = " SELECT * FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		Object[] params = new Object[] { pk };
		
		
		
		CompanyVO vo = (CompanyVO) jdbctemplate.query(sql, params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		
		return vo; 
	}

	@Override
	public int insert(CompanyVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_company ";
		sql += " (cp_code, cp_title, cp_ceo, cp_addr, cp_tel) ";
		sql += " VALUES( ?,?,?,?,? ) ";
		
		Object[] params = new Object[] {vo.getCp_code(),vo.getCp_title(),vo.getCp_ceo(),vo.getCp_addr(),vo.getCp_tel()};
		
		return jdbctemplate.update(sql, params);
	}

	@Override
	public int update(CompanyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookDao findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyVO> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
