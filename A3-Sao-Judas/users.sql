create database mydatabase;
use mydatabase;

create table users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    idade int,
    nome varchar(255),
    email varchar(255),
    endereco varchar(255),
    senha varchar(4),
    adm bit
);