package com.app.quantitymeasurement.factory;

import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.app.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.app.quantitymeasurement.util.ApplicationConfig;

public class RepositoryFactory {

    public static IQuantityMeasurementRepository createRepository() {

        String type = ApplicationConfig.getProperty("repository.type");

        if ("database".equalsIgnoreCase(type)) {
            return new QuantityMeasurementDatabaseRepository();
        }

        return new QuantityMeasurementCacheRepository();
    }
}