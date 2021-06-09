package com.callor.jdbc.pesistance;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompanyVO;

import lombok.extern.slf4j.Slf4j;

/*
 * @Component
 * 모든 Component를 대표하는 Annotation
 * 컴파일 과정에서 다소 비용이 많이 소요된다.
 * 
 * @Controller, @Service, @Repository 이러한 Annotation을 사용한다.
 * Spring Container에게 이 표식이 부착된 클래스를 bean으로 생성하여 보관해 달라. 라는 지시어
 * 
 * CompService cs1 = new CompServiceImplV1();
 */
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
	/*
	 * jdbcTemplate을 사용하여 QUERY를 실행할때
	 * 각 method에 매개변수를 받아 QUERY에 전달할텐데
	 * 이때 매개변수는 primitive로 받으면 값을 변화시키는 어려움이 있다.
	 * 권장사항 으로는 매개변수는 wrapper class type으로 설정
	 * 즉 숫자형일 경우 int, long 대신 Integer, Long형으로 선언
	 * 
	 * vo에 담겨서 전달된 값을 Object[] 배열로 변환한 후
	 * jdbcTemplate에 전달해 주어야 한다.
	 * 
	 * 하지만, 1 ~ 2개 정도의 값을 전달할때 Object[] 배열로 변환 후
	 * 전달을 하면 Object 객체 저장소가 생성되고 메모르릴 사용한다.
	 * 이때 전달되는 변수가 wrapper class type이면 Object[] 배열로 만들지 않고
	 * 바로 주입 할 수 있다.
	 */
	@Override
	public int delete(String cpcode) {
		// TODO 출판사 정보 삭제
		String sql = " DELETE FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		// cpcode가 String wrapper class type 이므로
		// Object[] 배열로 볁환하지 않고 바로 전달이 가능하
		// Object[] params = new Object[] { cpcode };
		jdbctemplate.update(sql,cpcode);
		
		
		return jdbctemplate.update(sql,cpcode);
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
	// tbl_company table에서 cpcode(출판사코드) 중 가장 큰 값을 추출하기
	@Override
	public String findByMaxCode() {
		String sql = " SELECT MAX(cp_code) FROM tbl_company ";
		String cpCode = (String) jdbctemplate.queryForObject(sql, String.class);
		return null;
	}
	
	

}
