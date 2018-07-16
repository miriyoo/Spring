package com.scmaster.web3.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web3.vo.UserVO;

@Repository
public class UserDAO {
	// SqlSession은 이미 root-context.xml에서 만들었기 때문에 스프링에서 요청만 하면 된다.
	
	@Autowired
	SqlSession sqlSession;
	
	public UserVO selectMemberOne(String id){
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserVO vo = null;
		
		try{
			vo = mapper.selectMemberOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
}
