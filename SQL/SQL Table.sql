CREATE DATABASE Farmacia;

CREATE TABLE usuarios(

id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varChar(50),
email varChar(30),
senha varChar(30),
dataDeCadastro date)