package global.sesoc.web2;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//세션 사용 예제 1. HttpSession 사용
@Controller
public class SessionController {

	//세션에 값 저장
	@RequestMapping(value = "test1", method = RequestMethod.GET)
	public String test1(HttpSession session) {
	
		session.setAttribute("value", "test1에서 세션에 저장한 값");
		return "test";
	}
	
	//세션에서 값 삭제
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String test2(HttpSession session) {
		session.removeAttribute("value");
		return "redirect:/";
	}
}
