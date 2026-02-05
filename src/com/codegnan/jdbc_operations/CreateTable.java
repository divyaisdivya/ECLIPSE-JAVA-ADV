package com.codegnan.jdbc_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    static final String driverName = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/java";
    static final String username = "root";
    static final String password = "ROOT";

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();

            String sqlQuery =
                    "CREATE TABLE IF NOT EXISTS EMPLOYEE (" +
                    "ENO INT AUTO_INCREMENT PRIMARY KEY, " +
                    "ENAME VARCHAR(100), " +
                    "ESAL DECIMAL(10,2), " +
                    "EADDR VARCHAR(100)" +
                    ")";

            st.execute(sqlQuery);
            System.out.println("Table created successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
