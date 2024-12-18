CREATE TABLE IF NOT EXISTS `customer`
(
    `customer_id`   int AUTO_INCREMENT PRIMARY KEY,
    `name`          varchar(100) NOT NULL,
    `email`         varchar(100) NOT NULL,
    `mobile_number` varchar(20)  NOT NULL,
    `created_at`    date         NOT NULL,
    `created_by`    varchar(20)  NOT NULL,
    `updated_at`    date        DEFAULT NULL,
    `updated_by`    varchar(20) DEFAULT NULL
    );

CREATE TABLE IF NOT EXISTS `accounts`
(
    `customer_id`    int          NOT NULL,
    `account_number` int AUTO_INCREMENT PRIMARY KEY,
    `account_type`   varchar(100) NOT NULL,
    `branch_address` varchar(200) NOT NULL,
    `created_at`     date         NOT NULL,
    `created_by`     varchar(20)  NOT NULL,
    `updated_at`     date        DEFAULT NULL,
    `updated_by`     varchar(20) DEFAULT NULL
    );



INSERT INTO customer (name, email, mobile_number, created_at, created_by, updated_at, updated_by)
VALUES
    ('John Doe', 'john.doe@example.com', '1234567890', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
    ('Jane Smith', 'jane.smith@example.com', '9876543210', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
    ('Alice Brown', 'alice.brown@example.com', '5551234567', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');


INSERT INTO accounts (customer_id, account_type, account_address, created_at, created_by, updated_at, updated_by)
VALUES
    (1, 'Savings', '123 Main Street', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
    (2, 'Checking', '456 Elm Street', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
    (3, 'Savings', '789 Oak Avenue', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');
