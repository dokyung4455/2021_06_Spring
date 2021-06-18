package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.MemberService;

@Service
public class MemberServiceImplV1 implements MemberService {
	
	@Override
	public int join(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO login(String m_id, String m_pw) {
		// TODO Auto-generated method stub
		if(m_id.equalsIgnoreCase("korea") && m_pw.equals("1234")) {
			UserVO userVO = new UserVO();
			return userVO;
		}
		
		return null;
	}

	@Override
	public UserVO viewInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int expire(String username) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
