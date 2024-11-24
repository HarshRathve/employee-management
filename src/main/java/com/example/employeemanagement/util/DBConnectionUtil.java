package com.example.employeemanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil
{
	private static final String URL="jdbc:mysql://localhost:3306/employee_db";
	private static final String UserName="root";
	private static final String Passward="root";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(URL,UserName,Passward);
	}

}