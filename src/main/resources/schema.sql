CREATE TABLE IF NOT EXISTS clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    control_number VARCHAR(255) NOT NULL UNIQUE,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    product_name VARCHAR(255) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    quantity INT DEFAULT 1,
    client_id BIGINT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

INSERT INTO clients (id, name) VALUES
(1, 'Client A'), (2, 'Client B'), (3, 'Client C'), (4, 'Client D'), (5, 'Client E'),
(6, 'Client F'), (7, 'Client G'), (8, 'Client H'), (9, 'Client I'), (10, 'Client J');

-- Example insert into orders
INSERT INTO orders (control_number, product_name, unit_price, client_id, total_price) VALUES
('001', 'Product X', 100.00, 1, 100.00);
