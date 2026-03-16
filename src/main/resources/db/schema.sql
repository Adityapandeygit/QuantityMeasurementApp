CREATE TABLE IF NOT EXISTS quantity_measurement_entity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(50),
    measurement_type VARCHAR(50),
    value1 DOUBLE,
    value2 DOUBLE,
    result DOUBLE,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);