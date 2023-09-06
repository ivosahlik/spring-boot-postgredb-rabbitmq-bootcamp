
create table if not exists Dummy
(
    id    integer not null,
    content character varying(255),
    publishOrder int,
    constraint customer_pkey primary key (id)
);