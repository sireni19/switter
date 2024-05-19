--liquibase formatted sql

--changeset MikhailProkopovich:create-switter-schema;
--comment create new schema;

create schema switter;
--rollback drop schema switter;