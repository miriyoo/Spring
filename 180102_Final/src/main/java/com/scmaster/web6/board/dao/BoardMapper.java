package com.scmaster.web6.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scmaster.web6.board.vo.Board;
import com.scmaster.web6.board.vo.Reply;

public interface BoardMapper {
	
	//글 등록
	public int insertBoard(Board board);
	
	//글 목록 가져오기
	public ArrayList<Board> selectBoardAll(HashMap<String, Object> searchMap, RowBounds rb);
	
	//특정 글 가져오기
	public Board selectBoardOne(int boardnum);
	
	//조회 수 증가
	public void updateHits(int boardnum);
	
	//게시글 삭제
	public int deleteBoard(Board board);
	
	//게시글 수정
	public int reviseOne(Board board);
	
	//전체 글 개수 조회
	public int getTotal(HashMap<String, Object> searchMap);
	
	//리플 등록
	public int insertReply(Reply reply);
	
	//리플 목록 가져오기
	public ArrayList<Reply> selectReplyAll(int boardnum);
	
	//리플 삭제
	public int deleteReply(Reply reply);
	
	//리플 수정
	public int replyUpdate(Reply reply);
	
	
	
	
	
	
	
	
}
