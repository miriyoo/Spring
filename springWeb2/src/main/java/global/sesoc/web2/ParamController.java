package global.sesoc.web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 클라이언트 -> 서버로의 요청 parameter 전달 연습
 */
@Controller
public class ParamController {
	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);
	
	/**
	 * GET 방식의 parameter 전달
	 */
	@RequestMapping(value="param1", method=RequestMethod.GET)
	public String param1(String str, int num) {
		
		logger.debug("전달된 문자열 : {}, 숫자 : {}", str, num);
		return "redirect:/";
	}
	
	/**
	 * Form 보여주기
	 */
	@RequestMapping(value="param2", method=RequestMethod.GET)
	public String param2() {
		return "param2";
	}
	
	/**
	 * param2.jsp로부터 POST 방식의 parameter 전달
	 */
	@RequestMapping(value="param2", method=RequestMethod.POST)
	public String param2(String name, String phone, String address) {
		
		logger.debug("name : {}", name);
		logger.debug("phone : {}", phone);
		logger.debug("address : {}", address);
		return "redirect:/";
	}
	
	/**
	 * Form 보여주기
	 */
	@RequestMapping(value="param3", method=RequestMethod.GET)
	public String param3() {
		return "param3";
	}
	
	/**
	 * param3.jsp로부터 POST 방식의 parameter 전달
	 */
	@RequestMapping(value="param3", method=RequestMethod.POST)
	public String param3(Person person, String etc) {
		
		logger.debug("person : {}", person);
		logger.debug("etc : {}", etc);
		return "redirect:/";
	}
}
