package com.app.quantitymeasurement;

import com.app.quantitymeasurement.controller.QuantityMeasurementController;
import com.app.quantitymeasurement.factory.RepositoryFactory;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.app.quantitymeasurement.util.DatabaseInitializer;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
    	
    	DatabaseInitializer.initialize();
    	
        IQuantityMeasurementRepository repository =
                RepositoryFactory.createRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.performOperation(
                "ADD",
                "LENGTH",
                5,
                10,
                15
        );

        System.out.println("Application started successfully");
    }
}