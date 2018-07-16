package com.calendar.www.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calendar.www.Calendar;

/**
 * 게시판 관련 DAO
 */
@Repository
public class CalendarDAO {
	@Autowired
	SqlSession sqlSession;
	
	
	public int insertCalendar(Calendar calendar) {
		CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertCalendar(calendar);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Calendar> selectCalendar(String day){
		ArrayList<Calendar> result = new ArrayList<>();
		CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
		
		try{
			result = mapper.selectCalendar(day);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteCalrendar (Calendar c) {
		int result = 0;
		CalendarMapper cm = sqlSession.getMapper(CalendarMapper.class);
		try {
			
			result = cm.deleteCalendar(c);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public int updateCalrendar (Calendar c) {
		int result = 0;
		CalendarMapper cm = sqlSession.getMapper(CalendarMapper.class);
		try {
			
			result = cm.updateCalendar(c);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
