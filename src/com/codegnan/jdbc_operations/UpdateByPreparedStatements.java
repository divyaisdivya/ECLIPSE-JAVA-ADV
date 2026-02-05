package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateByPreparedStatements {
	static final String Url = "jdbc:mysql://localhost:3306/java";
	static final String user = "root";
	static final String pass = "ROOT";

	public static void main(String[] args) {
		String sqlQuery = "UPDATE employee_info set  employee_name =? WHERE employee_no = ? ";
		try(
				Connection dbConn = DriverManager.getConnection(Url, user, pass);
				PreparedStatement ptStmt = dbConn.prepareStatement(sqlQuery)
						) {
			ptStmt.setString(1, "Nithin");
			ptStmt.setInt(2, 100);
			
			int noOfRowsAffected = ptStmt.executeUpdate();
			if (noOfRowsAffected == 1) {
			System.out.println(" Rows Updated Sucessfully");
			} else {
				System.out.println("Updation Failure");
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

}
