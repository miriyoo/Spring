package com.scmaster.web6.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.scmaster.web6.board.vo.Board;
import com.scmaster.web6.board.vo.Reply;

@Repository
public class BoardDAO {
	
private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//게시판 글 등록
	public int insertBoard(Board board){
		logger.info("게시판 글 등록 시작");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("게시판 글 등록 종료");
		
		return result;
	}
	
	//게시판 전체 글 가져오기
	public ArrayList<Board> selectBoardAll(HashMap<String, Object> searchMap, int startRecord, int countPerPage){
		logger.info("게시판 전체 글 가져오기 시작");
		
		ArrayList<Board> list = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		//전체 검색 결과 중 읽을 시작위치와 개수
		RowBounds rb = new RowBounds(startRecord,countPerPage);
		
		try{
			list = mapper.selectBoardAll(searchMap, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("게시판 전체 글 가져오기 종료");
		
		return list;
	}
	
	//특정 글 가져오기
	public Board selectBoardOne(int boardnum){
		logger.info("특정 글 가져오기 시작");
		
		Board board = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.updateHits(boardnum);
			board = mapper.selectBoardOne(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("특정 글 가져오기 종료");
		
		return board;
	}
	
	//게시글 삭제
	public int deleteBoard(Board board){
		logger.info("게시글 삭제 시작");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("게시글 삭제 종료");
		
		return result;
	}
	
	//게시글 수정
	public int reviseOne(Board board){
		logger.info("게시글 수정 시작");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.reviseOne(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("게시글 수정 종료");
		
		return result;
	}
	
	//전체 글 개수 조회
	public int getTotal(HashMap<String, Object> searchMap){
		logger.info("전체 글 개수 시작");
		
		int total = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			total = mapper.getTotal(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("전체 글 개수 종료");
		
		return total;
	}
	
	//리플 등록
	public int insertReply(Reply reply){
		logger.info("리플 등록 시작");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("리플 등록 종료");
		
		return result;
	}
	
	//리플 목록 가져오기
	public ArrayList<Reply> selectReplyAll(int boardnum){
		logger.info("리플 전체 목록 가져오기 시작");
		
		ArrayList<Reply> replyList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			replyList = mapper.selectReplyAll(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("리플 전체 목록 가져오기 종료");
		
		return replyList;
	}
	
	//리플 삭제
	public int deleteReply(Reply reply){
		logger.info("리플 삭제 시작");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.deleteReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 삭제 종료");
		
		return result;
	}
	
	public int replyUpdate(Reply reply){
		logger.info("리플 수정 시작");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.replyUpdate(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 수정 종료");
		
		return result;
	}
	
	

		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
