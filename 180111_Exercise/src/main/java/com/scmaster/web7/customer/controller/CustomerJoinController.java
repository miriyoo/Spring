package com.scmaster.web7.customer.controller;

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

import com.scmaster.web7.HomeController;
import com.scmaster.web7.customer.dao.CustomerDAO;
import com.scmaster.web7.customer.vo.Customer1;

@Controller
@RequestMapping(value="customer")
@SessionAttributes("customer")
public class CustomerJoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);
	
	@Autowired
	CustomerDAO dao;
	
	
	@RequestMapping(value="joinForm", method = RequestMethod.GET)
	public String joinForm(Model model){
		logger.info("회원가입 폼 이동 시작");
		
		Customer1 customer = new Customer1();
		
		model.addAttribute("customer", customer);
		
		logger.info("회원가입 폼 이동 종료");
		return "customer/joinForm";
	}
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String idCheck(Model model){
		logger.info("아이디 중복 체크 폼 이동 시작");
		
		model.addAttribute("search", false);
		
		logger.info("아이디 중복 체크 폼 이동 종료");
		return "customer/idCheckForm";
	}
	
	@RequestMapping(value="idSearch", method=RequestMethod.POST)
	public String idSearch(String searchId, Model model){
		logger.info("아이디 중복 검사 시작");
		
		Customer1 customer = dao.searchCustomerOne(searchId);
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", customer);
		model.addAttribute("search", true);
		
		logger.info("아이디 중복 검사 종료");
		
		return "customer/idCheckForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute("customer") Customer1 customer, Model model){
		logger.info("회원 등록 시작");
		
		int result = dao.joinCustomer(customer);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "회원 등록 실패");
			logger.info("회원 등록 실패");
			return "customer/joinForm";
		}
		
		logger.info("회원 등록 종료");
		
		return "redirect:joinComplete";
	}
	
	@RequestMapping(value="joinComplete", method= RequestMethod.GET)
	public String joinComplete(SessionStatus status, @ModelAttribute("customer")Customer1 customer
			, Model model){
		
		logger.info("회원 등록 성공 폼 이동 시작");
		model.addAttribute("id", customer.getCustid());
		
		status.setComplete();
		
		logger.info("회원 등록 성공 폼 이동 종료");
		
		return "customer/joinComplete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
