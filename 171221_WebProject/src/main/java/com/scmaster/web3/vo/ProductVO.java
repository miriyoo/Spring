package com.scmaster.web3.vo;

public class ProductVO {
	// 상품번호, 상품명, 가격, 이미지 주소
	private int productNo;
	private String productName;
	private int productPrice;
	private String productImgPath;
	
	public ProductVO(){
		
	}

	public ProductVO(int productNo, String productName, int productPrice, String productImgPath) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImgPath = productImgPath;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImgPath() {
		return productImgPath;
	}

	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}

	@Override
	public String toString() {
		return "ProductVO [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImgPath=" + productImgPath + "]";
	}
	
	
	
	
	
}
