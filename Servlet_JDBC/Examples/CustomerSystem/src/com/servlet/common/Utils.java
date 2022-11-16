package com.servlet.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String convertMaleTo0(String sex) throws Exception {
		String result = "";
		try {
			if (sex.equals("Male")) {
				result = "0";
			} else if (sex.equals("Female")) {
				result = "1";
			} else {
				result = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String convert0ToMale(String sex) throws Exception {
		String result = "";
		try {
			if (sex.equals("0")) {
				result = "Male";
			} else if (sex.equals("1")) {
				result = "Female";
			} else {
				result = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getCurrentDateTime() throws Exception {
		String result = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			result = dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
