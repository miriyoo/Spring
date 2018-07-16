package com.cooking.www8.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="member")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="joinMember", method = RequestMethod.GET)
	public String loginPage(){
		logger.info("로그인 페이지 이동 시작");
		logger.info("로그인 페이지 이동 종료");
		return "member/joinForm";
	}
}
