--liquibase formatted sql

--changeset hexhoc:1

CREATE TABLE profiles
(
    name varchar(50) PRIMARY KEY
);

INSERT INTO profiles (name)
VALUES ('USER'),
       ('ADMIN');

CREATE TABLE accounts
(
    id       serial PRIMARY KEY,
    username varchar(50) NOT NULL DEFAULT '',
    password varchar(50) NOT NULL DEFAULT '',
    profile  varchar(50) NOT NULL,
    CONSTRAINT fk_profile
        FOREIGN KEY (profile) REFERENCES profiles (name)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

INSERT INTO accounts (username, password, profile)
VALUES ('user', '123', 'USER'),
       ('admin', '123', 'ADMIN');

CREATE TABLE authority
(
    name varchar(50) PRIMARY KEY
);

INSERT INTO authority (name)
VALUES ('book.create'),
       ('book.delete'),
       ('book.read'),
       ('book.update');

CREATE TABLE profile_authorities (
    profile_name varchar(50) NOT NULL,
    authorities_name varchar(50) NOT NULL,
    CONSTRAINT fk_profile FOREIGN KEY (profile_name) REFERENCES profiles (name),
    CONSTRAINT fk_authorities FOREIGN KEY (authorities_name) REFERENCES authority (name)
);

INSERT INTO profile_authorities (profile_name, authorities_name)
VALUES ('ADMIN', 'book.create'),
       ('ADMIN', 'book.delete'),
       ('ADMIN', 'book.read'),
       ('ADMIN', 'book.update'),
       ('USER', 'book.read');