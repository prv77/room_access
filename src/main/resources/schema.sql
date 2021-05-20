drop table if exists `hibernate_sequence`;
drop table if exists `visitor`;
drop table if exists `room`;
drop table if exists `key`;
drop table if exists `user`;


create table `hibernate_sequence` (`next_val` bigint) engine=InnoDB ;
insert into `hibernate_sequence` values ( 1 ) ;

create table room
(
    id          bigint       not null primary key,
    room_number varchar(255) null
);

create table user
(
    id   bigint       not null primary key,
    name varchar(255) not null
);

create table `key`
(
    id      bigint not null primary key,
    user_id bigint not null,
    constraint key_user_id_uniqindex unique (user_id),
    foreign key fk_key_user_id (user_id) references user (id)
);

create table visitor
(
    id      bigint not null primary key,
    user_id bigint null,
    room_id bigint null,
    constraint fk_visitor_room_id foreign key (room_id) references room (id),
    constraint fk_visitor_user_id foreign key (user_id) references user (id)
);