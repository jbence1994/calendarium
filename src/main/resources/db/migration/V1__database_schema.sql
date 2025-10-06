CREATE DATABASE IF NOT EXISTS calendarium
    DEFAULT CHARACTER SET utf8
    COLLATE utf8_hungarian_ci;

USE calendarium;

CREATE TABLE IF NOT EXISTS appointments
(
    id         BINARY(16)   NOT NULL PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    name       VARCHAR(255) NOT NULL,
    start_date DATETIME     NOT NULL,
    end_date   DATETIME     NOT NULL,
    created_at DATETIME     NOT NULL             DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME     NOT NULL             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
