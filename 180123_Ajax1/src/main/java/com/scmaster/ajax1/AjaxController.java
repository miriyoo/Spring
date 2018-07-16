package com.scmaster.ajax1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping(value="test1", method=RequestMethod.GET)
	public String test1(){
		return "test1";
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxtest1", method=RequestMethod.GET)
	public void ajaxtest1(){
		System.out.println("서버 : ajaxtest1 실행");
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxtest2", method=RequestMethod.POST)
	public String ajaxtest2(String str){
		System.out.println("서버:  받아온 문자열은 " + str);
		return "from server";
	}
	
	
	@RequestMapping(value="test2", method=RequestMethod.GET)
	public String test2(){
		return "test2";
	}
	
	@ResponseBody
	@RequestMapping(value="insert1", method=RequestMethod.POST)
	public void insert1(String name, String age, String phone){
		System.out.println("이름: "+ name + " 나이: " + age + " 전화번호: "+ phone);
	}
	
	@ResponseBody
	@RequestMapping(value="insert2", method=RequestMethod.POST)
	public void insert2(@RequestBody Person person){
		System.out.println("출력: " + person);
	}
	
	@ResponseBody
	@RequestMapping(value="insert3", method=RequestMethod.POST)
	public void insert3(Person person){
		System.out.println("출력: " + person);
	}
	
	@ResponseBody
	@RequestMapping(value="jsontest", method=RequestMethod.GET)
	public Person jsontest(){
		Person person = new Person("이름", "10", "010-1234-1234");
		
		return person;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
