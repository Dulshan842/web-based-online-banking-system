IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'BankDB')
    CREATE DATABASE BankDB;
GO

USE BankDB;
GO

IF OBJECT_ID('Transactions', 'U') IS NULL
CREATE TABLE Transactions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    acc VARCHAR(50),
    amt DECIMAL(10,2),
    date DATE,
    name VARCHAR(100),
    bank VARCHAR(100),
    reason TEXT,
    type VARCHAR(20),
    createdAt DATETIME DEFAULT GETDATE()
);
GO

IF OBJECT_ID('Bills', 'U') IS NULL
CREATE TABLE Bills (
    id INT IDENTITY(1,1) PRIMARY KEY,
    type VARCHAR(50),
    amt DECIMAL(10,2),
    createdAt DATETIME DEFAULT GETDATE()
);
GO

-- Create ScheduledTransactions table
IF OBJECT_ID('ScheduledTransactions', 'U') IS NULL
CREATE TABLE ScheduledTransactions (
    id INT IDENTITY(1000,1) PRIMARY KEY,
    acc VARCHAR(50) NOT NULL,
    amt DECIMAL(10,2) NOT NULL CHECK (Amt >= 0),
    date DATE NOT NULL,
    name VARCHAR(100),
    bank VARCHAR(100),
    reason TEXT,
    type VARCHAR(20),
    CreatedAt DATETIME DEFAULT GETDATE(),
    IsConfirmed BIT DEFAULT 0 -- 0 = pending, 1 = confirmed
);

GO
