package com.scmaster.project2.member.dao;

import com.scmaster.project2.member.vo.BlogMember;

public interface MemberMapper {
	
	//회원 정보 조회
	public BlogMember searchMemberOne(String id);
	
	//회원 등록
	public int joinMember(BlogMember member);
	
	//회원 정보 수정
	public int updateMember(BlogMember member);

}
