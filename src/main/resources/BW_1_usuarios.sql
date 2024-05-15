create database if not exists mydatabase;
use mydatabase;

create table if not exists usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    idade int,
    nome varchar(255),
    email varchar(255),
    endereco varchar(255),
    senha varchar(4),
    adm bit
);