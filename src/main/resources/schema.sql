CREATE TABLE customer (
    customer_id VARCHAR(50) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT CHECK (age >= 18 AND age <= 120),
    address TEXT NOT NULL,
    work_sector VARCHAR(50) NOT NULL
);
