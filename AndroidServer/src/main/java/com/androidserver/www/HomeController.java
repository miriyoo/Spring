package com.androidserver.www;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.androidserver.www.dao.MemberDAO;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberDAO dao;
	
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
	
	@ResponseBody
	@RequestMapping(value = "insertMember", method = RequestMethod.POST)
	public String insertMember(Member member) {
		
		int result = dao.insertMember(member);
		String msg = "";
		if(result != 1){
			msg = "Member Insert Fail";
		}else{
			msg = "Member Insert Success";
		}
		
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "selectMember", method = RequestMethod.GET)
	public String selectMember() {
		
		ArrayList<Member> list = dao.selectMember();
		//웹 서버의 list를 안드로이드에 전달하기 위해서는 Json([{키:값}]을 통해서 문자열로 변환해준다.
	
		//외부 라이브러리 사용 -> pom.xml에 <!--Gson-->을 추가하면 사용할 수 있다.
		//자바의 객체를 JSON형태의 문자열로 만들어주는 역할은 한다.
		//JSON형태의 문자열을 자바의 객체로 바꿔주는 역할을 한다. 역변환도 가능
		Gson gson = new Gson();
		
		//ArrayList가 JSON형태의 String으로 나온다.
		String result = gson.toJson(list);
		
		//값을 리턴
		return result;
	}
}
