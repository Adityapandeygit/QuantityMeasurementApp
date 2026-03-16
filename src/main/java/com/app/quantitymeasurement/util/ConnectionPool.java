package com.app.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static List<Connection> pool = new ArrayList<>();

    static {
        try {
            String url = ApplicationConfig.getProperty("db.url");
            String username = ApplicationConfig.getProperty("db.username");
            String password = ApplicationConfig.getProperty("db.password");

            for (int i = 0; i < 5; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error creating connection pool");
        }
    }

    public static Connection getConnection() {
        if (pool.isEmpty()) {
            throw new RuntimeException("No DB connections available");
        }
        return pool.remove(0);
    }

    public static void releaseConnection(Connection conn) {
        pool.add(conn);
    }
}