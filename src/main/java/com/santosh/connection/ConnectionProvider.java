package com.santosh.connection;

import com.santosh.operations.CreateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;

public class ConnectionProvider {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/School_Info";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!con.isClosed()) {
                System.out.println("Connection is Created");

                System.out.println("You can do five operations in this software. Like Create, Insert, Update, Select and Delete.");
                System.out.println("These operations is only applicable on MYSQL DB,");
                System.out.println("Enter any operation you want to perform Like 'select'. ");


                Scanner scanner = new Scanner(System.in);
                String operation = scanner.next();
                String query;
                switch (operation) {
                    case "create" -> {
                        query = CreateTable.createTable();
                        System.out.println(query);
                        Statement stmt1 = con.createStatement();
                        stmt1.executeUpdate(query);
                        System.out.println("Tables is created in the DB.");
                    }

                    case "insert" -> {

                    }

                    case "update" -> {

                    }

                    case "select" -> {

                    }

                    case "delete" -> {

                    }

                    default -> {
                        System.out.println("you entered wrong values");
                    }
                }
                con.close();
            } else {
                System.out.println("Connection is closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
