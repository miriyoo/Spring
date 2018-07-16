package com.scmaster.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.test.vo.Board;
import com.scmaster.test.vo.Reply;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	//게시글 저장
	public int insertBoard(Board board){
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.insertBoard(board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//전체 게시글 가져오기
	public ArrayList<Board> getBoardList(){
		ArrayList<Board> list = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			list = mapper.getBoardList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//특정 게시글 조회
	public Board getBoard(int boardnum){
		Board board = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			board = mapper.getBoard(boardnum);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	//글 삭제
	public int deleteBoard(Board board){
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.deleteBoard(board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//글 수정
	public int updateBoard(Board board){
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.updateBoard(board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//리플 등록
	public int insertReply(Reply reply){
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.insertReply(reply);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//리플 목록 가져오기
	public ArrayList<Reply> listReply(int boardnum){
		ArrayList<Reply> replyList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			replyList = mapper.listReply(boardnum);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return replyList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
