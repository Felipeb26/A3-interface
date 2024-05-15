IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'mydatabase')
BEGIN
    CREATE DATABASE mydatabase;
END
GO;

USE mydatabase;
GO

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo' AND TABLE_NAME = 'usuarios')
BEGIN
    CREATE TABLE usuarios (
        id INT IDENTITY(1,1) PRIMARY KEY,
        idade INT,
        nome VARCHAR(255),
        email VARCHAR(255),
        endereco VARCHAR(255),
        senha VARCHAR(4),
        adm BIT
    )
END
GO;
