package com.kedu.common.dao;

public class CommonDao {
	
	public CommonDao() {
	}
	
	private static CommonDao instance = new CommonDao();
	
	public static CommonDao getInstance(){
		return instance;
	}
	
}
