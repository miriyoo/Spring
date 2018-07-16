package com.scmaster.web6.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scmaster.web6.board.dao.BoardDAO;
import com.scmaster.web6.board.vo.Board;
import com.scmaster.web6.board.vo.Reply;
import com.scmaster.web6.common.util.FileService;
import com.scmaster.web6.common.util.PageNavigator;

@Controller
@RequestMapping(value="board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//현재 클래스 이름으로 변경
	
	@Autowired
	BoardDAO dao;
	
	final String uploadPath = "/boardfile"; //파일 업로드 경로
	
	final int countPerPage = 5;
	final int pagePerGroup = 10;
	

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model model,
			@RequestParam(value="searchText", defaultValue="") String searchText,
			@RequestParam(value="searchSelect", defaultValue="title") String searchSelect,
			@RequestParam(value="page", defaultValue="1") int page){
		logger.info("글 목록 이동 시작");
		
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchText", searchText);
		searchMap.put("searchSelect", searchSelect);

		//전체 글 개수(검색어 포함)
		int total = dao.getTotal(searchMap);
		
		//페이지 계산을 위한 객체 생성
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		
		//글 목록 가져오기
		ArrayList<Board> list = dao.selectBoardAll(searchMap,navi.getStartRecord(),navi.getCountPerPage());
		
		model.addAttribute("list", list);
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchSelect", searchSelect);
		model.addAttribute("navi", navi);
		logger.info("글 목록 이동 종료");
		
		return "board/list";
	}

	
	
	
	@RequestMapping(value="writeForm", method = RequestMethod.GET)
	public String writeForm(){
		logger.info("글 쓰기 폼 이동 시작");
		logger.info("글 쓰기 폼 이동 시작");
		return "board/writeForm";
	}
	
	@RequestMapping(value="insertBoard", method = RequestMethod.POST)
	public String insertBoard(HttpSession session, Model model, Board board
			, MultipartFile upload){
		logger.info("게시판 글 등록 시작");
		
		String id = (String)session.getAttribute("loginId");
		
		board.setId(id);
		
		//첨부파일이 있는 경우 -> 사용자가 첨부파일을 올렸을 수도 있고 아닐수도 있기 때문에
		if (!upload.isEmpty()) {
			//Board객체에 originalFileName과 savedfileName을 저장.
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(savedfile);
			board.setOriginalfile(upload.getOriginalFilename());
		}
		
		int result = dao.insertBoard(board);
		
		if (result != 1) {
			//등록 실패 -> 회원 가입 폼으로 다시 가야한다.
			model.addAttribute("errorMsg", "등록 실패");
			logger.info("게시판 글 등록 실패");
			return "board/writeForm";
		}
		
		logger.info("게시판 글 등록 종료");
		
		return "redirect:list"; //insert이기 때문에
	}
	
	@RequestMapping(value="readBoard", method = RequestMethod.GET)
	public String readBoard(int boardnum, Model model){
		logger.info("게시판 글 읽기 페이지 이동 시작");
		
		//특정 게시글 조회
		Board vo = dao.selectBoardOne(boardnum);
		
		//글번호에 해당하는 리플 내용들 -> 댓글을 가져오는 쿼리가 필요
		ArrayList<Reply> replyList = dao.selectReplyAll(boardnum);
		
		model.addAttribute("replyList", replyList);
		model.addAttribute("vo", vo);
		
		logger.info("게시판 글 읽기 페이지 이동 종료");
		
		return "board/readBoard";
	}
	
	@RequestMapping(value="deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(int boardnum, Model model, HttpSession session){
		logger.info("게시판 글 삭제 진행 시작");
		String id = (String)session.getAttribute("loginId");
		
		Board board = new Board();
		board.setId(id);
		board.setBoardnum(boardnum);
		
		Board vo = dao.selectBoardOne(boardnum);
		
		int result = dao.deleteBoard(board);
		
		if (result != 1) {
			//삭제 실패
		}
		
		FileService.deleteFile(uploadPath + "/" + vo.getSavedfile());
		
		logger.info("게시판 글 삭제 진행 종료");
		
		return "redirect:list";
	}
	
	@RequestMapping(value="reviseBoard", method=RequestMethod.GET)
	public String reviseBoard(int boardnum, Model model, HttpSession session){
		Board board = dao.selectBoardOne(boardnum);
		String id = (String)session.getAttribute("loginId");
		
		if (!board.getId().equals(id)) {
			//아이디가 다를 경우
			return "redirect:list";
		}
		
		model.addAttribute("board", board);
		
		return "board/updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Board board, Model model, HttpSession session){
		
		String id = (String)session.getAttribute("loginId");
		board.setId(id);
		//3개의 데이터는 받아오고 id까지 총 4개의 정보를 set
		
		int result = dao.reviseOne(board);
		
		if (result != 1) {
			//수정 실패
		}
		
		//해당 글로 돌아가서 수정된 화면을 보여준다.
		return "redirect:readBoard?boardnum="+board.getBoardnum();
	}
	
	//다운로드
	@RequestMapping(value="download", method=RequestMethod.GET)
	public void fileDownload(int boardnum, HttpServletResponse response){
		Board board = dao.selectBoardOne(boardnum);
		
		//요청에 대한 사용자에 대한 응답을 해줄때, 파일을 같이 담아서 사용자에게 전달해준다.-> response를 받아준다.
		//원래 파일명 response Header에 인코딩해서 등록
		String originalfile = board.getOriginalfile();
		
		try{
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(originalfile, "UTF-8"));
			//파일이름으로 다운로드가 된다. 거의 복붙해서 사용
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//저장된 파일 경로
		String fullPath = uploadPath + "/" + board.getSavedfile();
		
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력 스트림
		FileInputStream fis = null; //내 PC로 부터 파일 읽기
		ServletOutputStream sos = null;//사용자에게 전달할 것은 response 즉 서블릿을 통해 내보내진다.
		
		try{
			fis = new FileInputStream(fullPath);
			sos = response.getOutputStream(); //통로 개설 완료
			
			FileCopyUtils.copy(fis, sos); //굉장히 편리한 기능(스프링에서 제공)
			
			fis.close();
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//리플
	@RequestMapping(value="insertReply", method=RequestMethod.POST)
	public String insertReply(Reply reply, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		reply.setId(id);
		int result = dao.insertReply(reply);
		
		if (result != 1) {
			//리플 등록 실패
		}
		
		
		//다시 그 글로 돌아가야한다. readBoard
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	//리플 삭제
	@RequestMapping(value="deleteReply", method= RequestMethod.GET)
	public String deleteReply(Reply reply, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		reply.setId(id);
		int result = dao.deleteReply(reply);
		
		if (result != 1) {
			//리플 삭제 실패
		}
		
		
		//다시 그 글로 돌아가야한다. readBoard
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	//리플 수정
	@RequestMapping(value="replyUpdate", method=RequestMethod.POST)
	public String replyUpdate(Reply reply, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		reply.setId(id);
		
		//쿼리 -> 다오
		int result = dao.replyUpdate(reply);
		
		if (result != 1) {
			//리플 수정 실패
		}
		
		//다시 그 글로 돌아가야한다. readBoard
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
