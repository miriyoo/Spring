package com.scmaster.web3.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web3.vo.ProductVO;

@Repository
public class ProductDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public ArrayList<ProductVO> selectProductList(){
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		ArrayList<ProductVO> list = null;
		
		try{
			list = mapper.selectProductList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
