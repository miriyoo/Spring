package com.scmaster.project2.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.scmaster.project2.member.dao.MemberDAO;
import com.scmaster.project2.member.vo.BlogMember;

@Controller
@RequestMapping(value="member") //편의성 및 가독성을 위해 그룹화
@SessionAttributes("member")
public class MemberJoinController {

	private static final Logger logger = LoggerFactory.getLogger(MemberJoinController.class);
	
	@Autowired
	MemberDAO dao;	
	
	@RequestMapping(value="joinForm", method= RequestMethod.GET)
	public String joinForm(Model model){
		logger.info("회원 가입 폼 시작");
		
		BlogMember member = new BlogMember();
		model.addAttribute("member", member);
		
		logger.info("회원 가입 폼 종료");
		return "member/joinForm"; //JSP로 이동
	}
	
	@ResponseBody
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public boolean idCheck(String id){
		
		logger.info("아이디 중복 검사 시작");
		boolean flag = false;
		
		BlogMember member = dao.searchMemberOne(id);
		
		logger.info("아이디 중복 검사 종료");

		if(member != null){
			return flag; 
		}else{
			flag = true;
			return flag;
		}
		//ajax는 비동기식이므로 리턴을 해줘야 한다.
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute("member") BlogMember member, Model model){
		logger.info("회원 가입 시작");
		
		int result = dao.joinMember(member);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "가입 실패");
			logger.info("회원 가입 실패");
			return "member/joinForm";
		}
		logger.info("회원 가입 종료");
		
		return "redirect:joinComplete";
	}
	
	@RequestMapping(value="joinComplete", method=RequestMethod.GET)
	public String joinComplete(SessionStatus session, 
			@ModelAttribute("member") BlogMember member, 
			Model model ){
		
		logger.info("회원 가입 성공 폼 이동 시작");
		
		model.addAttribute("id", member.getId());
		session.setComplete();
		
		logger.info("회원 가입 성공 폼 이동 종료");
		return "member/joinComplete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
