package com.scmaster.www;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.www.vo.InputVO;
import com.scmaster.www.vo.RateVO;

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
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String test1(Model model, HttpServletRequest request){
		model.addAttribute("str", "str");
		request.setAttribute("num", "num");
		System.out.println("test1: " + model); // 실행결과 test4: {str=str}
		return "forward:test2";
	}
		
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String test2(HttpServletRequest request, Model model){
		System.out.println(request.getAttribute("num"));
		System.out.println(request.getAttribute("str"));
		System.out.println("test2: " + model);
		return "test2"; // 실행결과 test5: {}
	}
	
	@RequestMapping(value="strTest", method=RequestMethod.POST)
	public String inputTest(InputVO inputVO){ // 스프링에게 객체생성을 요청 의존성 주입!
		
		System.out.println(inputVO);
		
		return "home";
	}
	
	@RequestMapping(value="exchangeRateForm", method=RequestMethod.GET)
	public String exchangeRateForm(){ // 스프링에게 객체생성을 요청 의존성 주입!
		return "exchangeRate";
	}
	
	@RequestMapping(value="calcRate", method=RequestMethod.POST)
	public String calcRate(RateVO rateVO, Model model){ // 스프링에게 객체생성을 요청 의존성 주입!
		int won = rateVO.getWon();
		String country = rateVO.getCountry();
		double result = 0;
		
		if (country.equals("1")) {
			result = won / 1090.20;
		} else if (country.equals("2")) {
			result = (won / 971.27) * 100.0; 
		} else if (country.equals("3")) {
			result = (won / 165.02) * 100.0; 
		} else if (country.equals("4")) {
			result = won / 836.14; 
		} else if (country.equals("5")) {
			result = won / 763.49; 
		} else if (country.equals("6")) {
			result = won / 139.54; 
		} else if (country.equals("7")) {
			result = won / 1464.58; 
		}
		
		model.addAttribute("won", won);
		model.addAttribute("country", country);
		model.addAttribute("result", result); // 데이터를 넣어줘야 함
		
		return "test3";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
}
