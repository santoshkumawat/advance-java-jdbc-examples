package com.santosh.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {
    static Scanner scanner = new Scanner(System.in);

    public static String createTable(String tableName, Connection con) throws SQLException {
        StringBuilder createQuery = new StringBuilder();

        createQuery.append("CREATE TABLE ").append(tableName).append(" (");

        System.out.println("Please enter how many no. of columns you want to add in the table.");
        int columns = scanner.nextInt();

        for (int i = 1; i <= columns; i++) {
            System.out.println("Enter column name.");
            String columnName = scanner.next();
            createQuery.append(columnName).append(" ");

            System.out.println("Enter column type like varchar or int.");
            String columnType = scanner.next();
            createQuery.append(columnType).append("(");

            System.out.println("Enter column length in number.");
            int columnLength = scanner.nextInt();
            createQuery.append(columnLength).append(") ");
            scanner.nextLine();
            System.out.println("Enter any key for column like (PRIMARY KEY).");
            String key = scanner.nextLine();
            if (key.equalsIgnoreCase("PRIMARY KEY")) {
                createQuery.append("PRIMARY KEY ");
            } else if (key.equalsIgnoreCase("NOT NULL")) {
                createQuery.append("NOT NULL ");
            } else if (key.equalsIgnoreCase("UNIQUE")) {
                createQuery.append("UNIQUE ");
            } else if (key.equalsIgnoreCase("FOREIGN KEY")) {
                createQuery.append("FOREIGN KEY ");
            } else if (key.equalsIgnoreCase("CHECK")) {
                createQuery.append("CHECK ");
            } else if (key.equalsIgnoreCase("DEFAULT")) {
                createQuery.append("DEFAULT ");
            } else if (key.equalsIgnoreCase("CREATE INDEX")) {
                createQuery.append("CREATE INDEX ");
            } else {
                createQuery.append("");
            }

            System.out.println("Enter extra thing like if you want to add (auto_increment) in this column then type yes otherwise type no.");
            String extra = scanner.next();
            if (extra.equalsIgnoreCase("YES")) {
                if (i == columns) {
                    createQuery.append("AUTO_INCREMENT ");
                } else {
                    createQuery.append("AUTO_INCREMENT, ");
                }
            } else if (i == columns) {
                createQuery.append(" ");
            } else {
                createQuery.append(", ");
            }
        }
        createQuery.append(");");
        String query = createQuery.toString();

        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
        return query;
    }
}
