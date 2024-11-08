-- core_bank_service.core_bank_user definition

CREATE TABLE core_bank_user (
    id                      bigserial NOT NULL,
    email                   varchar(255) DEFAULT NULL,
    first_name              varchar(255) DEFAULT NULL,
    identification_number   varchar(255) DEFAULT NULL,
    last_name               varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

-- core_bank_service.core_bank_account definition

CREATE TABLE core_bank_account (
    id                  bigserial NOT NULL,
    actual_balance      decimal(19, 2) DEFAULT NULL,
    available_balance   decimal(19, 2) DEFAULT NULL,
    number              varchar(255)   DEFAULT NULL,
    status              varchar(255)   DEFAULT NULL,
    type                varchar(255)   DEFAULT NULL,
    user_id             bigint DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES core_bank_user(id)
);

-- core_bank_service.core_bank_transaction definition

CREATE TABLE core_bank_transaction (
    id                  bigserial NOT NULL,
    amount              decimal(19, 2) DEFAULT NULL,
    transaction_type    varchar(30) NOT NULL,
    reference_number    varchar(50) NOT NULL,
    transaction_id      varchar(50) NOT NULL,
    account_id          bigint     DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES core_bank_account(id)
);

-- core_bank_service.core_bank_account definition

CREATE TABLE core_bank_utility_account (
    id            bigserial NOT NULL,
    number        varchar(255) DEFAULT NULL,
    provider_name varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);
