package com.scmaster.web2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResController {
	
	@RequestMapping(value="res/resPage", method = RequestMethod.GET)
	public String resPage(Model model){
		
		// 난수를 발생시켜서 1~3 난수를 화면으로 전달해서
		double randomValue = Math.random();
		int value = (int)(randomValue * 3) + 1;
		
		// 값을 화면으로 전달하기 위해 모델 객체 사용
		model.addAttribute("value", value);
		
		return "resPage";
	}
}
