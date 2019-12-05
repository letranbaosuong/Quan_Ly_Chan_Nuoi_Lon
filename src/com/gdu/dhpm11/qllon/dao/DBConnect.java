package com.gdu.dhpm11.qllon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/csdl_lon?useUnicode=true&characterEncoding=UTF-8";
        final String user = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Loi public static Connection getJDBCConnection() {} : " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if (connection != null) {
            System.out.println("Thanh cong");
        } else {
            System.out.println("That bai");
        }
    }
}
