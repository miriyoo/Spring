package com.scmaster.web2;

import java.awt.Dialog.ModalExclusionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web2.vo.Person;

@Controller
public class ResultController {
	
	@RequestMapping(value="resultPage", method = RequestMethod.GET)
	public String resultPage(Model model){
		
		String str = "문자열";
		int number = 10;
		Date date = new Date();
		Person person = new Person();
		person.setName("이름");
		person.setAge(20);
		person.setPhone("010-1234-1234");
		
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "이름");
		map.put("age", 10);
		map.put("phone", "010-1234-1234");
		map.put("date", date);
		map.put("list", list);
		
		model.addAttribute("str", str);
		model.addAttribute("number", number);
		model.addAttribute("today", date);
		model.addAttribute("person", person);
		model.addAttribute("list", list);
		
		model.addAttribute("map", map);
		
		return "resultPage";
		
	
	}
	
}
