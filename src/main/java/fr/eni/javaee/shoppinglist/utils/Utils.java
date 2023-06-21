package fr.eni.javaee.shoppinglist.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Utils {

	public static final String DATE_FORMAT_DISPLAY = "JJ/MM/AAAA";
	public static final String DATE_FORMAT_INSERT = "JJ/MM/AAAA";
	public static final String TIME_FORMAT = "HH:MM";
	
    public static final String SPACE = " ";
    public static final String DASH_SEPARATOR = " - ";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String BRACKET_OPENING = "[";
    public static final String BRACKET_CLOSING = "]";
    public static final String WARNING_SIGN = "/!\\";
    public static final String NEWLINE = "\n";
    public static final String HOUR_DISPLAY_PATTERN = "HH:mm";
    public static final double KM_TO_MILES_RATIO = 0.62137;
    
    // BEGIN COLOR SLABS
    /* Liste des couleurs pour la console au cas où*/
	public static final String ANSI_RESET = "\u001B[0m";
	
    public static final String ANSI_BLACK = "\033[1;30m";  // BLACK
    public static final String ANSI_RED = "\033[1;31m";    // RED
    public static final String ANSI_GREEN = "\033[1;32m";  // GREEN
    public static final String ANSI_YELLOW = "\033[1;33m"; // YELLOW
    public static final String ANSI_BLUE = "\033[1;34m";   // BLUE
    public static final String ANSI_PURPLE = "\033[1;35m"; // PURPLE
    public static final String ANSI_CYAN = "\033[1;36m";   // CYAN
    public static final String ANSI_WHITE = "\033[1;37m";  // WHITE
    // END COLOR SLABS
    
    public static double convertToMiles(double distance) {
        double result = -1;

        result = distance*KM_TO_MILES_RATIO;

        return result;
    }

    public static double convertToKm(double distance) {
        double result = -1;

        result = distance/KM_TO_MILES_RATIO;

        return result;
    }
    
    public static String getFormattedDateForDisplay(String date) {
		int year = 0;
		int month = 0;
		int day = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT_DISPLAY); 
		
		String[] dateTab = date.split("-");
		if (dateTab.length == 3) {
			year = Integer.parseInt(dateTab[0]);
			month = Integer.parseInt(dateTab[1]);
			day = Integer.parseInt(dateTab[2]);
			
		} else {
			// throw new 
		}
		
		return dtf.format(LocalDate.of(year, month, day));
	}
	
	public static String getFormattedDateForDisplay(LocalDate date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT_DISPLAY);
		return dtf.format(LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
	}
	
	public static String getFormattedDateForInsert(String date) {
		int year = 0;
		int month = 0;
		int day = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT_INSERT); 
		
		String[] dateTab = date.split("-");
		if (dateTab.length == 3) {
			year = Integer.parseInt(dateTab[0]);
			month = Integer.parseInt(dateTab[1]);
			day = Integer.parseInt(dateTab[2]);
			
		} else {
			// throw new 
		}
		
		return dtf.format(LocalDate.of(year, month, day));
	}
	
	/*
	public static Date getFormattedDateForInsert(String date) {
		
	}
	*/
	
	public static String getFormattedTime(LocalTime time) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(TIME_FORMAT);
		return dtf.format(LocalTime.of(time.getHour(), time.getMinute()));
	}
	
	public static String getFormattedTime(String time) {
		int hour = 0;
		int minute = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(TIME_FORMAT);
		
		String[] dateTab = time.split("-");
		if (dateTab.length == 2) {
			hour = Integer.parseInt(dateTab[0]);
			minute = Integer.parseInt(dateTab[1]);
		} else {
			// throw new 
		}
		
		return dtf.format(LocalTime.of(hour, minute));
	}
	
	public static HashMap<String, Cookie> cookiesTabToHashMap(Cookie[] pCookies) {
		HashMap<String, Cookie> result = new HashMap<String, Cookie>();
		if(pCookies != null) {
			for (Cookie cookie : pCookies) {
				result.put(cookie.getName(), cookie);
			}
		}
		return result;
	}
	
	public static void putAllCookiesInResponse(HttpServletResponse response, HashMap<String, Cookie> cookiesMap) {
		if(cookiesMap != null && !cookiesMap.isEmpty())
		cookiesMap.forEach((key, value) -> {
	      response.addCookie(value);
	    });
	}
	
	public static void putAllCookiesInRequest(HttpServletRequest request, HashMap<String, Cookie> cookiesMap) {
		if(cookiesMap != null && !cookiesMap.isEmpty())
		cookiesMap.forEach((key, value) -> {
			request.setAttribute(key, value);
	    });
	}
}