package com.scmaster.web6.customer.dao;

import com.scmaster.web6.customer.vo.Customer;

public interface CustomerMapper {
	
	//특정 회원 조회
	public Customer searchCustomerOne(String custid);
	
	//회원정보 등록
	//public void joinCustomer(Customer customer); 기존 방식
	public int joinCustomer(Customer customer); // 새로운 방식
	
	//회원정보 수정
	public int UpdateCustomer(Customer customer);
	
	
}
