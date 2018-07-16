package com.scmaster.web7.customer.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.scmaster.web7.customer.dao.CustomerDAO;
import com.scmaster.web7.customer.vo.Customer1;

@Controller
@RequestMapping(value="customer")
@SessionAttributes("customer")
public class CustomerLoginController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);
	
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping(value="loginPage", method=RequestMethod.GET)
	public String loginPage(){
		logger.info("로그인 페이지 이동 시작");
		logger.info("로그인 페이지 이동 종료");
		return "customer/loginPage";
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST)
	public String login(Customer1 customer, HttpSession session, Model model){
		Customer1 vo = dao.searchCustomerOne(customer.getCustid());
		
		if (vo == null) {
			logger.info("로그인 페이지 이동 시작");
			model.addAttribute("errorMsg1", "해당하는 ID가 없거나 잘못된 비밀번호를 입력하셨습니다");
			return "customer/loginPage";
			
		} else if (!customer.getPassword().equals(vo.getPassword())) {
			logger.info("로그인 페이지 이동 시작");
			model.addAttribute("errorMsg2", "해당하는 ID가 없거나 잘못된 비밀번호를 입력하셨습니다");
			return "customer/loginPage";
		} else {
			session.setAttribute("loginId", vo.getCustid());
			session.setAttribute("loginName", vo.getName());
		}
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
}
