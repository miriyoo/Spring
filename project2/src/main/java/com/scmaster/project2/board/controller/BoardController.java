package com.scmaster.project2.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.scmaster.project2.board.dao.BoardDAO;
import com.scmaster.project2.board.vo.BlogBoard;
import com.scmaster.project2.board.vo.BlogReply;
import com.scmaster.project2.common.util.FileService;

@Controller
@RequestMapping(value="board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//현재 클래스 이름으로 변경
	
	@Autowired
	BoardDAO dao;
	
	final String uploadPath = "/memberFile";
	
	@RequestMapping(value="writeForm", method = RequestMethod.GET)
	public String writeForm(){
		logger.info("글 쓰기 폼 이동 시작");
		logger.info("글 쓰기 폼 이동 시작");
		return "board/writeForm";
	}
	
	@RequestMapping(value="insertBoard", method=RequestMethod.POST)
	public String insertBoard(HttpSession session, BlogBoard board, Model model,
			MultipartFile upload){
		logger.info("게시판 글 등록 시작");
		
		String id = (String)session.getAttribute("loginId");
		board.setId(id);
		
		//첨부파일이 있는 경우
		if (!upload.isEmpty()) {
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(savedfile);
			board.setOriginalfile(upload.getOriginalFilename());
		}
		
		int result = dao.insertBoard(board);
		
		if (result != 1) {
			logger.info("게시판 글 등록 실패");
			model.addAttribute("errorMsg", "글 등록 실패");
			return "board/writeForm";
		}
		
		logger.info("게시판 글 등록 종료");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="readBoard", method = RequestMethod.GET)
	public String readBoard(int boardnum, Model model){
		logger.info("특정 게시글 조회 시작");
		
		BlogBoard vo = dao.selectBoardOne(boardnum);
		
		ArrayList<BlogReply> replyList = dao.selectReplyAll(boardnum);
		
		System.out.println(vo);
		model.addAttribute("vo", vo);
		model.addAttribute("replyList", replyList);
		
		logger.info("특정 게시글 조회 종료");
		
		return "board/readBoard";
	}
	
	@RequestMapping(value="deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(int boardnum, HttpSession session, Model model){
		logger.info("게시판 글 삭제 시작");
		String id = (String)session.getAttribute("loginId");
		
		BlogBoard board = new BlogBoard();
		board.setBoardnum(boardnum);
		board.setId(id);
		
		BlogBoard vo = dao.selectBoardOne(boardnum);
		
		//삭제
		int result = dao.deleteBoard(board);
		
		if (result != 1) {
			logger.info("게시판 글 삭제 실패");
			model.addAttribute("errorMsg", "가입 실패");
			return "board/readBoard"; 
		}
		
		FileService.deleteFile(uploadPath + "/" + vo.getSavedfile());
		
		logger.info("게시판 글 삭제 종료");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="reviseBoard", method=RequestMethod.GET)
	public String reviseBoard(int boardnum, HttpSession session, Model model){
		logger.info("게시판 글 수정 폼 이동 시작");
		
		BlogBoard board = dao.selectBoardOne(boardnum);
		String id = (String)session.getAttribute("loginId");
		
		if (!board.getId().equals(id)) {
			logger.info("수정 폼 이동 실패");
			return "redirect:/";
		}
		
		model.addAttribute("board", board);
		
		logger.info("게시판 글 수정 폼 이동 종료");
		
		return "board/updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(BlogBoard board, HttpSession session, Model model){
		logger.info("게시판 글 수정 시작");
		
		String id = (String)session.getAttribute("loginId");
		board.setId(id);
		
		int result = dao.reviseOne(board);
		
		if (result != 1) {
			logger.info("게시판 글 수정 실패");
			model.addAttribute("errorMsg", "수정 실패");
			return "board/updateForm";
		}
		
		logger.info("게시판 글 수정 종료");
		
		//return "redirect:readBoard?boardnum="+board.getBoardnum();
		return "redirect:/";
	}
	
	@RequestMapping(value="download", method=RequestMethod.GET)
	public void fileDownload(int boardnum, HttpServletResponse response){
		BlogBoard board = dao.selectBoardOne(boardnum);
		
		String originalfile = board.getOriginalfile();
		
		try{
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(originalfile, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String fullPath = uploadPath + "/" + board.getSavedfile();
		
		FileInputStream fis = null; 
		ServletOutputStream sos = null;
		
		try{
			fis = new FileInputStream(fullPath);
			sos = response.getOutputStream(); 
			
			FileCopyUtils.copy(fis, sos); 
			
			fis.close();
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="insertReply", method=RequestMethod.POST)
	public String insertReply(BlogReply reply, HttpSession session, Model model){
		logger.info("리플 등록 시작");
		
		String id = (String)session.getAttribute("loginId");
		reply.setId(id);
		
		int result = dao.insertReply(reply);
		
		if (result != 1) {
			logger.info("리플 등록 실패");
			model.addAttribute("errorMsg", "리플 등록 실패");
			return "redirect:readBoard?boardnum="+reply.getBoardnum();
		}
		
		logger.info("리플 등록 종료");
		
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	@RequestMapping(value="deleteReply", method=RequestMethod.GET)
	public String deleteReply(BlogReply reply, HttpSession session, Model model){
		logger.info("리플 삭제 시작");
		
		String id = (String)session.getAttribute("loginId");
		reply.setId(id);
		
		int result = dao.deleteReply(reply);
		
		if (result != 1) {
			logger.info("리플 삭제 실패");
			model.addAttribute("errorMsg1", "리플 삭제 실패");
			return "redirect:readBoard?boardnum="+reply.getBoardnum();
		}
		
		logger.info("리플 삭제 종료");
		
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	@RequestMapping(value="replyUpdate", method=RequestMethod.POST)
	public String replyUpdate(BlogReply reply, HttpSession session, Model model){
		logger.info("리플 수정 시작");
		
		String id = (String)session.getAttribute("loginId");
		reply.setId(id);
		
		int result = dao.replyUpdate(reply);
		
		if (result != 1) {
			logger.info("리플 삭제 실패");
			model.addAttribute("errorMsg2", "리플 수정 실패");
			return "redirect:readBoard?boardnum="+reply.getBoardnum();
		}
		
		logger.info("리플 수정 종료");
		
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
