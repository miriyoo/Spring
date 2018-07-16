package com.scmaster.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.test.dao.BoardDAO;
import com.scmaster.test.dao.CustomerDAO;
import com.scmaster.test.vo.Board;
import com.scmaster.test.vo.Reply;

@RequestMapping("board")
@Controller
public class BoardController {

	@Autowired
	BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model){
		ArrayList<Board> list = dao.getBoardList();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(){
		return "board/writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board, Model model, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		board.setId(id);
		
		int result = dao.insertBoard(board);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "게시글 등록 실패");
			return "board/writeForm";
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value="readBoard", method=RequestMethod.GET)
	public String readBoard(int boardnum, Model model, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		Board board = dao.getBoard(boardnum);
		
		if (board == null) {
			return "redirect:list";
		}
		
		ArrayList<Reply> replylist = dao.listReply(boardnum);
		
		model.addAttribute("board", board);
		model.addAttribute("replylist", replylist);
		
		return "board/read";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int boardnum, Model model, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		
		//이 부분 참고
		Board board = new Board();
		board.setBoardnum(boardnum);
		board.setId(id);
		
		int result = dao.deleteBoard(board);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "삭제 실패");
			return "board/read";
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String edit(int boardnum, Model model, HttpSession session){
		Board board = dao.getBoard(boardnum);
		model.addAttribute("board", board);
		
		return "board/editForm";
	}
	
	@RequestMapping(value="updateBoard", method=RequestMethod.POST)
	public String edit(Board board, Model model, HttpSession session){
		String id =(String)session.getAttribute("loginId");
		
		Board vo = dao.getBoard(board.getBoardnum());
		
		//수정할 글이 로그인한 본인 글인지 확인
		if (vo == null || !vo.getId().equals(id)) {
			return "redirect:list";
		}
		
		board.setId(id);
		
		int result = dao.updateBoard(board);
		
		if (result != 1) {
			model.addAttribute("errorMsg", "수정 실패");
			return "redirect:list";
		}
		
		return "redirect:readBoard?boardnum="+board.getBoardnum();
	}
	
	@RequestMapping(value="replyWrite", method=RequestMethod.POST)
	public String replyWrite(Reply reply, Model model, HttpSession session){
		String id =(String)session.getAttribute("loginId");
		reply.setId(id);
		
		int result = dao.insertReply(reply);
		
		return "redirect:readBoard?boardnum="+reply.getBoardnum();
	}
	
	
	
	
	
	
	
	
	
	
	
}
