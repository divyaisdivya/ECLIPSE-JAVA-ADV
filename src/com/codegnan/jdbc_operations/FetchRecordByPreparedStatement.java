package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchRecordByPreparedStatement {
	static final String Url = "jdbc:mysql://localhost:3306/java";
	static final String user = "root";
	static final String pass = "ROOT";

	public static void main(String[] args) {
		String sqlQuery = "SELECT * FROM employee_info WHERE employee_no = ?";
		
		try(
				Connection dbConn = DriverManager.getConnection(Url, user, pass);
				PreparedStatement ptStmt = dbConn.prepareStatement(sqlQuery)
				) {
			ptStmt.setInt(1,104);
			ResultSet resultset = ptStmt.executeQuery();
			if(resultset.next()) {
				System.out.println("Employee Details");
				System.out.println("Employee Number: " + resultset.getInt(1));
				System.out.println("Employee Name: " + resultset.getString(2));
				System.out.println("Employee Salary " + resultset.getInt(3));
				System.out.println("Employee Address " + resultset.getString(4));
			} else {
				System.out.println("NO record");
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}
