--liquibase formatted sql;

--changeset MikhailProkopovich:create-switter-twits-table
--comment create table switter.twits
create table switter.twits
(
    id                serial primary key,
    message           varchar(200) not null,
    user_profile_id   integer      not null,
    created_timestamp timestamp    not null
);
--rollback drop table switter.twits;

--changeset MikhailProkopovich:add-switter-twits-table-constraints
--comment add constraint to switter.twits table
alter table switter.twits
    add constraint twits__user_profiles__fk
        foreign key (user_profile_id) references switter.user_profiles (id);
--rollback alter table switter.twits drop constraint twits__user_profiles__fk