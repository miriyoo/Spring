package global.sesoc.web2;

import java.util.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * JSTL 사용 예제
 */
@Controller
public class JstlController {

	/**
	 * JSTL - 코어 라이브러리 연습 페이지로 이동
	 */
	@RequestMapping (value="jstl1", method=RequestMethod.GET)
	public String jstl1(Model model) {
		int number = 1;
		String str = "abc";
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		String phone = "010-1111-2222";
		String data = "<marquee>문자열</marquee>";
		
		model.addAttribute("number", number);
		model.addAttribute("str", str);
		model.addAttribute("list", list);
		model.addAttribute("phone", phone);
		model.addAttribute("data", data);
		
		return "jstl1";
	}
	
	/**
	 * JSTL - 포매팅 라이브러리 연습 페이지로 이동
	 */
	@RequestMapping (value="jstl2", method=RequestMethod.GET)
	public String jstl2(Model model) {
		Date today = new Date();
		double num1 = 12345.678;
		double num2 = 99.9;
		double num3 = 0.1;
		
		model.addAttribute("today", today);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("num3", num3);
		
		return "jstl2";
	}

	/**
	 * JSTL - 함수 라이브러리 연습 페이지로 이동
	 */
	@RequestMapping (value="jstl3", method=RequestMethod.GET)
	public String jstl3(Model model) {
		String str = "abc ABC 가나다";
		model.addAttribute("str", str);
		
		return "jstl3";
	}

}
