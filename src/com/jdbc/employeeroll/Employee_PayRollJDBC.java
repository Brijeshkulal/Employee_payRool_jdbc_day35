package com.jdbc.employeeroll;
import java.sql.*;

public class Employee_PayRollJDBC {
	
	public static void main(String[] args)  {
		Connection connection = null;
        PreparedStatement statement = null;
		String query= "update payroll_service.employee_payroll where empName ='Dashwath'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Brijesh@534");
			System.out.println("connection established");
			statement = con.prepareStatement(query);
			System.out.println("platform created");
			statement.setFloat(3, (float) 3000000.00);
			int count = statement.executeUpdate(query);
			System.out.println(count + " row/s affected");
		}
		catch(ClassNotFoundException | SQLException ex){
			((Throwable) ex).printStackTrace();
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
