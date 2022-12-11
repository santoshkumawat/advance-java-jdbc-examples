package com.santosh;

import com.santosh.connection.ConnectionProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectionProvider cp = new ConnectionProvider();
        System.out.println("You can do five operations in this software. Like Create, Insert, Update, Select and Delete.");
        System.out.println("These operations is only applicable on MYSQL DB,");

        cp.stablishConnection();
    }
}