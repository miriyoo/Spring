package com.scmaster.project2.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.scmaster.project2.member.dao.MemberDAO;
import com.scmaster.project2.member.vo.BlogMember;

@Controller
@RequestMapping(value="member") //편의성 및 가독성을 위해 그룹화
@SessionAttributes("member")
public class MemberUpdateController {
	
private static final Logger logger = LoggerFactory.getLogger(MemberUpdateController.class);
	
	@Autowired
	MemberDAO dao;	
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(String loginId, Model model){
		
		logger.info("내 정보 수정하기 폼 이동 시작");
		
		BlogMember member = dao.searchMemberOne(loginId);
		model.addAttribute("member", member);
		
		logger.info("내 정보 수정하기 폼 이동 종료");
		
		return "member/updateInfo";
	}
	
	@RequestMapping(value="updateInfo", method=RequestMethod.POST)
	public String updateInfo(@ModelAttribute("member")BlogMember member, Model model){
		logger.info("정보 수정하기 시작");
		
		int result = dao.updateMember(member);
		
		if (result != 1) {
			logger.info("정보 수정하기 실패");
			model.addAttribute("errorMsg", "수정 실패");
			return "member/updateInfo";
		}
		logger.info("정보 수정하기 종료");
		
		return "redirect:updateComplete";
	}
	
	@RequestMapping(value="updateComplete", method=RequestMethod.GET)
	public String updateComplete(SessionStatus status, 
			@ModelAttribute("member")BlogMember member,
			Model model,
			HttpSession session){
		
		logger.info("정보 수정 성공 폼 이동 시작");
		
		session.setAttribute("loginName", member.getName());
		model.addAttribute("id", member.getId());
		
		status.setComplete();
		
		logger.info("정보 수정 성공 폼 이동 종료");
		
		return "member/updateComplete";
	}
	
	
	
	
	
	
	
	
	
	
	
}
