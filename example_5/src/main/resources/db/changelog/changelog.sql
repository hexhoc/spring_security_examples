--liquibase formatted sql

--changeset hexhoc:1
CREATE TABLE accounts (
    id serial PRIMARY KEY,
    username varchar(50) NOT NULL DEFAULT '',
    password varchar(50) NOT NULL DEFAULT '',
    role varchar(50) NOT NULL DEFAULT 'ROLE_USER'
);

INSERT INTO accounts (username, password, role)  VALUES ('user', '123', 'ROLE_USER');
INSERT INTO accounts (username, password, role)  VALUES ('admin', '123', 'ROLE_ADMIN');
