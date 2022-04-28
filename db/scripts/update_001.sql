CREATE TABLE IF NOT EXISTS post (
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    created     TIMESTAMP,
    city_id     INTEGER,
    visible     BOOLEAN
);
