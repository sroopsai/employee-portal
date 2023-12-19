create table employee (
    id bigserial NOT NULL,
    created_date timestamp not null,
    last_modified_date timestamp not null,
    name varchar(255) NOT NULL,
    designation varchar(255) NOT NULL,
    version integer NOT NULL
)