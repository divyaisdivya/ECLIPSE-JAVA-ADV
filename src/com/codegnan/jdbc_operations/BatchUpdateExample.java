package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class BatchUpdateExample {
    private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String user = "root";
	private static final String pass = "ROOT";

	public static void main(String[] args) {
		try(
				Connection dbConn = DriverManager.getConnection(url, user, pass);
				Statement dbStmt = dbConn.createStatement()) {
			String sqlQuery = "INSERT INTO employee VALUES (555, 'Nithin','Developer',60000)";
			String upateQuery = "UPDATE employee set salary = salary + 10000 WHERE salary < 90000";
			
			dbStmt.addBatch(sqlQuery);
			dbStmt.addBatch(upateQuery);
			
			int[] results = dbStmt.executeBatch();
			int totalResult = 0;
			
			for(int count : results) {
				totalResult += count;
			}
			System.out.println("Rows affected with Batch" + totalResult);
			
			String deleteQuery = "DELETE FROM employee where salary > ?";
			try (PreparedStatement ptStmt = dbConn.prepareStatement(deleteQuery)){
				ptStmt.setDouble(1, 90000);
				ptStmt.addBatch();
				ptStmt.setDouble(1, 50000);
				ptStmt.addBatch();
				
				int[] stmtresults = ptStmt.executeBatch();
				int result = 0;
				
				for(int count : stmtresults) {
					result += count;
				}
				System.out.println("Rows Affected with batch " + result);
				
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

}
