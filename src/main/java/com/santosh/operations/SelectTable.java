package com.santosh.operations;

import java.util.Scanner;

public class SelectTable {

    static Scanner scanner = new Scanner(System.in);

    public static String selectTable(String tableName){
        String selectQuery = "SELECT * FROM " + tableName + ";";
        return selectQuery;
    }
}
