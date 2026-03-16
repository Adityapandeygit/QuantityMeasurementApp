package com.app.quantitymeasurement.repository;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    private final List<String> cache = new ArrayList<>();

    @Override
    public void saveOperation(String operation,
                              String measurementType,
                              double value1,
                              double value2,
                              double result) {

        String record =
                operation + " | " +
                measurementType + " | " +
                value1 + " | " +
                value2 + " | " +
                result;

        cache.add(record);

        System.out.println("Saved to cache: " + record);
    }
}