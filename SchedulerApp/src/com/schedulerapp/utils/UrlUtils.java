package com.schedulerapp.utils;

public class UrlUtils {
	
	public static String BASE_URL 		= "http://ec2-54-227-209-145.compute-1.amazonaws.com:8080/Scheduler";
	//public static String BASE_URL 		= "http://10.0.2.2:8080/Scheduler";
	public static String GET_CAMPUS 	= "/api/getCampusByClient/";
	public static String GET_DEPARTMENT = "/api/getDepartmentByCampus/";
	public static String GET_TIME_SLOT 	= "/api/getDepartmentTimeslot/";
	public static String GET_APPOINTMENTS 	= "/appointment/mobileview/";
	public static String SAVE_APPOINTMENT 	= "/api/saveappointment/";
	public static String USER_AUTHENTICATE 	= "/api/authenticate/";
	public static String GET_CATEGORIES 	= "/api/getCategories";
	public static String GET_FAQS 	= "/api/getFaqsByCategories/";
	public static String GET_NOTIFICATIONS 	= "/api/getnotifications/";
	public static String GET_ANNOUNCEMENTS 	= "/api/getannouncement/";

}
