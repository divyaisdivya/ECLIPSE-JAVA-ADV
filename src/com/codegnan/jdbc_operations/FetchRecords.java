package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecords {

	 static final String JDBC_URL = "jdbc:mysql://localhost:3306/java";
	    static final String USERNAME = "root";
	    static final String PASSWORD = "ROOT";

	    public static void main(String[] args) {
	    	String sqlQuery = "SELECT*FROM employee_info";

	        try (
	            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	            Statement statement = connection.createStatement();
	            	ResultSet resultSet = statement.executeQuery(sqlQuery)){
	        	System.out.println("Employee_NO\tEmployee_NAME\tEmployee_SAL\tEmployee_ADD");
	        	System.out.println("=========================");
	        	while(resultSet.next()) {
	        		int employee_no = resultSet.getInt(1);
	        		String employee_name = resultSet.getString(2);
	        	    double employee_sal = resultSet.getDouble(3);
	        		String employee_add = resultSet.getString(4);
	        		System.out.println(employee_no+"\t"+employee_name+"\t"+employee_sal+"\t"+employee_add);
	        	}

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}


