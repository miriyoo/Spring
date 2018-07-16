package com.scmaster.www.vo;

public class RateVO {
	String hidden;
	int won;
	String country;
	
	public RateVO(){
		
	}

	public RateVO(String hidden, int won, String country) {
		super();
		this.hidden = hidden;
		this.won = won;
		this.country = country;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "RateVO [hidden=" + hidden + ", won=" + won + ", country=" + country + "]";
	}
	
	
}
