package com.team.weather;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.weather.dao.MemberDao;
import com.team.weather.model.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	protected final MemberDao mDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(name = "MSG",required = false) String msg, Model model) {
		if(msg == null) {
			model.addAttribute("MSG","NONE");
		} else if(msg.equals("LOGIN")) {
			model.addAttribute("MSG","권한없음");
		} else if(msg.equals(model)) {
			model.addAttribute("LOGIN_FAIL");
		}
		return "home";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String loginPost(String us_id, String us_pw,HttpSession hSession,Model model) {
		log.debug("id : {}", us_id);
		log.debug("pw : {}", us_pw);
		MemberVO memVO = mDao.login(us_id, us_pw);
		
		if(memVO == null ) {
			model.addAttribute("MSG","LOGIN_FAIL");
			return "redirect:/login";
		}
		//log.debug("확인 : {}" + memVO.toString());
		hSession.setAttribute("MEMVO", memVO);
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession hSession) {
		hSession.removeAttribute("MEMVO");
		hSession = null;
		
		return "home";
	}
	
}
