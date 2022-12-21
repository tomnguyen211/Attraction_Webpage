drop table if exists Attraction;
drop table if exists Comments;

create table Attraction (
    id		integer auto_increment primary key,
    name       	varchar(255) unique not null,
    phone		varchar(255) unique not null
);

create table Comments (
    id		integer auto_increment primary key,
    name       	varchar(255) unique not null,
    comment		varchar(500) unique not null,
    id_place     integer references attraction(id)
);