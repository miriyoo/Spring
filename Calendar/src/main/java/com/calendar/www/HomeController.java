package com.calendar.www;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calendar.www.dao.CalendarDAO;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CalendarDAO dao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "insertCalendar", method = RequestMethod.POST)
	public String insertCalendar(Calendar calendar) {
		
		int result = dao.insertCalendar(calendar);
		
		ArrayList<Calendar> list = dao.selectCalendar(calendar.getDay());
		
		Gson gson = new Gson();
		
		String result1 = gson.toJson(list);
		logger.debug(result1);
		return result1;
	}
	
	@ResponseBody
	@RequestMapping(value = "selectCalendar", method = RequestMethod.POST)
	public String selectCalendar(Calendar calendar) {
		
		ArrayList<Calendar> view = dao.selectCalendar(calendar.getDay());
		
		Gson gson = new Gson();
		
		String calendarList = gson.toJson(view);
		logger.info("result : " + calendarList);
		return calendarList;
	}
	
	@ResponseBody
	@RequestMapping(value ="deleteCalendar", method = RequestMethod.POST)
	public String deleteCalendar (Calendar c){
		
		String result = "";
		int check = 0;
		check = dao.deleteCalrendar(c);
		if (check == 1) {
			result = "Complete";
		}
		else {
			result = "fail";
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value ="updateCalendar", method = RequestMethod.POST)
	public String updateCalendar (Calendar c){
		
		String result = "";
		int check = 0;
		check = dao.updateCalrendar(c);
		if (check == 1) {
			result = "Complete";
		}
		else {
			result = "fail";
		}
		return result;
	}
}
