package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecordByPreparedStatement {
	static final String Url = "jdbc:mysql://localhost:3306/java";
	static final String user = "root";
	static final String pass = "ROOT";

	public static void main(String[] args) {
		String sqlQuery = "DELETE FROM employee_info WHERE employee_no = ? ";
		try(
				Connection dbConn = DriverManager.getConnection(Url, user, pass);
				PreparedStatement ptStmt = dbConn.prepareStatement(sqlQuery)
						) {
			ptStmt.setInt(1, 100);
			
			int noOfRowsAffected = ptStmt.executeUpdate();
			if (noOfRowsAffected == 1) {
			System.out.println(" Rows Delete Sucessfully");
			} else {
				System.out.println("Delete Failure");
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

}
