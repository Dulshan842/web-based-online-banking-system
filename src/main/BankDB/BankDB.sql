IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'BankDB')
    CREATE DATABASE BankDB;
GO

USE BankDB;
GO

IF OBJECT_ID('Transactions', 'U') IS NULL
CREATE TABLE Transactions (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Acc VARCHAR(50),
    Amt DECIMAL(10,2),
    Date DATE,
    Name VARCHAR(100),
    Bank VARCHAR(100),
    Reason TEXT,
    Type VARCHAR(20),
    CreatedAt DATETIME DEFAULT GETDATE()
);
GO

IF OBJECT_ID('Bills', 'U') IS NULL
CREATE TABLE Bills (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Type VARCHAR(50),
    Amt DECIMAL(10,2),
    CreatedAt DATETIME DEFAULT GETDATE()
);
GO
