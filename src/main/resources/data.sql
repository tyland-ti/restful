insert into USER values (90001, sysdate(),'user1', 'test1', '800100-1111111');
insert into USER values (90002, sysdate(),'user2', 'test2', '810100-1111111');
insert into USER values (90003, sysdate(),'user3', 'test3', '820100-1111111');

insert into post values (10001, 'first post', 90001);
insert into post values (10002, 'second post', 90001);
insert into post values (10003, 'third post', 90001);
insert into post values (10004, 'forth post', 90003);