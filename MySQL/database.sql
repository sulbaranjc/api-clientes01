drop database IF EXISTS dbclientes01;
CREATE DATABASE IF NOT EXISTS dbclientes01;
USE dbclientes01; 

CREATE TABLE paises (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(50),
    correo VARCHAR(50),
    direccion VARCHAR(50),
    pais_id BIGINT,
    FOREIGN KEY (pais_id) REFERENCES paises(id)
);



INSERT INTO paises01 (nombre) VALUES ('España');
INSERT INTO paises01 (nombre) VALUES ('Venezuela');
INSERT INTO paises01 (nombre) VALUES ('Colombia');
INSERT INTO paises01 (nombre) VALUES ('Argentina');
INSERT INTO paises01 (nombre) VALUES ('Chile');
INSERT INTO paises01 (nombre) VALUES ('Brasil');
INSERT INTO paises01 (nombre) VALUES ('Perú');
INSERT INTO paises01 (nombre) VALUES ('México');
INSERT INTO paises01 (nombre) VALUES ('Uruguay');
INSERT INTO paises01 (nombre) VALUES ('Paraguay');

