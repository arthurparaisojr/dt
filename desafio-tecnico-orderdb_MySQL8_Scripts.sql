CREATE DATABASE IF NOT EXISTS OrderDB;
USE OrderDB;


CREATE TABLE IF NOT EXISTS Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO Customers (name) VALUES ('Customer 1'), ('Customer 2'), ('Customer 3'), ('Customer 4'), 
                                    ('Customer 5'), ('Customer 6'), ('Customer 7'), ('Customer 8'), 
                                    ('Customer 9'), ('Customer 10');


CREATE TABLE IF NOT EXISTS Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    control_number INT UNIQUE NOT NULL,
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    product_name VARCHAR(255) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    quantity INT DEFAULT 1,
    total_price DECIMAL(10, 2) NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE INDEX idx_orders ON Orders (registration_date, customer_id);
