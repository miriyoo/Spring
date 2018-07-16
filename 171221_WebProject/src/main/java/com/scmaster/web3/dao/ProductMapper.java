package com.scmaster.web3.dao;

import java.util.ArrayList;

import com.scmaster.web3.vo.ProductVO;

public interface ProductMapper {
	
	public ArrayList<ProductVO> selectProductList();
	
}
