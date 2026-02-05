package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecordsByPreparedStatements {
	static final String Url = "jdbc:mysql://localhost:3306/java";
	static final String user = "root";
	static final String pass = "ROOT";

	public static void main(String[] args) {
		String sqlQuery = "INSERT INTO employee_info(employee_no, employee_name, employee_sal,employee_add) VALUES (?, ? , ? , ?)";
		try(
				Connection dbConn = DriverManager.getConnection(Url, user, pass);
				PreparedStatement ptStmt = dbConn.prepareStatement(sqlQuery)
						) {
			ptStmt.setInt(1,100);
			ptStmt.setString(2,"Yashu");
			ptStmt.setInt(3,10000);
			ptStmt.setString(4,"Hyderabad");
			
			int noOfRowsAffected = ptStmt.executeUpdate();
			System.out.println(noOfRowsAffected + " Rows Inserted Sucessfully");
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}
