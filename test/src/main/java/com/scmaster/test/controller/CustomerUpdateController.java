package com.scmaster.test.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class CustomerUpdateController {

	@Autowired
	CustomerDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerUpdateController.class);
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(Model model, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		
		Customer customer = dao.selectOneCustomer(id);
		model.addAttribute("customer", customer);
		
		return "customer/updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateform(@ModelAttribute("customer")Customer customer,
			Model model){
		
		//쿼리 => 다오
		int result = dao.updateCustomer(customer);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "수정 실패");
			return "customer/updateForm";
		}
		
		return "redirect:updateComplete";
	}
	
	@RequestMapping(value="updateComplete", method=RequestMethod.GET)
	public String updateComplete(@ModelAttribute("customer")Customer customer, 
			HttpSession session, SessionStatus status, Model model ){
		session.setAttribute("loginName", customer.getName());
		
		model.addAttribute("customer", customer);
		
		status.setComplete();
		
		return "customer/updateComplete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
