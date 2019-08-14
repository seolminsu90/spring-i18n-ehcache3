create table IF NOT EXISTS languages (
    messagekey varchar(255),
    locale varchar(2), 
    messagecontent varchar(255),
    primary key (messagekey, locale)
);

create table IF NOT EXISTS test (
    id bigint,
    name varchar(50),
    primary key (id)
);