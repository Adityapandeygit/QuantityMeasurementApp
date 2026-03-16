package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(
            IQuantityMeasurementService service) {

        this.service = service;
    }

    public void performOperation(String operation,
                                 String type,
                                 double v1,
                                 double v2,
                                 double result) {

        service.recordOperation(operation, type, v1, v2, result);

        System.out.println("Operation recorded successfully");
    }
}