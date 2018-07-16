package com.scmaster.test.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.test.dao.CustomerDAO;
import com.scmaster.test.vo.Customer;

@RequestMapping("customer")
@Controller
public class CustomerLoginController {

	@Autowired
	CustomerDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);
	
	@RequestMapping (value="login", method=RequestMethod.GET)
	public String loginForm() {
		return "customer/loginForm";
	}
	
	@RequestMapping (value="login", method=RequestMethod.POST)
	public String login(String id, String password, HttpSession session, Model model) {
		Customer vo = dao.selectOneCustomer(id);
		
		if (vo == null || !vo.getPassword().equals(password)) {
			model.addAttribute("errorMsg", "로그인 실패");
			return "customer/loginForm";
		}  else {
			session.setAttribute("loginId", vo.getCustid());
			session.setAttribute("loginName", vo.getName());
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
