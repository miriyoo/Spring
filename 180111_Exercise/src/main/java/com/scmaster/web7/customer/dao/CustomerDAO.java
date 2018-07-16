package com.scmaster.web7.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web7.HomeController;
import com.scmaster.web7.customer.vo.Customer1;

@Repository
public class CustomerDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	
	public Customer1 searchCustomerOne(String custid){
		
		logger.info("회원 정보 검색 시작");
		
		Customer1 customer = null;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			customer = mapper.searchCustomerOne(custid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 검색 종료");
		
		return customer;
	}
	
	//회원등록
	public int joinCustomer(Customer1 customer){
		logger.info("회원 등록 시작");
		
		int result = 0;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			result = mapper.joinCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("회원 등록 종료");
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
