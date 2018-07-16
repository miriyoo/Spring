package firepad.function.save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(String loginId, HttpSession session){
		logger.info("로그인");
		
		session.setAttribute("loginId", loginId);
		
		return "redirect:menu";
	}
	
	@RequestMapping(value="menu", method=RequestMethod.GET)
	public String menu(HttpSession session){
		logger.info("메뉴로 가기");

		return "menu";
	}
	
	@RequestMapping(value="post", method=RequestMethod.GET)
	public String post(HttpSession session){
		
		return "post";
	}
	
	@RequestMapping(value="saveData", method=RequestMethod.POST)
	public String saveData(String hidden_data, HttpSession session){
		
		logger.info("str : "+hidden_data);
		
        Date date = new Date(); 
        SimpleDateFormat simpleDate = new SimpleDateFormat("_yyMMdd_hhmmss_");
        String finalDate = simpleDate.format(date);

		String loginId = (String)session.getAttribute("loginId");	
        String fileName = "C:\\test\\"+loginId+finalDate+Math.random()+".txt";

        try{
            //BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
             
            //파일 안에 문자열 쓰기
            fw.write(hidden_data);
            fw.flush();
 
            //객체 닫기
            fw.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

		return "redirect:/menu";
	}
	
}
