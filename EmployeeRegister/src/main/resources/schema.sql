drop table if exists employee;
create table employee (
    id bigserial primary key not null,
    created_date timestamp not null,
    last_modified_date timestamp not null,
    name varchar(255) not null,
    designation varchar(255) not null,
    version integer not null
)