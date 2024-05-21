--liquibase formatted sql

--changeset MikhailProkopovich:create-switter-user_profiles-table
--comment create table switter.user_profiles;
create table switter.user_profiles
(
    id         integer primary key,
    nickname   varchar(32)  not null,
    image_link varchar(128) not null
);
--rollback drop table switter.user_profiles;

--changeset MikhailProkopovich:add-switter-user_profiles-table-constraints
--comment add constraints to switter.user_profiles table
alter table switter.user_profiles
    add constraint user_profiles__user_accounts__fk
        foreign key (id) references identity.user_accounts (id);

alter table switter.user_profiles
    add constraint user_profiles__nickname__unique
        unique (nickname);
--rollback alter table switter.user_profiles drop constraint user_profiles__user_accounts__fk;
--rollback alter table switter.user_profiles drop constraint user_profiles__nickname__unique;