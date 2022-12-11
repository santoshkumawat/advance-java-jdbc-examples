package com.santosh.operations;

import java.sql.*;
import java.util.Scanner;

public class OperationPerformer {

    static Scanner scanner = new Scanner(System.in);
    public static void operation(String op, Connection con) throws SQLException {
        System.out.println("Enter table name which you want to perform operations on that. Note: Do not give any space in between table name.");
        String tableName = scanner.next();
        String query = null;
        Statement stmt = null;
        ResultSet rs = null;
        switch (op) {
            case "create" -> {
                query = CreateTable.createTable(tableName);
                stmt = con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("Table is created.");
            }

            case "insert" -> {
                String selectData = SelectTable.selectTable(tableName);
                stmt = con.createStatement();
                rs = stmt.executeQuery(selectData);

                ResultSetMetaData rsmd = rs.getMetaData();
                int numberOfColumn = rsmd.getColumnCount();
                System.out.println("Number of columns in the table is: " + numberOfColumn);

                query = InsertTable.insertTable(tableName, numberOfColumn);

//                System.out.println("Data is inserted into table.");
            }

            case "update" -> {

            }

            case "select" -> {

            }

            case "delete" -> {

            }

            default -> {
                System.out.println("You entered wrong values.");
            }
        }
        System.out.println(query);
    }
}
