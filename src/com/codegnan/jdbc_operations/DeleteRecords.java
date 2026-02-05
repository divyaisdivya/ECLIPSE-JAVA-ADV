package com.codegnan.jdbc_operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecords {
	
	static final String Url = "jdbc:mysql://localhost:3306/java";
	static final String user = "root";
	static final String pass = "ROOT";

	public static void main(String[] args) {
		try(
				Connection dbConn = DriverManager.getConnection(Url, user, pass);
				Statement dbStmt = dbConn.createStatement();
				Scanner sc = new Scanner(System.in)
				)
						{
			System.out.println("Enter the no of Records want to Delete: ");
			int delete = sc.nextInt();
			
			for(int i = 0; i <= delete; i++) {
			System.out.println("Enter the Employee_ID: ");
			int employee_no = sc.nextInt();
			String sqlQuery = "DELETE FROM employee_info WHERE employee_no = " + employee_no;
			int noOfAffected = dbStmt.executeUpdate(sqlQuery);
			if (noOfAffected != 0) {
				System.out.println("Deleted Sucessfully");
			} else {
				System.out.println("Delection Failure");
			}
			}
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}

