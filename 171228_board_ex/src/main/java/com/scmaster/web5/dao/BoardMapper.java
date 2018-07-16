package com.scmaster.web5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scmaster.web5.vo.BoardVO;

public interface BoardMapper {
	
	//게시판 글 저장
	public void insertBoard(BoardVO board);
	
	//전체 글 정보
	public ArrayList<BoardVO> getBoardList();
	
	//번호와 비밀번호로 해당 글 삭제 (Map)
	public int deleteBoard(Map map); // 횟수 파악하기 위해 int로 데이터 타입 설정
	
	public void updateBoard(BoardVO board);
	
	public BoardVO selectOne(int boardNo);
	
	
	
}
