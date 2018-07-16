package com.scmaster.www;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(Model model, double num1, double num2, String calc){
		// 이 함수가 실행될때 스프링 자동적으로 모델을 생성해서 전달해줌
		double result = 0;
		
		if (calc.equals("1")) {
			result = num1 + num2;
		} else if (calc.equals("2")) {
			result = num1 - num2;
		} else if (calc.equals("3")) {
			result = num1 * num2;
		} else if (calc.equals("4")) {
			result = num1 / num2;
		}
		
		model.addAttribute("result", result);
	

		return "test"; // test.jsp로 이동, 주소 표시창이 바뀔 것이다.
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(Model model){
		
		return "/member/member"; // .jsp 쓰면 안됨. 주소가 바뀌면서 다시 test로 돌아감
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(Model model){
		
		return "home"; // .jsp 쓰면 안됨. 주소가 바뀌면서 다시 test로 돌아감
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
