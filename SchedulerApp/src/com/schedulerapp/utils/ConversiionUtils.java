package com.schedulerapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;

public class ConversiionUtils {

	@SuppressLint("SimpleDateFormat")
	public static Date getDateFromString(String str) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
		Date date = (Date) formatter.parse(str);
		return date;
	}
		
}
