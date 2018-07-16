package com.calendar.www.dao;

import java.util.ArrayList;

import com.calendar.www.Calendar;

/**
 * 게시판 관련 Mybatis 사용 메서드
 */
public interface CalendarMapper {
	public int deleteCalendar (Calendar c);
	public int insertCalendar(Calendar calendar);
	public ArrayList<Calendar> selectCalendar(String day);
	
	//업데이트 문
	public int updateCalendar (Calendar c);
	
}
