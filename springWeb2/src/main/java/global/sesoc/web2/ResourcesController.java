package global.sesoc.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 리소스 사용 예제
 */
@Controller
public class ResourcesController {

	/**
	 * 리소스 파일들 사용 연습 페이지로 이동
	 */
	@RequestMapping (value="res", method=RequestMethod.GET)
	public String resources() {
		return "res";
	}
}
