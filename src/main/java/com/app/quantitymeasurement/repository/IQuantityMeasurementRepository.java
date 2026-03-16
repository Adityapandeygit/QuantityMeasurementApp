package com.app.quantitymeasurement.repository;

public interface IQuantityMeasurementRepository {

    void saveOperation(String operation,
                       String measurementType,
                       double value1,
                       double value2,
                       double result);

}