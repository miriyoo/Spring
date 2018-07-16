package com.scmaster.web7.customer.dao;

import com.scmaster.web7.customer.vo.Customer1;

public interface CustomerMapper {
	
	//특정회원 조회
	public Customer1 searchCustomerOne(String custid);
	
	//회원 등록
	public int joinCustomer(Customer1 customer);

}
