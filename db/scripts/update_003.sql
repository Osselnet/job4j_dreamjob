CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     email TEXT UNIQUE,
     password TEXT
);