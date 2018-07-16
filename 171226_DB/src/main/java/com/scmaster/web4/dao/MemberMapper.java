package com.scmaster.web4.dao;

import java.util.ArrayList;

import com.scmaster.web4.vo.MemberVO;

public interface MemberMapper {
	
	public void insert(MemberVO member);
	
	public ArrayList<MemberVO> getList();
	
	
}
