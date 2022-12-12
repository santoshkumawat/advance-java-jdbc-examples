package com.santosh.operations;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTable {

    static Scanner scanner = new Scanner(System.in);

    public static String selectTable(String tableName){
        String selectQuery = "SELECT * FROM " + tableName + ";";
        return selectQuery;
    }

    public static void getStructuredTable(ResultSet rs) throws SQLException {
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
