package com.scmaster.web3;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web3.dao.ProductDAO;
import com.scmaster.web3.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO dao;
	
	@RequestMapping(value = "productList", method= RequestMethod.GET)
	public String productList(HttpSession session, Model model){
		
		if (session.getAttribute("loginId") == null) {
			return "loginForm";
		}
		
		ArrayList<ProductVO> productList = dao.selectProductList();
		
		// Model에 넣어주기
		model.addAttribute("productList", productList);
		
		return "productList";
	}
	
	@RequestMapping(value="cart", method= RequestMethod.POST)
	public String cart(String[] prdCheck, HttpSession session){ // 체크박스의 값이 복수이기때문에 스트링 배열을 쓴다.
		// 세션에서 장바구니 객체가 있는지를 판단
		ArrayList<String> cartList = (ArrayList<String>)session.getAttribute("cartList"); 
		// 오브젝트로 반환되기 때문에 형변환이 필요
		
		// 없는 경우
		if (cartList == null) {
			cartList = new ArrayList<>(); // 생성
		}
		
		for (String s : prdCheck) {
			cartList.add(s);
		}
		
		session.setAttribute("cartList", cartList);
		
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
