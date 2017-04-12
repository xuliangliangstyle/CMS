package com.xll.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具
 * @author Administrator
 *
 */

public class SelfDateFormat {
	private static final String  DATE_FORMAT="yyyy-MM-dd";
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	public static String dateToString(Date date)
	{		
		return sdf.format(date);
	}
	public static Date stringToDate(String str) throws ParseException
	{		
		return sdf.parse(str);
	}
	

}
