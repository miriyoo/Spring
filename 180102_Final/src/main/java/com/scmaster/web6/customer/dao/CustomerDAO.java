package com.scmaster.web6.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web6.HomeController;
import com.scmaster.web6.customer.vo.Customer;

@Repository
public class CustomerDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//회원 정보 검색
	public Customer searchCustomerOne(String custid){
		logger.info("회원 정보 검색 시작");
		
		Customer customer = null;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			customer = mapper.searchCustomerOne(custid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 검색 종료");
		
		return customer;
	}
	
	//회원 정보 등록
	public int joinCustomer(Customer customer){
		logger.info("회원 정보 등록 시작");
		
		int result = 0;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			result = mapper.joinCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 등록 종료");
		
		return result;
	}
	
	//회원 정보 수정
	public int UpdateCustomer(Customer customer){
		logger.info("회원 정보 수정 시작");
		
		int result = 0;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			result = mapper.UpdateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 수정 종료");
		
		return result;
	}
	
	
	
	
}
