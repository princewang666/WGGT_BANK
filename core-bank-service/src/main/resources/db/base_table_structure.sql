-- core_bank_service.core_bank_user definition

CREATE TABLE `core_bank_user` (
    `id`                    bigint(20) NOT NULL AUTO_INCREMENT,
    `email`                 varchar(255) DEFAULT NULL,
    `first_name`            varchar(255) DEFAULT NULL,
    `identification_number` varchar(255) DEFAULT NULL,
    `last_name`             varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- core_bank_service.core_bank_account definition

CREATE TABLE `core_bank_account` (
    `id`                bigint(20) NOT NULL AUTO_INCREMENT,
    `actual_balance`    decimal(19, 2) DEFAULT NULL,
    `available_balance` decimal(19, 2) DEFAULT NULL,
    `number`            varchar(255)   DEFAULT NULL,
    `status`            varchar(255)   DEFAULT NULL,
    `type`              varchar(255)   DEFAULT NULL,
    `user_id`           bigint(20)     DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKt5uqy9p0v3rp3yhlgvm7ep0ij`(`user_id`),
    CONSTRAINT `FKt5uqy9p0v3rp3yhlgvm7ep0ij` FOREIGN KEY (`user_id`) REFERENCES `core_bank_user`(`id`)
);

-- core_bank_service.core_bank_transaction definition

CREATE TABLE `core_bank_transaction` (
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT,
    `amount`           decimal(19, 2) DEFAULT NULL,
    `transaction_type` varchar(30) NOT NULL,
    `reference_number` varchar(50) NOT NULL,
    `transaction_id`   varchar(50) NOT NULL,
    `account_id`       bigint(20)     DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKk9w2ogq595jbe8r2due7vv3xr`(`account_id`),
    CONSTRAINT `FKk9w2ogq595jbe8r2due7vv3xr` FOREIGN KEY (`account_id`) REFERENCES `core_bank_account`(`id`)
);

-- core_bank_service.core_bank_account definition

CREATE TABLE `core_bank_utility_account` (
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `number`        varchar(255) DEFAULT NULL,
    `provider_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
