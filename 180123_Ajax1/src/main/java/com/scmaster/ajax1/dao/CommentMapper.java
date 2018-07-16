package com.scmaster.ajax1.dao;

import java.util.ArrayList;

import com.scmaster.ajax1.Comment;

public interface CommentMapper {

	public int insertReply(Comment comment);
	
	public ArrayList<Comment> list();
	
	public int delete(int num);
}
