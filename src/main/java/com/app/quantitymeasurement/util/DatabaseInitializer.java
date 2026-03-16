package com.app.quantitymeasurement.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        try {

            Connection conn = ConnectionPool.getConnection();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    DatabaseInitializer.class
                                            .getClassLoader()
                                            .getResourceAsStream("db/schema.sql")
                            ));

            StringBuilder sql = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sql.append(line);
            }

            Statement stmt = conn.createStatement();
            stmt.execute(sql.toString());

            ConnectionPool.releaseConnection(conn);

            System.out.println("Database schema initialized");

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}