package com.scmaster.test.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
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

import com.scmaster.test.dao.CustomerDAO;
import com.scmaster.test.vo.Customer;


@SessionAttributes("customer")
@RequestMapping("customer")
@Controller
public class CustomerJoinController {
	
	@Autowired
	CustomerDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);

	@RequestMapping(value="join", method=RequestMethod.GET)
	public String joinForm(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer/joinForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute("customer") Customer customer,
			Model model){
		
		int result = dao.insertCustomer(customer);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "가입 실패");
			return "customer/joinForm";
		}
		
		model.addAttribute("customer", customer);
		return "redirect:joinComplete";
	}
	
	@RequestMapping(value="joinComplete", method=RequestMethod.GET)
	public String joinComplete(@ModelAttribute("customer") Customer customer,
			SessionStatus status, Model model){
		
		model.addAttribute("id", customer.getCustid());
		status.setComplete();
		
		return "customer/joinComplete";
	}
	
	
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String idCheck(Model model){
		model.addAttribute("search", false);
		return "customer/idCheck";
	}
	
	@RequestMapping(value="idCheckForm", method=RequestMethod.POST)
	public String idCheckForm(Model model, String searchId){
		//쿼리 => 다오
		Customer customer = dao.selectOneCustomer(searchId);
		
		model.addAttribute("search", true);
		model.addAttribute("searchResult", customer);
		model.addAttribute("searchId", searchId);
		
		return "customer/idCheck";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
