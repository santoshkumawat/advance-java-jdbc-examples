package com.santosh.operations;

import java.sql.*;
import java.util.Scanner;

public class OperationPerformer {

    static Scanner scanner = new Scanner(System.in);

    public static void operation(String op, Connection con) throws SQLException {
        System.out.println("Enter table name which you want to perform operations on that. Note: Do not give any space in between table name.");
        String tableName = scanner.next();
        String query = null;

        switch (op) {
            case "create" -> {
                query = CreateTable.createTable(tableName, con);
                System.out.println("Table is created.");
            }

            case "insert" -> {
                query = InsertTable.insertTable(tableName, con);
                System.out.println("Data is inserted into table.");
            }

            case "update" -> {

            }

            case "select" -> {
                query = SelectTable.selectTable(tableName, con);
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
