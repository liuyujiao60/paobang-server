package com.server.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat yyyy_MM_dd_Formatter = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat yyyy_MM_dd_HH_mm_ss_Formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getStringDateByDate(Date date) {
		String datestr = null;
		
		try {
			datestr = yyyy_MM_dd_HH_mm_ss_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}
	
	public static String getStringDayByDate(Date date) {
		String datestr = null;
		
		try {
			datestr = yyyy_MM_dd_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getStringDayByDate   ");
		}
		return datestr;
	}
	
	public static String getStringDateByStringDate(String time) {
		Date date = getDateByString(time);
		String datestr = null;
		try {
			datestr = yyyy_MM_dd_HH_mm_ss_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}
	
	public static Date getDateByString(String time) {
		Date date = null;
		try {
			date = yyyy_MM_dd_HH_mm_ss_Formatter.parse(time);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return date;
	}

}
