package com.scmaster.project2.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.project2.member.vo.BlogMember;

@Repository
public class MemberDAO {

private static final Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//회원 조회
	public BlogMember searchMemberOne(String id){
		logger.info("회원 조회 시작 - 다오");
		
		BlogMember member = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			member = mapper.searchMemberOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		logger.info("회원 조회 종료 - 다오");
		
		return member;
	}
	
	//회원 등록
	public int joinMember(BlogMember member){
		logger.info("회원 등록 시작 - 다오");
		
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			result = mapper.joinMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 등록 종료 - 다오");
		
		return result;
	}
	
	//회원 정보 수정
	public int updateMember(BlogMember member){
		logger.info("회원 수정 시작 - 다오");
		
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			result = mapper.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 수정 종료 - 다오");
		
		return result;
	}
	
	
	
	
	
	
	
}
