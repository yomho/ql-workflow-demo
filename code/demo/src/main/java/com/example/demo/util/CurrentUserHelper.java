package com.example.demo.util;

public class CurrentUserHelper {
	static String current_user_id;
	static String current_user_name;
	public static String getCurrent_user_id() {
		return current_user_id;
	}
	public static void setCurrent_user_id(String current_user_id) {
		CurrentUserHelper.current_user_id = current_user_id;
	}
	public static String getCurrent_user_name() {
		return current_user_name;
	}
	public static void setCurrent_user_name(String current_user_name) {
		CurrentUserHelper.current_user_name = current_user_name;
	}
}
