package com.scmaster.web5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web5.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public void insertBoard(BoardVO board){
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardVO> getBoardList(){
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardVO> list = null;
		
		try{
			list = mapper.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean deleteBoard(int boardNo, String boardPassword){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("boardNo", boardNo);
		map.put("boardPassword", boardPassword);
		
		int result = mapper.deleteBoard(map); // 횟수를 알기 위해서
		
		if(result == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updateBoard(BoardVO board){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoardVO selectOne(int boardNo){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO vo = null;
		
		try{
			vo = mapper.selectOne(boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return vo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}














