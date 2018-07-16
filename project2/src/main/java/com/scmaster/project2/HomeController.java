package com.scmaster.project2;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scmaster.project2.board.dao.BoardDAO;
import com.scmaster.project2.board.vo.BlogBoard;
import com.scmaster.project2.common.util.PageNavigator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BoardDAO dao;
	
	final int countPerPage = 10;
	final int pagePerGroup = 10;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {(RequestMethod.GET)})
	public String home(Model model,
			@RequestParam(value="searchText", defaultValue="") String searchText,
			@RequestParam(value="searchSelect", defaultValue="title") String searchSelect,
			@RequestParam(value="page", defaultValue="1")int page) {

		logger.info("Index Page Start");
		
		logger.info("게시판 목록 가져오기 시작");
		
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchText", searchText);
		searchMap.put("searchSelect", searchSelect);
		
		int total = dao.getTotal(searchMap);
		
		//조회 수 상위 3개 컨텐츠
		ArrayList<BlogBoard> hotTopic = dao.selectBoardAllHits();
		
		
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		ArrayList<HashMap<String, Object>> list = dao.selectBoardAll(searchMap, navi.getStartRecord(),
				navi.getCountPerPage());
		
		model.addAttribute("list", list);
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchText", searchSelect);
		model.addAttribute("navi", navi);
		model.addAttribute("total", total);
		model.addAttribute("hotTopic", hotTopic);
		
		logger.info("게시판 목록 가져오기 종료");
		
		return "home";
	}
	
	
}
