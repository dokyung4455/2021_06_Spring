package com.team.weather;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.weather.dao.MemberDao;
import com.team.weather.model.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
	
	protected final MemberDao mDao;
	

	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinGet(Model model) {
		
		return "/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(MemberVO memVO,Model model) {
		
		try {
			mDao.insert(memVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "/join";
		}
		
		return "redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/idcheck/{id}",method=RequestMethod.GET)
	public String idcheck(@PathVariable("id")  String id) {
		
		// selectAll 하기
		MemberVO memVO = mDao.findById(id);
		if(memVO == null) {
			return "0";
		} else {
			return "1";
		}
	}
	
	
}
