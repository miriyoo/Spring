package com.scmaster.web6.customer.controller;

import static org.hamcrest.CoreMatchers.allOf;

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

import com.scmaster.web6.HomeController;
import com.scmaster.web6.customer.dao.CustomerDAO;
import com.scmaster.web6.customer.vo.Customer;

@Controller
@RequestMapping(value="customer") //편의성 및 가독성을 위해 그룹화
@SessionAttributes("customer")
public class CustomerJoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerJoinController.class);
	//현재 클래스 이름으로 변경
	
	@Autowired
	CustomerDAO dao;
	
	
	@RequestMapping(value="joinForm", method= RequestMethod.GET)
	public String joinForm(Model model){
		logger.info("회원 가입 폼 시작");
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		//모델에 비어었는 customer객체를 넣어준다.
		//SessionAttributes에 "customer"와 이름이 같으므로 모델에 저장하면 세션에도 자동적으로 저장된다.
		//리턴되어 화면에 돌아왔을때 어디까지 입력되었는지 정보를 알려주기 위해서
		
		logger.info("회원 가입 폼 종료");
		return "customer/joinForm"; //JSP로 이동
	}
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String idCheck(Model model){
		logger.info("ID 중복 폼 이동 시작");
		
		//검색 전후 확인용도
		model.addAttribute("search", false);
		
		//경우의 수 1. 아직 중복검사를 하지 않았을 때
		//경우의 수 2. 중복검사 창에서 검색을 눌렀을 때 -> 다시 그 창에 들어왔을 때 -> 이미 사용중입니다. 사용이 불가한 아이디입니다.
		
		logger.info("ID 중복 검사 폼 이동 종료");
		
		return "customer/idCheckForm";
	}
	
	@RequestMapping(value="idSearch", method=RequestMethod.POST)
	public String idSearch(String searchId, Model model){
		logger.info("ID 중복 검사 시작");
		
		Customer customer = dao.searchCustomerOne(searchId);
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", customer);
		model.addAttribute("search", true);
		
		logger.info("ID 중복 검사 종료");
		
		return "customer/idCheckForm";
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(@ModelAttribute("customer") Customer customer, Model model){ 
		//값이 있는지 없는지부터 확인한다. 값이 있을 때만 실행된다. 
		//model.addAttribute("customer", customer); 와 같은 기능을 하고 있는 거임
		//세션과도 공유가 된다. 
		//비어있던 customer에 값이 있는 customer를 넣어준다.
		logger.info("회원가입 시작");
		
		int result = dao.joinCustomer(customer);
		
		if (result != 1) {
			//등록 실패 -> 회원 가입 폼으로 다시 가야한다.
			model.addAttribute("errorMsg", "가입실패");
			logger.info("회원가입 실패");
			return "customer/joinForm";
		}
		
		logger.info("회원가입 종료");
		
		return "redirect:joinComplete"; //insert이기 때문에
	}
	
	@RequestMapping(value="joinComplete", method = RequestMethod.GET)//리다이렉트는 get방식
	public String joinComplete(SessionStatus session,
			@ModelAttribute("customer") Customer customer,
			Model model){
		//세션을 초기화해주는 객체 @SessionAttributes("customer")
		//@ModelAttribute("customer") Customer customer를 꼭 해줘야 한다.
		//이유1: 모델에 넣은 값이 리퀘스트에서도 저장된다. 그리고 인위적으로 주소표시창을 쳐서 들어와도 안되게금 처리
		//이유2: 전의 단계의 데이터도 가지고 있는지를 확인해준다.
		logger.info("회원가입 성공 폼 이동 시작");
		
		model.addAttribute("id", customer.getCustid());
		
		session.setComplete(); // 초기화
		
		logger.info("회원가입 성공 폼 이동 종료");
		return "customer/joinComplete";
	}
	
	
	
	
	
	
	
	
	
	
	
}
