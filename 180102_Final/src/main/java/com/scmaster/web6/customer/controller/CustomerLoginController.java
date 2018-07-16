package com.scmaster.web6.customer.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.scmaster.web6.customer.dao.CustomerDAO;
import com.scmaster.web6.customer.vo.Customer;

@Controller
@RequestMapping(value="customer") //편의성 및 가독성을 위해 그룹화
@SessionAttributes("customer")
public class CustomerLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);
	//현재 클래스 이름으로 변경
	
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping(value="loginPage", method = RequestMethod.GET)
	public String loginPage(){
		logger.info("로그인 페이지 이동 시작");
		logger.info("로그인 페이지 이동 종료");
		return "customer/loginPage";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(HttpSession session, Customer customer, Model model){
		//화면으로부터 받아온 ID로 DB검색
		Customer vo = dao.searchCustomerOne(customer.getCustid());
		
		if (vo == null) {
			logger.info("로그인 페이지 이동");
			model.addAttribute("errorMsg1", "해당 아이디가 없습니다.");
			return "customer/loginPage";
		} else if (!vo.getPassword().equals(customer.getPassword())){
			logger.info("로그인 페이지 이동");
			model.addAttribute("errorMsg2", "잘못된 비밀번호를 입력하셨습니다.");
			return "customer/loginPage";
		} else {
			session.setAttribute("loginId", vo.getCustid());
			session.setAttribute("loginName", vo.getName());
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		/*session.removeAttribute("loginId");
		session.removeAttribute("loginPassword");
		session.removeAttribute("loginName");*/
		session.invalidate();
		
		return "redirect:/"; 
		//delete와 같기 때문에 리다이렉트해야함.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
