package com.scmaster.web6.customer.controller;

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

import com.scmaster.web6.customer.dao.CustomerDAO;
import com.scmaster.web6.customer.vo.Customer;

@Controller
@RequestMapping(value="customer") //편의성 및 가독성을 위해 그룹화
@SessionAttributes("customer")
public class CustomerUpdateController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerUpdateController.class);
	//현재 클래스 이름으로 변경
	
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String update(String loginId, Model model){
		logger.info("개인정보 수정 페이지 이동 시작");
		
		//String custid = (String)session.getAttribute("loginId"); 해도 된다.
		
		Customer customer = dao.searchCustomerOne(loginId);
		
		model.addAttribute("customer", customer);
		
		logger.info("개인정보 수정 페이지 이동 종료");
		
		return "customer/updateInfo";
	}
	
	@RequestMapping(value="updateInfo", method = RequestMethod.POST)
	public String updateInfo(@ModelAttribute("customer") Customer customer, Model model){
		// 쿼리 작성 -> 다오까지
		logger.info("개인 정보 수정 시작");
		
		int result = dao.UpdateCustomer(customer);
		
		if (result != 1) {
			//등록 실패 -> 수정 폼으로 다시 가야한다.
			model.addAttribute("errorMsg", "수정실패");
			logger.info("개인 정보 수정 실패");
			return "customer/updateInfo";
		}
		
		logger.info("개인 정보 수정 종료");
		
		return "redirect:updateComplete";
	}
	
	@RequestMapping(value="updateComplete", method = RequestMethod.GET)
	public String updateComplete(SessionStatus status,
			@ModelAttribute("customer") Customer customer,
			Model model, HttpSession session){
		
		logger.info("개인 정보 수정 성공 폼 이동 시작");
		
		session.setAttribute("loginName", customer.getName());
		model.addAttribute("id", customer.getCustid());
		
		status.setComplete();// 초기화
		
		logger.info("개인 정보 수정 성공 폼 이동 종료");
		
		return "customer/updateComplete";
	}
	
	
	
	
	
	
	
	
	
}
