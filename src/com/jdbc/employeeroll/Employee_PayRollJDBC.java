package com.jdbc.employeeroll;
import java.sql.*;
import java.util.Enumeration;

public class Employee_PayRollJDBC {
	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("cannot find the driver" + e);
	}
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Brijesh@534");
		System.out.println("connection established");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	private static void listDrivers() {
		  Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		  while (driverList.hasMoreElements()) {
			  Driver driverClass =(Driver) driverList.nextElement();
			  System.out.println("  "+driverClass.getClass().getName());
		  }
	  } 
}
