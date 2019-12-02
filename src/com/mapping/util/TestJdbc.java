package com.mapping.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		//String jdbcUrl="jdbc:postgresql://localhost:5432/personal";
		String jdbcUrl="jdbc:postgresql://localhost:5432/personal";
		//String jdbcUrl="jdbc:postgresql://localhost:5432/personal?useSSL=false"; // to bypass SSL warings
		String userName="postgres";
		String passWord="sachin";
		//String passWord="postgress";
		try
		{
			System.err.println("Connecting Data base: "+ jdbcUrl);
			Connection con=DriverManager.getConnection(jdbcUrl, userName, passWord);
			System.err.println("Connection Successful");
		}
		catch (Exception e) {
		System.err.println(e.getMessage());
		}
	}
}
