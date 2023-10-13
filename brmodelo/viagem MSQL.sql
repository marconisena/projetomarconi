create database crud;
use crud;
CREATE TABLE Usuario (
id int auto_increment PRIMARY KEY,
nome VARCHAR(200),
cpf VARCHAR(11),
email VARCHAR(100),
senha VARCHAR(20),
telefone VARCHAR(20)
);

CREATE TABLE Passagem (
id int auto_increment PRIMARY KEY,
destino VARCHAR(200),
data_passagem DATETIME,
preco DECIMAL(20)
);

CREATE TABLE compra (
id int auto_increment PRIMARY KEY,
id_usuario int,
id_passagem int
);

select * from compra; 
drop table usuario;

