package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValues {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/java";
    static final String USERNAME = "root";
    static final String PASSWORD = "ROOT";

    public static void main(String[] args) {

        try (
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()
        ) {

            String sqlQuery =
                "INSERT INTO employee_info(employee_no, employee_name, employee_sal, employee_add) " +
                "VALUES (105, 'yashu', 60000, 'hyd')";

            int rowsAffected = statement.executeUpdate(sqlQuery);

            if (rowsAffected == 1) {
                System.out.println("Inserted successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Error while inserting data into table.");
            e.printStackTrace();
        }
    }
}

