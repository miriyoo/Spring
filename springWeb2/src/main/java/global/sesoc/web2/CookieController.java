package global.sesoc.web2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 쿠키 사용 예제
 */
@Controller
public class CookieController {
	/**
	 * 쿠키 저장
	 */
	@RequestMapping (value="cookie1", method=RequestMethod.GET)
	public String cookie1(HttpServletResponse response) {
		//쿠키 생성
		Cookie cookie1 = new Cookie("id", "abc");
		Cookie cookie2 = new Cookie("num", "123");
		//클라이언트로 쿠키 저장
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "redirect:/";
	}
	
	/**
	 * 쿠키 삭제
	 */
	@RequestMapping (value="cookie2", method=RequestMethod.GET)
	public String cookie2(HttpServletResponse response) {
		//같은 이름으로 유지시간이 0인 쿠키 생성
		Cookie cookie1 = new Cookie("id", null);
		cookie1.setMaxAge(0);
		Cookie cookie2 = new Cookie("num", null);
		cookie2.setMaxAge(0);
		//클라이언트로 저장하여 덮어씀
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "redirect:/";
	}
	
	/**
	 * 모든 쿠키 읽기
	 */
	@RequestMapping (value="cookie3", method=RequestMethod.GET)
	public String cookie3(HttpServletRequest request) {
		//클라이언트의 모든 쿠키를 배열로 읽어옴
		Cookie cks[] = request.getCookies();
		
		for (Cookie c : cks) {
			System.out.println("이름:" + c.getName() + ", 값:" + c.getValue());
		}
		
		return "redirect:/";
	}
	
	/**
	 * annotation을 이용하여 특정 쿠키 읽기
	 */
	@RequestMapping (value="cookie4", method=RequestMethod.GET)
	public String cookie4(
			@CookieValue(value="id", defaultValue="none") String id,
			@CookieValue(value="num", defaultValue="0") int num) {
		
		//해당 이름을 가진 쿠키를의 값을 읽어온다.
		System.out.println("id=" + id);
		System.out.println("num=" + num);
		
		return "redirect:/";
	}

}
