package com.santosh.operations;

import java.sql.*;
import java.util.Scanner;

public class InsertTable {

    static Scanner scanner = new Scanner(System.in);

    public static String insertTable(String tableName, Connection con) throws SQLException {
        String selectData = selectData(tableName);
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(selectData);
        findColumnNameAndType(resultSet);

        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("INSERT INTO ").append(tableName).append(" VALUES (");


        insertQuery.append(");");
        String query = insertQuery.toString();

//        stmt.executeQuery(query);
        return query;
    }

    public static void findColumnNameAndType(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) + " (");
            System.out.print(rsmd.getColumnTypeName(i) + "(");
            System.out.print(rsmd.getColumnDisplaySize(i) + ")) \t \t");
        }
        System.out.println();
    }

    public static String selectData(String tableName) {
        String selectQuery = "SELECT * FROM " + tableName + ";";
        return selectQuery;
    }

}
