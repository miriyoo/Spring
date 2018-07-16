package global.sesoc.web4;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web4.dao.BoardMapper;
import global.sesoc.web4.vo.Board;

/**
 * 방명록 컨트롤러
 */
@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 게시판 글쓰기 폼 보기
	 */
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	/**
	 * 게시판 글 저장
	 */
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board) {
		logger.debug("전달된 param : {}", board);
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.insert(board);
		
		return "redirect:list";
	}
	
	/**
	 * 게시판 글 전체 보기
	 */
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Board> list = mapper.select();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	/**
	 * 글 삭제 1 - 글번호와 비밀번호를 VO객체로 받음
	 */
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(Board board) {
		logger.debug("삭제정보 : {}", board);
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = mapper.delete(board);
				
		return "redirect:list";
	}

	/**
	 * 글 삭제 2 - 글번호와 비밀번호를 각각 전달받아 Map에 담아 처리
	 */
	@RequestMapping(value="delete2", method=RequestMethod.POST)
	public String delete2(int boardnum, String password) {
		logger.debug("삭제정보 : {} / {}", boardnum, password);
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		HashMap<String, Object> map = new HashMap<>();
		map.put("boardnum", boardnum);
		map.put("password", password);
		int result = mapper.delete2(map);
				
		return "redirect:list";
	}

	/**
	 * 글 삭제 3 - 글번호와 비밀번호를 각각 전달받아 여러개의 parameter로 처리
	 */
	@RequestMapping(value="delete3", method=RequestMethod.POST)
	public String delete3(int boardnum, String password) {
		logger.debug("삭제정보 : {} / {}", boardnum, password);
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = mapper.delete3(boardnum, password);
				
		return "redirect:list";
	}
}
