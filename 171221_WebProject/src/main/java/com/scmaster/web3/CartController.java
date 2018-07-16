package com.scmaster.web3;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web3.vo.ProductVO;

@Controller
public class CartController {
	
	@RequestMapping(value="showCartList", method=RequestMethod.GET)
	public String showCartList(HttpSession session, Model model){
		
		//로그인한 사람만 장바구니 목록을 볼 수 있도록 처리
		if (session.getAttribute("loginId") == null) {
			return "loginForm";
		}
		
		//세션에 있는 장바구니 개수를 가져옴
		ArrayList<String> cartList = (ArrayList<String>)session.getAttribute("cartList"); 
		
		//ProductVO를 담는 ArrayList
		ArrayList<ProductVO> productList2 = productList();
		
		//선택한 항목을 넣는 ArrayList
		ArrayList<ProductVO> showList1 = new ArrayList<>();
		
		for (int i = 0; i < cartList.size(); i++) {
			for (int j = 0; j < productList2.size(); j++) {
				if (cartList.get(i).equals(productList2.get(j).getProductNo() + "")) {
					showList1.add(productList2.get(j));
				}
			}
		}
		
		model.addAttribute("showCartList1", showList1);
		
		return "showCartList";
	}
	
	private ArrayList<ProductVO> productList(){
		ArrayList<ProductVO> productList = new ArrayList<>();
		
		// 직접 데이터를 넣기
		ProductVO vo1 = new ProductVO();
		vo1.setProductNo(1);
		vo1.setProductName("치킨");
		vo1.setProductPrice(20000);
		vo1.setProductImgPath("/resources/image/1.jpg"); // 코어 태그안에 url의 value값에 들어가게 된다.
		
		ProductVO vo2 = new ProductVO();
		vo2.setProductNo(2);
		vo2.setProductName("피자");
		vo2.setProductPrice(30000);
		vo2.setProductImgPath("/resources/image/2.jpg"); 
		
		ProductVO vo3 = new ProductVO();
		vo3.setProductNo(3);
		vo3.setProductName("햄버거");
		vo3.setProductPrice(8000);
		vo3.setProductImgPath("/resources/image/3.jpg"); 
		
		ProductVO vo4 = new ProductVO();
		vo4.setProductNo(4);
		vo4.setProductName("삼겹살");
		vo4.setProductPrice(40000);
		vo4.setProductImgPath("/resources/image/4.jpg"); 
		
		// ArrayList에 추가
		productList.add(vo1);
		productList.add(vo2);
		productList.add(vo3);
		productList.add(vo4);
		
		return productList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
