package com.scmaster.web3.vo;

public class CartVO {
	
	// 수량
	private int productCount;
	// 전체 금액
	private int productTotal;
	
	private ProductVO product;
	
	
	public CartVO(){
		
	}


	public CartVO(int productCount, ProductVO product) {
		super();
		this.productCount = productCount;
		this.productTotal = product.getProductPrice() * productCount;
		this.product = product; 
	}


	public int getProductCount() {
		return productCount;
	}


	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	public int getProductTotal() {
		return productTotal;
	}


	public void setProductTotal(int productTotal) {
		this.productTotal = productTotal;
	}


	public ProductVO getProduct() {
		return product;
	}


	public void setProduct(ProductVO product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "CartVO [productCount=" + productCount + ", productTotal=" + productTotal + ", product=" + product + "]";
	}
	
	
	
	

	
	
	
}
