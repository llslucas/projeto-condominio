CREATE DATABASE IF NOT EXISTS main_condominio;

USE main_condominio;

CREATE TABLE IF NOT EXISTS condominio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cnpj VARCHAR(255) NOT NULL,
    razao_social VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS residencia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    proprietario_id INT NOT NULL,
    condominio_id INT NOT NULL,
    FOREIGN KEY (condominio_id) REFERENCES condominio(id)
);

CREATE TABLE IF NOT EXISTS morador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    rg VARCHAR(20) NOT NULL, 
    data_nascimento DATE NOT NULL,
    residencia_id INT NOT NULL,
    FOREIGN KEY (residencia_id) REFERENCES residencia(id)
);

CREATE TABLE IF NOT EXISTS fatura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10, 2) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    status VARCHAR(20) NOT NULL,
    residencia_id INT NOT NULL,
    morador_id INT NOT NULL,
    FOREIGN KEY (morador_id) REFERENCES morador(id),
    FOREIGN KEY (residencia_id) REFERENCES residencia(id)
);

ALTER TABLE residencia ADD CONSTRAINT fk_proprietario
    FOREIGN KEY (proprietario_id) REFERENCES morador(id);