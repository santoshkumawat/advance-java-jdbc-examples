package com.santosh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    public static Connection establishConnection() {
        Connection con = null;
        try {
            Class.forName(Data.DRIVER_NAME);
            con = DriverManager.getConnection(Data.URL, Data.USERNAME, Data.PASSWORD);
            System.out.println("Connection is Created.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection can not established.");
        }
        return con;
    }

}
