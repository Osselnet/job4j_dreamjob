CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     email TEXT NOT NULL,
     password TEXT
);