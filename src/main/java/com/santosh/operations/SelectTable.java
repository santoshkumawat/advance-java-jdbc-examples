package com.santosh.operations;

import java.sql.*;
import java.util.Scanner;

public class SelectTable {

    static Scanner scanner = new Scanner(System.in);

    public static String selectTable(String tableName, Connection con) throws SQLException {
        String query = "SELECT * FROM " + tableName + ";";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        getStructuredData(resultSet);
        return query;
    }

    public static void getStructuredData(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++) {
            String columnName = rsmd.getColumnName(i);
            System.out.print(columnName + "\t");
        }
        System.out.println();

        int rowCount = 0;
        while (rs.next()) {
            rowCount = rowCount + 1;

            for (int i = 1; i <= numberOfColumns; i++) {
                String columnTypeName = rsmd.getColumnTypeName(i);

                if (columnTypeName.equalsIgnoreCase("INT")) {
                    int integerColumnData = rs.getInt(i);
                    System.out.print(integerColumnData + "\t");
                } else {
                    String stringColumnData = rs.getString(i);
                    System.out.print(stringColumnData + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("Rows:" + rowCount);
    }
}
