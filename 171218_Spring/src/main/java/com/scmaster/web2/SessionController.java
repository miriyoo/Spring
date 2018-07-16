package com.scmaster.web2;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {

	@RequestMapping(value="sessionPage", method=RequestMethod.GET)
	public String sessionPage(HttpSession session){
		session.setAttribute("id", "아이디"); // 웹 브라우저를 종료하거나 유지시간이 종료될때까지 유지
		return "sessionPage";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		// 세션 값 지우기
		session.removeAttribute("id"); // session.setAttribute 시의 키값을 입력, 하나씩 지움
		// session.invalidate(); // 세션안에 있는 모든 정보를 한번에 다 지워버린다.
		
		return "sessionPage";
	}
	
	@RequestMapping(value= "sessionCheckPage", method= RequestMethod.GET)
	public String sessionCheckPage(){
		return "sessionCheckPage";
	}
	
	@RequestMapping(value= "login", method= RequestMethod.GET)
	public String login(HttpSession session){
		session.setAttribute("id", "id");
		return "home";
	}
		
}
