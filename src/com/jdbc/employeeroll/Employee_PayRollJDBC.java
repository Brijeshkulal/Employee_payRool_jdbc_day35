package com.jdbc.employeeroll;
import java.sql.*;
import java.util.Enumeration;

public class Employee_PayRollJDBC {
	public static void main(String[] args) throws Exception {
		String query= "update payroll_service.employee_payroll set salary =3000000 where empName ='Shreya'";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Brijesh@534");
		System.out.println("connection established");
		Statement statement = con.createStatement();
		System.out.println("platform created");
		int count = statement.executeUpdate(query);
		System.out.println(count + " row/s affected");
		statement.close();
		con.close();
	}
}
