CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(100) UNIQUE NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       created_at TIMESTAMP DEFAULT now()
);

CREATE TYPE listing_status AS ENUM ('PENDING','APPROVED','REJECTED','SOLD','ARCHIVED');

CREATE TABLE listings (
                          id SERIAL PRIMARY KEY,
                          owner_id INT REFERENCES users(id) NOT NULL,
                          plate VARCHAR(20) NOT NULL,
                          city VARCHAR(100),
                          price NUMERIC(12,2) NOT NULL,
                          description TEXT,
                          status listing_status DEFAULT 'PENDING',
                          created_at TIMESTAMP DEFAULT now(),
                          approved_at TIMESTAMP
);

CREATE TABLE purchase_requests (
                                   id SERIAL PRIMARY KEY,
                                   listing_id INT REFERENCES listings(id) NOT NULL,
                                   buyer_id INT REFERENCES users(id) NOT NULL,
                                   status VARCHAR(20) DEFAULT 'REQUESTED',
                                   created_at TIMESTAMP DEFAULT now(),
                                   processed_at TIMESTAMP
);

CREATE TABLE transactions_archive (id SERIAL PRIMARY KEY,
                                   listing_id INT,
                                   seller_id INT,
                                   buyer_id INT,
                                   price NUMERIC(12,2),
                                   contact_info JSONB,
                                   completed_at TIMESTAMP DEFAULT now()
);
