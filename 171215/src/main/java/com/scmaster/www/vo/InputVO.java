package com.scmaster.www.vo;

import java.util.Arrays;

public class InputVO {
	 String text;
	 String password;
	 String radio;
	 String[] checkbox;
	 String hidden;
	
	public InputVO() {
		super();
	}

	public InputVO(String text, String password, String radio, String[] checkbox, String hidden) {
		super();
		this.text = text;
		this.password = password;
		this.radio = radio;
		this.checkbox = checkbox;
		this.hidden = hidden;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	@Override
	public String toString() {
		return "InputVO [text=" + text + ", password=" + password + ", radio=" + radio + ", checkbox="
				+ Arrays.toString(checkbox) + ", hidden=" + hidden + "]";
	}
	
	
	
	 
	 
}
