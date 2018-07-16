package com.scmaster.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web2.vo.Person;

@Controller
public class ParamController {
	
	@RequestMapping(value= "parameterPage", method = RequestMethod.GET)
	public String paramPage(){
		return "paramPage";
	}
	
	@RequestMapping(value="paramGet", method = RequestMethod.GET)
	public String paramGet(String str, int num){
		System.out.println("넘어온 문자열 : " + str);
		System.out.println("넘어온 숫자 : "+ num);
		return "paramPage";
	}
	
	@RequestMapping(value = "paramPost", method = RequestMethod.POST)
	public String paramPost(Person person, String etc){ // v.o 변수명과 화면에서의 name이 같아야한다.
		System.out.println(person);
		System.out.println(etc);
		return "paramPage";
	}
	
}
