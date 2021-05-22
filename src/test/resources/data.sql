delete from `key` where id is not null ;
delete from `room` where id is not null ;
delete from `user` where id is not null ;
delete from `visitor` where id is not null ;


insert into user (id, name) values (0, 'Zero Point'),
                                   (1, 'Administrator'),
                                   (2, 'Joe Fiscal'),
                                   (3, 'Mike Rows'),
                                   (4, 'Fill Ro'),
                                   (5, 'Just visitor'),
                                   (6, 'Peters M.'),
                                   (7, 'Pet M.');

insert into `room` (id, room_number) values (0, '0'),
                                            (1, '1'),
                                            (2, '202'),
                                            (3, '300'),
                                            (4, '4024'),
                                            (5, '3301');

insert into `key` (id, user_id) values (0, 0),
                                       (1, 1),
                                       (2, 2),
                                       (3, 3),
                                       (4, 4),
                                       (5, 5),
                                       (6, 6),
                                       (10001, 7);