-- bank_user_service.bank_user_table definition

CREATE TABLE bank_user_table (
    id                      bigserial NOT NULL,
    auth_id                 varchar(255) DEFAULT NULL,
    identification          varchar(255) DEFAULT NULL,
    status                  varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);
