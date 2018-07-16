package com.scmaster.web3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web3.dao.UserDAO;
import com.scmaster.web3.vo.UserVO;

/*
 * 로그인 및 로그아웃에 관련된 컨트롤러
 * **/

@Controller
public class LoginController {
	
	@Autowired
	UserDAO dao;
	
	/*
	 * 로그인 폼 이동 함수
	 * 파라메터 : 없음
	 * 리턴 : 로그인 폼 JSP
	 * **/
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm(){
		return "loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(UserVO user, HttpSession session){
		UserVO vo = dao.selectMemberOne(user.getId());
		
		if (vo == null) {
			//ID가 없는 경우 -> 로그인 폼
			return "redirect:loginForm";
		} else if (!vo.getPassword().equals(user.getPassword())){
			//비밀번호가 틀린경우 -> 로그인 폼
			return "redirect:loginForm";
		} else {
			//정확히 입력한 경우
			// session에는 ID와 이름을 저장 -> 로그인
			session.setAttribute("loginId", vo.getId());
			session.setAttribute("loginName", vo.getName());
			
			return "redirect:/"; //세션에 insert한 것이기 때문에 redirect
		}
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("loginId");
		session.removeAttribute("loginName");
		session.removeAttribute("cartList");
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
