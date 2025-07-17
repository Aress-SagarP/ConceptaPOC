package Wrappers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebCurrentTime {
	
	public static int getcurrenttime() {
		long currentDateMS = new Date().getTime();
		int seconds = (int) ((currentDateMS / 1000) % 3600);
		return seconds;
	}

	public static String getCurrentDateTimeFormat() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}
	
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("mm_dd_yyyy");
		return sdf.format(date);
	}
	
	public static String getCurrentDateWithMinute() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
		return sdf.format(date);
	}
	
	public static String getCurrentTimeFormat() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		return sdf.format(date);
	}
	
	public static String getCurrentTimeWithAdditionalMints() {
		 Date date = new Date();
		 Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MINUTE, 0);
	        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
	        return sdf.format(calendar.getTime());
	}
}
