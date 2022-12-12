package com.santosh.operations;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTable {

    static Scanner scanner = new Scanner(System.in);

    public static String insertTable(String tableName) throws SQLException {


        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("INSERT INTO ").append(tableName).append(" VALUES (");



        insertQuery.append(");");
        return insertQuery.toString();
    }

}
