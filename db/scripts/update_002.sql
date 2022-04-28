CREATE TABLE IF NOT EXISTS candidate (
     id SERIAL PRIMARY KEY,
     name TEXT NOT NULL,
     description TEXT,
     created TIMESTAMP,
     photo BYTEA
);