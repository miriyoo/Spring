package com.scmaster.project2.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scmaster.project2.board.vo.BlogBoard;
import com.scmaster.project2.board.vo.BlogReply;

public interface BoardMapper {
	
	//게시판 등록
	public int insertBoard(BlogBoard board);
	
	//게시판 목록 불러오기
	public ArrayList<HashMap<String, Object>> selectBoardAll(HashMap<String, Object> searchMap, RowBounds rb);
	
	//특정 게시글 조회
	public BlogBoard selectBoardOne(int boardnum);
	
	//조회 수 증가
	public void updateHits(int boardnum);
	
	//게시글 삭제
	public int deleteBoard(BlogBoard board);
	
	//게시글 수정
	public int reviseOne(BlogBoard board);
	
	//전체 글 개수
	public int getTotal(HashMap<String, Object> searchMap);
	
	//리플 등록
	public int insertReply(BlogReply reply);
	
	//리플 목록 가져오기
	public ArrayList<BlogReply> selectReplyAll(int boardnum);
	
	//리플 삭제
	public int deleteReply(BlogReply reply);
	
	//리플 수정
	public int replyUpdate(BlogReply reply);
	
	//조회 수 상위 3개 컨텐츠 가져오기
	public ArrayList<BlogBoard> selectBoardAllHits();
	
	//게시글 별 리플 댓글 수 가져오기
	public int getReplyTotal(int boardnum);
	
	
	
	
	
	
	

}
