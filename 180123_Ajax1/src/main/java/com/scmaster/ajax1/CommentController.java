package com.scmaster.ajax1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scmaster.ajax1.dao.CommentDAO;

@Controller
public class CommentController {
	
	@Autowired
	CommentDAO dao;

	@RequestMapping(value="comment", method=RequestMethod.GET)
	public String comment(){
		return "comment";
	}
	
	@ResponseBody
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insert(@RequestBody Comment comment){
		//DAO부터 Mapper.xml까지 연결해서 호출하기
		int result = dao.insertReply(comment);
		
		if (result != 1) {
			//에러 경고
		}
	}
	
	@ResponseBody
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ArrayList<Comment> list(){
		ArrayList<Comment> list = dao.list();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public void delete(int num){
		int result = dao.delete(num);
	}
	
}
