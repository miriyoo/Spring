package com.scmaster.web5.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web5.dao.BoardDAO;
import com.scmaster.web5.dao.BoardMapper;
import com.scmaster.web5.vo.BoardVO;



@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	@RequestMapping(value="writeBoard", method = RequestMethod.GET)
	public String writeBoard(){
		return "writeBoard";
	}
	
	@RequestMapping(value="insertBoard", method= RequestMethod.POST)
	public String insertBoard(BoardVO board){
		
		dao.insertBoard(board);
		
		return "redirect:/";
	}
	
	//글 삭제 - 글번호와 비밀번호를 각각 전달받아 Map에 담아 처리
	@RequestMapping(value="deleteBoard", method= RequestMethod.POST)
	public String deleteBoard(int boardNo, String boardPassword){
		
		if( dao.deleteBoard(boardNo, boardPassword) ){
			System.out.println("성공");
		} else
		{
			System.out.println("실패");	
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="updateBoard", method= RequestMethod.GET)
	public String updateBoard(int boardNo, Model model){
		
		BoardVO vo = dao.selectOne(boardNo);
		
		//dao.updateBoard(vo);
		model.addAttribute("vo", vo);
		
		return "updateBoard";
	}
	
	@RequestMapping(value="updateComplete", method = RequestMethod.POST)
	public String updateComplete(BoardVO board){
		
		dao.updateBoard(board);
		
		return "redirect:/";
	}
	
	
}
