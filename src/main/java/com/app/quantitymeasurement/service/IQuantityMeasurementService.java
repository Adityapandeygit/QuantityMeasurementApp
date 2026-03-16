package com.app.quantitymeasurement.service;

public interface IQuantityMeasurementService {

    void recordOperation(String operation,
                         String measurementType,
                         double value1,
                         double value2,
                         double result);
}