package com.scmaster.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.test.vo.Customer;

@Repository
public class CustomerDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insertCustomer(Customer customer){
		int result = 0;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			result = mapper.insertCustomer(customer);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Customer selectOneCustomer(String custid){
		Customer customer = null;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			customer = mapper.selectOneCustomer(custid);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	//회원 수정
	public int updateCustomer(Customer customer){
		int result = 0;
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		try{
			result = mapper.updateCustomer(customer);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
