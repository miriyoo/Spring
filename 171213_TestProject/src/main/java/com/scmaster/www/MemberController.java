package com.scmaster.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member") // 이 클래스는 모두 /member가 붙어서 온다.
public class MemberController {
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String member(){
		return "member";
	}
	// 클래스의 RequestMapping의 value에 넣으면 이 클래스의 해당하는 모두 메소드나 함수가 /member 뒤로 온다.
	// 사이트의 영역을 이런식으로 나누면 된다.
	// /member/join이 된다.
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(Model model){
		
		return "test"; // .jsp 쓰면 안됨. 주소가 바뀌면서 다시 test로 돌아감
	}
	
}
