package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertingDynamically {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/java";
	static final String USERNAME = "root";
	static final String PASSWORD = "ROOT";


	public static void main(String[] args) {
		 try (
		            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		            Statement statement = connection.createStatement();
		            		Scanner sc = new Scanner(System.in)
		        ) {
			 System.out.print("Enter number of records: ");
			 int numberOfRecords = sc.nextInt();
			 for(int i = 0; i<numberOfRecords; i++) {
				 System.out.println("Enter Details of Records");
			 System.out.println("Enter Employee Number: ");
			 int number = sc.nextInt();
			 System.out.println("Enter Employee Name: ");
			 String name = sc.next();
			 System.out.println("Enter Employee Salary: ");
			 double salary = sc.nextDouble();
			 System.out.println("Enter Employee Address: ");
			 String address = sc.next();
			 
			 String sqlQuery = "INSERT INTO employee_info(employee_no,employee_name,employee_sal,employee_add) values("
				        + number + ",'" + name + "'," + salary + ",'" + address + "')";
			 
			 int rowsAffected = statement.executeUpdate(sqlQuery);
			 if(rowsAffected==1) {
				 System.out.println(rowsAffected+"Record inserted successfully");
			 } else {
				 System.out.println("Record insertion failure");
			 }		  
		 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }

	}

}

