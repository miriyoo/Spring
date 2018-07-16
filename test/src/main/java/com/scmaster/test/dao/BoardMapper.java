package com.scmaster.test.dao;

import java.util.ArrayList;

import com.scmaster.test.vo.Board;
import com.scmaster.test.vo.Reply;

public interface BoardMapper {
	
	//게시글 저장
	public int insertBoard(Board board);
	
	//전체 게시글 가져오기
	public ArrayList<Board> getBoardList();
	
	//특정 게시글 조회
	public Board getBoard(int boardnum);
	
	//글 삭제
	public int deleteBoard(Board board);
	
	//글 수정
	public int updateBoard(Board board);
	
	//리플 등록
	public int insertReply(Reply reply);
	
	//리플 목록 가져오기
	public ArrayList<Reply> listReply(int boardnum);
}
