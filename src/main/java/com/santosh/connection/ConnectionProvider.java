package com.santosh.connection;

import com.santosh.operations.CreateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionProvider {

    public static void stablishConnection() {
        try {
            Class.forName(Data.DRIVER_NAME);
            Connection con = DriverManager.getConnection(Data.URL, Data.USERNAME, Data.PASSWORD);

            if (!con.isClosed()) {
                System.out.println("Connection is Created");
                System.out.println("Enter any operation you want to perform Like 'select'. ");

                Scanner scanner = new Scanner(System.in);
                String op = scanner.next();

                String query = operation(op);
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("Operation is successfully performed.");

                con.close();
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String operation(String op){
        String query = null;
        switch (op) {
            case "create" -> {
                query = CreateTable.createTable();
                System.out.println(query);
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
        return query;
    }
}
