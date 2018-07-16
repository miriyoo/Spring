package com.scmaster.ajax1.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.ajax1.Comment;

@Repository
public class CommentDAO {
	
private static final Logger logger = LoggerFactory.getLogger(CommentDAO.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//게시판 글 등록
	public int insertReply(Comment comment){
		logger.info("게시판 글 등록 시작");
		
		int result = 0;
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		
		try{
			result = mapper.insertReply(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("게시판 글 등록 종료");
		
		return result;
	}
	
	//리플 출력
	public ArrayList<Comment> list(){
		logger.info("리플 글 출력 시작");
		
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		ArrayList<Comment> list = null;
		
		try{
			list = mapper.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 글 출력 종료");
		
		return list;
	}
	
	//리플 삭제
	public int delete(int num){
		logger.info("게시판 글 삭제 시작");
		
		int result = 0;
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		
		try{
			result = mapper.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("게시판 글 삭제 종료");
		
		return result;
	}
	
	
	
}
