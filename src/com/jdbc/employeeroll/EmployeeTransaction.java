package com.jdbc.employeeroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class EmployeeTransaction {
	public static void main(String[] args)  {
		Connection connection = null;
        PreparedStatement statement = null;
        String query = "Insert into payroll_service.employee_payroll (empId,empName,Salary,StartDate) values(?,?,?,?); ";
        String query2 = "Insert into payroll_service.Employee (empId,empName,gender,StartDate) values(?,?,?,?); ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Brijesh@534");
			System.out.println("connection established");
			statement = connection.prepareStatement(query);
			System.out.println("platform created");
			
			statement.setInt(1,7);
            statement.setString(2,"Manish");
            statement.setDouble(3,20000);
            statement.setDate(4, Date.valueOf(LocalDate.now()));
        
            statement.executeUpdate();
            PreparedStatement statement1 = connection.prepareStatement(query2);
            statement1.setInt(1,7);
            statement1.setString(2,"Ravi");
            statement1.setString(3,"M");
            statement1.setDate(4, Date.valueOf(LocalDate.now()));
        
            statement1.executeUpdate();
            
            System.out.println("data Updated");
		}
		catch(ClassNotFoundException | SQLException ex){
			 ex.printStackTrace();
		}
		finally {
			if(statement != null){
                try{
                    statement.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
			} if(connection != null){
                try{
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
		}
	}
}

