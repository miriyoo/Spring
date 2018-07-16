package com.scmaster.web4.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web4.dao.MemberMapper;
import com.scmaster.web4.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	SqlSession sqlSession;
	
	
	@RequestMapping(value="joinForm", method = RequestMethod.GET)
	public String joinForm(){
		return "joinForm";
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(MemberVO member){
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			mapper.insert(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="showList", method = RequestMethod.GET)
	public String showList(Model model){
		
		ArrayList<MemberVO> list = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			list = mapper.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
		
		return "showList";
	}
	
	
	
	
}
