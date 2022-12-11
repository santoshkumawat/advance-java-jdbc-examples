package com.santosh.operations;

import java.util.Scanner;

public class CreateTable {
    static Scanner scanner = new Scanner(System.in);

    public static String createTable() {
        StringBuilder sb = new StringBuilder();

        System.out.println("Enter table name which you want to create. Note: Do not give any space in between table name.");
        String tableName = scanner.next();

        sb.append("CREATE TABLE ").append(tableName).append(" (");

        System.out.println("Please enter how many no. of column you want to add in the table.");
        int columns = scanner.nextInt();

        for (int i = 1; i <= columns; i++) {
            System.out.println("Enter column name.");
            String columnName = scanner.next();
            sb.append(columnName).append(" ");

            System.out.println("Enter column type like varchar or int.");
            String columnType = scanner.next();
            sb.append(columnType).append("(");

            System.out.println("Enter column length in number.");
            int columnLength = scanner.nextInt();
            sb.append(columnLength).append(") ");
            scanner.nextLine();
            System.out.println("Enter any key for column like (PRIMARY KEY).");
            String key = scanner.nextLine();
            if (key.equalsIgnoreCase("PRIMARY KEY")) {
                sb.append("PRIMARY KEY ");
            } else if (key.equalsIgnoreCase("NOT NULL")) {
                sb.append("NOT NULL ");
            } else if (key.equalsIgnoreCase("UNIQUE")) {
                sb.append("UNIQUE ");
            } else if (key.equalsIgnoreCase("FOREIGN KEY")) {
                sb.append("FOREIGN KEY ");
            } else if (key.equalsIgnoreCase("CHECK")) {
                sb.append("CHECK ");
            } else if (key.equalsIgnoreCase("DEFAULT")) {
                sb.append("DEFAULT ");
            } else if (key.equalsIgnoreCase("CREATE INDEX")) {
                sb.append("CREATE INDEX ");
            } else {
                sb.append("");
            }

            System.out.println("Enter extra thing like if you want to add (auto_increment) in this column then type yes otherwise type no.");
            String extra = scanner.next();
            if (extra.equalsIgnoreCase("YES")) {
                sb.append("AUTO_INCREMENT, ");
            } else if (i == columns) {
                sb.append(" ");
            } else {
                sb.append(", ");
            }
        }
        sb.append(");");
        return sb.toString();
    }
}
