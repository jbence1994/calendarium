CREATE DATABASE IF NOT EXISTS calendarium
    DEFAULT CHARACTER SET utf8
    COLLATE utf8_hungarian_ci;

USE calendarium;

CREATE TABLE IF NOT EXISTS users
(
    id           BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email        VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255) NOT NULL,
    middle_name  VARCHAR(255),
    last_name    VARCHAR(255) NOT NULL,
    phone_number VARCHAR(25) UNIQUE,
    created_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS appointments
(
    id           BINARY(16)   NOT NULL PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    organizer_id BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    start_date   DATETIME     NOT NULL,
    end_date     DATETIME     NOT NULL,
    description  TEXT,
    created_at   DATETIME     NOT NULL             DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME     NOT NULL             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_appointments_users
        FOREIGN KEY (organizer_id) REFERENCES users (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
