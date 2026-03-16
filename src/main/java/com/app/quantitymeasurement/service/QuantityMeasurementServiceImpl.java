package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(
            IQuantityMeasurementRepository repository) {

        this.repository = repository;
    }

    @Override
    public void recordOperation(String operation,
                                String measurementType,
                                double value1,
                                double value2,
                                double result) {

        repository.saveOperation(
                operation,
                measurementType,
                value1,
                value2,
                result
        );
    }
}