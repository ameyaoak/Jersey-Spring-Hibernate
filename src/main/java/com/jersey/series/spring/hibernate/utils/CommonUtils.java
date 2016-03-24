package com.jersey.series.spring.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CommonUtils {
	
	public static DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
	public static SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
 
	 
	public static DateTime newDateTime() {
		  return new DateTime(); 
		}
	
	public static String formatDateTime(DateTime inUTCDate) {  
		  return inUTCDate.toString(fmt);
		}

	public static String formatDate(Date inUTCDate) {  
		  return sdf.format(inUTCDate);
		}
	
	public static Date unformatDate(String inUTCDate) throws ParseException {  
		  return sdf.parse(inUTCDate);
		}
}
