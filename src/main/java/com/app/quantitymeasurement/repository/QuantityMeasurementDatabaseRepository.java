package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    private static final String INSERT_SQL =
            "INSERT INTO quantity_measurement_entity " +
            "(operation, measurement_type, value1, value2, result) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public void saveOperation(String operation,
                              String measurementType,
                              double value1,
                              double value2,
                              double result) {

        Connection conn = null;

        try {

            conn = ConnectionPool.getConnection();

            PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);

            stmt.setString(1, operation);
            stmt.setString(2, measurementType);
            stmt.setDouble(3, value1);
            stmt.setDouble(4, value2);
            stmt.setDouble(5, result);

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new DatabaseException("Error saving operation", e);
        }
        finally {
            if (conn != null)
                ConnectionPool.releaseConnection(conn);
        }
    }
}