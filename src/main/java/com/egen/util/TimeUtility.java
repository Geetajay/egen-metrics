package com.egen.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtility {
	 public static String dateFormat = "yyyy-MM-dd hh:mm:ss";
	    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

	    public static Timestamp ConvertMilliSecondsToFormattedDate(String milliSeconds){
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(Long.parseLong(milliSeconds));
	        System.out.println("date time-- " + calendar.getTime());
	        String timestampFormat = simpleDateFormat.format(calendar.getTime());
	        Timestamp ts = Timestamp.valueOf(timestampFormat);
	        return ts;
	    }
}
