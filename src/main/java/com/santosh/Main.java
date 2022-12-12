package com.santosh;

import com.santosh.connection.ConnectionProvider;
import com.santosh.operations.OperationPerformer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("You can do 5 operations on the database tables in this software. Like Create, Insert, Update, Select and Delete.");
        System.out.println("These operations is only applicable on MYSQL DB.");

        ConnectionProvider cp = new ConnectionProvider();
        Connection con = cp.establishConnection();

        try {
            if (!con.isClosed()) {
                System.out.println("Enter any operation you want to perform Like 'create, insert, delete' etc.");
                Scanner scanner = new Scanner(System.in);
                String operation = scanner.next();

                OperationPerformer op = new OperationPerformer();
                op.operation(operation, con);

                con.close();
                System.out.println("Connection is closed successfully!!!");
            } else {
                System.out.println("Connection is closed, please create a connection first.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}