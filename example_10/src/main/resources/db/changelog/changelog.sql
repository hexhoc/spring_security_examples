--liquibase formatted sql

--changeset hexhoc:1
create table products
(
    id   serial primary key,
    name varchar(255) NOT NULL DEFAULT '',
    price float4 NOT NULL DEFAULT 0
);

INSERT INTO products (name, price)
VALUES ('product 1', 100),
       ('product 2', 200),
       ('product 3', 300),
       ('product 4', 400),
       ('product 5', 500),
       ('product 6', 600),
       ('product 7', 700);

CREATE TABLE accounts (
    id serial NOT NULL,
    name varchar(150) NOT NULL DEFAULT '',
    password varchar(150) NOT NULL DEFAULT '',
    role varchar(150) NOT NULL DEFAULT '',
    CONSTRAINT pk_id PRIMARY KEY (id)
);

INSERT INTO accounts(name, password, role)
VALUES ('user', '123', 'ROLE_USER'),
       ('admin', '123', 'ROLE_ADMIN')