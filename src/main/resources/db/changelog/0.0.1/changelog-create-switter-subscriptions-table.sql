--liquibase formatted sql

--changeset MikhailProkopovich:create-switter-subscriptions-table
--comment create table switter.subscriptions
create table switter.subscriptions
(
    id                 serial primary key,
    follower_id        integer   not null,
    followed_id        integer   not null,
    created_timestamp  timestamp not null
);
--rollback drop table switter.subscriptions;

--changeset MikhailProkopovich:add-switter-subscriptions-table-constraints
--comment add constraints to switter.subscriptions table
alter table switter.subscriptions
    add constraint follower__user_profiles__fk
        foreign key (follower_id) references switter.user_profiles (id);

alter table switter.subscriptions
    add constraint followed__user_profiles__fk
        foreign key (followed_id) references switter.user_profiles (id);

alter table switter.subscriptions
    add constraint subscriptions__relationship__unique
        unique (follower_id, followed_id);
--rollback alter table switter.subscriptions drop constraint follower__user_profiles__fk;
--rollback alter table switter.subscriptions drop constraint followed__user_profiles__fk;
--rollback alter table switter.subscriptions drop constraint subscriptions__relationship__unique;