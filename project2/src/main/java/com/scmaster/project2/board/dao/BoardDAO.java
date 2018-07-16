package com.scmaster.project2.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.project2.board.vo.BlogBoard;
import com.scmaster.project2.board.vo.BlogReply;
import com.scmaster.project2.member.dao.MemberMapper;
import com.scmaster.project2.member.vo.BlogMember;


@Repository
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//게시판 등록
	public int insertBoard(BlogBoard board){
		logger.info("게시판 등록 시작 - 다오");
			
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			
		try{
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("게시판 등록 종료 - 다오");
		
		return result;
	}
	
	//게시판 전체 목록 가져오기
	public ArrayList<HashMap<String, Object>> selectBoardAll(HashMap<String, Object> searchMap, int startRecord, int countPerPage){
		logger.info("게시판 전체 목록 가져오기 시작 - 다오");
		
		ArrayList<HashMap<String, Object>> board = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		
		try{
			board = mapper.selectBoardAll(searchMap, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("게시판 전체 목록 가져오기 종료 - 다오");
		
		return board;
	}
	
	//특정 게시글 조회
	public BlogBoard selectBoardOne(int boardnum){
		logger.info("특정 게시글 조회 시작 - 다오");
		
		BlogBoard board = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.updateHits(boardnum); //조회 수 증가
			board = mapper.selectBoardOne(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("특정 게시글 조회 종료 - 다오");
		
		return board;
	}
	
	//게시글 삭제
	public int deleteBoard(BlogBoard board){
		logger.info("게시글 삭제 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			
		try{
			result = mapper.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("게시글 삭제 시작 - 다오");
		
		return result;
	}
	
	//게시글 수정
	public int reviseOne(BlogBoard board){
		logger.info("게시글 수정 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			
		try{
			result = mapper.reviseOne(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("게시글 수정 종료 - 다오");
		
		return result;
	}
	
	//전체 글 개수
	public int getTotal(HashMap<String, Object> searchMap){
		logger.info("전체 글 개수 가져오기 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.getTotal(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("전체 글 개수 가져오기 종료 - 다오");
		
		return result;
	}
	
	//리플 등록
	public int insertReply(BlogReply reply){
		logger.info("리플 등록 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 등록 종료 - 다오");
		
		return result;
	}
	
	//리플 목록 가져오기
	public ArrayList<BlogReply> selectReplyAll(int boardnum){
		logger.info("리플 목록 가져오기 시작 - 다오");
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BlogReply> reply = null;
		
		try{
			reply = mapper.selectReplyAll(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 목록 가져오기 종료 - 다오");
		
		return reply;
	}
	
	//리플 삭제
	public int deleteReply(BlogReply reply){
		logger.info("리플 삭제 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.deleteReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 삭제 종료 - 다오");
		
		return result;
	}
	
	//리플 수정
	public int replyUpdate(BlogReply reply){
		logger.info("리플 수정 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.replyUpdate(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리플 수정 종료 - 다오");
		
		return result;
	}
	
	//조회 수 상위 3개 컨텐츠 가져오기
	public ArrayList<BlogBoard> selectBoardAllHits(){
		logger.info("조회 수 상위 3개 컨텐츠 가져오기 시작 - 다오");
		
		ArrayList<BlogBoard> list = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			list = mapper.selectBoardAllHits();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("조회 수 상위 3개 컨텐츠 가져오기 시작 - 다오");
		
		return list;
	}
	
	//게시글 별 리플 댓글 수 가져오기
	public int getReplyTotal(int boardnum){
		logger.info("게시글 별 리플 댓글 수 가져오기 시작 - 다오");
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			result = mapper.getReplyTotal(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("게시글 별 리플 댓글 수 가져오기 종료 - 다오");
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
