package com.scmaster.project2.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.scmaster.project2.member.dao.MemberDAO;
import com.scmaster.project2.member.vo.BlogMember;

@Controller
@RequestMapping(value="member") //편의성 및 가독성을 위해 그룹화
@SessionAttributes("member")
public class MemberLoginController {

private static final Logger logger = LoggerFactory.getLogger(MemberLoginController.class);
	
	@Autowired
	MemberDAO dao;	
	
	@RequestMapping(value="loginPage", method = RequestMethod.GET)
	public String loginPage(){
		logger.info("로그인 페이지 이동 시작");
		logger.info("로그인 페이지 이동 종료");
		return "member/loginPage";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpSession session, BlogMember member, Model model){
		
		BlogMember vo = dao.searchMemberOne(member.getId());
		System.out.println("로그인" + vo);
		
		if (vo == null) {
			logger.info("로그인 페이지 이동");
			model.addAttribute("errorMsg1", "해당 아이디가 없거나 비밀번호가 틀렸습니다.");
			return "member/loginPage";
			
		} else if (!vo.getPassword().equals(member.getPassword())) {
			logger.info("로그인 페이지 이동");
			model.addAttribute("errorMsg2", "해당 아이디가 없거나 비밀번호가 틀렸습니다.");
			return "member/loginPage";
			
		} else {
			session.setAttribute("loginId", vo.getId());
			session.setAttribute("loginName", vo.getName());
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		logger.info("로그아웃 시작");
		
		session.invalidate();
		
		logger.info("로그아웃 종료");
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
