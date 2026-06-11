CREATE TABLE Hardware (
    id IDENTITY PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    price number NOT NULL,
    type VARCHAR(50) NOT NULL
);