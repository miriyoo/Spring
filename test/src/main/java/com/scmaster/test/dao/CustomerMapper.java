package com.scmaster.test.dao;

import com.scmaster.test.vo.Customer;

public interface CustomerMapper {
	
	//회원 등록
	public int insertCustomer(Customer customer);
	
	//회원 조회
	public Customer selectOneCustomer(String custid);
	
	//회원 수정
	public int updateCustomer(Customer customer);

}
