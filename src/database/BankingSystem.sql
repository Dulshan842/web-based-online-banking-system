-- Create database if not exists
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'BankingSystem')
    CREATE DATABASE BankingSystem;
GO

USE BankingSystem;
GO

-- Users table
IF OBJECT_ID('Users', 'U') IS NULL
BEGIN
    CREATE TABLE Users (
        id INT IDENTITY(1,1) PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        account_id VARCHAR(50) UNIQUE NOT NULL,
        password_hash VARCHAR(255) NOT NULL,
        birthday DATE,
        address TEXT,
        phone VARCHAR(20),
        balance DECIMAL(12,2) DEFAULT 300000 CHECK (balance >= 0),
        createdAt DATETIME DEFAULT GETDATE()
    );
END
ELSE
BEGIN
    IF COL_LENGTH('Users', 'balance') IS NULL
        ALTER TABLE Users ADD balance DECIMAL(12,2) DEFAULT 300000 CHECK (balance >= 0);
END
GO

-- SecurityQuestions table
IF OBJECT_ID('SecurityQuestions', 'U') IS NULL
BEGIN
    CREATE TABLE SecurityQuestions (
        id INT IDENTITY(1,1) PRIMARY KEY,
        user_id INT NOT NULL,
        question VARCHAR(255),
        answer_hash VARCHAR(255),
        FOREIGN KEY (user_id) REFERENCES Users(id)
    );
END
GO

-- LoginHistory table
IF OBJECT_ID('LoginHistory', 'U') IS NULL
BEGIN
    CREATE TABLE LoginHistory (
        id INT IDENTITY(1,1) PRIMARY KEY,
        user_id INT NOT NULL,
        login_time DATETIME DEFAULT GETDATE(),
        ip_address VARCHAR(50),
        note VARCHAR(255),
        FOREIGN KEY (user_id) REFERENCES Users(id)
    );
END
ELSE
BEGIN
    IF COL_LENGTH('LoginHistory', 'note') IS NULL
        ALTER TABLE LoginHistory ADD note VARCHAR(255);
END
GO

-- Transactions table
IF OBJECT_ID('Transactions', 'U') IS NULL
BEGIN
    CREATE TABLE Transactions (
        id INT IDENTITY(1,1) PRIMARY KEY,
        acc VARCHAR(50),
        amt DECIMAL(10,2) CHECK (amt >= 0),
        date DATE,
        name VARCHAR(100),
        bank VARCHAR(100),
        reason TEXT,
        type VARCHAR(20),
        createdAt DATETIME DEFAULT GETDATE()
    );
END
GO

-- Bills table
IF OBJECT_ID('Bills', 'U') IS NULL
BEGIN
    CREATE TABLE Bills (
        id INT IDENTITY(1,1) PRIMARY KEY,
        type VARCHAR(50),
        amt DECIMAL(10,2) CHECK (amt >= 0),
        createdAt DATETIME DEFAULT GETDATE()
    );
END
GO

-- ScheduledTransactions table
IF OBJECT_ID('ScheduledTransactions', 'U') IS NULL
BEGIN
    CREATE TABLE ScheduledTransactions (
        id INT IDENTITY(1000,1) PRIMARY KEY,
        acc VARCHAR(50) NOT NULL,
        amt DECIMAL(10,2) NOT NULL CHECK (amt >= 0),
        date DATE NOT NULL,
        name VARCHAR(100),
        bank VARCHAR(100),
        reason TEXT,
        type VARCHAR(20),
        CreatedAt DATETIME DEFAULT GETDATE(),
        IsConfirmed BIT DEFAULT 0
    );
END
GO

-- Loans table
IF OBJECT_ID('Loans', 'U') IS NULL
BEGIN
    CREATE TABLE Loans (
        id INT IDENTITY(1,1) PRIMARY KEY,
        user_id INT NOT NULL,
        amount DECIMAL(12,2) CHECK (amount >= 0),
        status VARCHAR(20),
        max_limit DECIMAL(12,2),
        createdAt DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (user_id) REFERENCES Users(id)
    );
END
GO

-- Ratings table
IF OBJECT_ID('Ratings', 'U') IS NULL
BEGIN
    CREATE TABLE Ratings (
        id INT IDENTITY(1,1) PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        rating INT CHECK (rating BETWEEN 1 AND 5),
        comment TEXT,
        createdAt DATETIME DEFAULT GETDATE()
    );
END
ELSE
BEGIN
    -- Drop foreign key if it exists
    IF EXISTS (
        SELECT * FROM sys.foreign_keys 
        WHERE parent_object_id = OBJECT_ID('Ratings') 
        AND name LIKE 'FK__Ratings__user_id%'
    )
    BEGIN
        ALTER TABLE Ratings DROP CONSTRAINT FK__Ratings__user_id__5535A963;
    END

    -- Drop user_id column if it exists
    IF EXISTS (
        SELECT * FROM sys.columns 
        WHERE object_id = OBJECT_ID('Ratings') 
        AND name = 'user_id'
    )
    BEGIN
        ALTER TABLE Ratings DROP COLUMN user_id;
    END

    -- Add name column if missing
    IF COL_LENGTH('Ratings', 'name') IS NULL
    BEGIN
        ALTER TABLE Ratings ADD name VARCHAR(100) NOT NULL;
    END
END
GO

-- Admins table
IF OBJECT_ID('Admins', 'U') IS NULL
BEGIN
    CREATE TABLE Admins (
        id INT IDENTITY(1,1) PRIMARY KEY,
        username VARCHAR(50) UNIQUE NOT NULL,
        password_hash VARCHAR(255) NOT NULL,
        role VARCHAR(50),
        createdAt DATETIME DEFAULT GETDATE()
    );
END
GO

-- AdminActions table
IF OBJECT_ID('AdminActions', 'U') IS NULL
BEGIN
    CREATE TABLE AdminActions (
        id INT IDENTITY(1,1) PRIMARY KEY,
        admin_id INT NOT NULL,
        action_type VARCHAR(50),
        target_user_id INT,
        timestamp DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (admin_id) REFERENCES Admins(id),
        FOREIGN KEY (target_user_id) REFERENCES Users(id)
    );
END
GO
