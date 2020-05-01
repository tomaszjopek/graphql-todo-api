-- truncate all tables
-- drop table USERS_TICKETS;
-- drop table users;
-- DROP TABLE TICKETS;

insert into users(id, username) values ('f4b412d2-87e9-11ea-bc55-0242ac130040', 'tjopek');

-- test data
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130003', 'Ticket description', 'MEDIUM', 'Test ticket', 'f4b412d2-87e9-11ea-bc55-0242ac130040');
