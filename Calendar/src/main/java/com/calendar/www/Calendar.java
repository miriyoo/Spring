package com.calendar.www;

public class Calendar {
	private int calendarno;
	private String day;
	private String title;
	private String address;
	private String detail;
	private String setTime;
	
	public Calendar() {
		super();
	}

	public Calendar(int calendarno, String day, String title, String address, String detail, String setTime) {
		super();
		this.calendarno = calendarno;
		this.day = day;
		this.title = title;
		this.address = address;
		this.detail = detail;
		this.setTime = setTime;
	}
	

	public int getCalendarno() {
		return calendarno;
	}

	public void setCalendarno(int calendarno) {
		this.calendarno = calendarno;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSetTime() {
		return setTime;
	}

	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}

	@Override
	public String toString() {
		return "Calendar [day=" + day + ", title=" + title + ", address=" + address + ", detail=" + detail
				+ ", setTime=" + setTime + "]";
	}

	
	
}
