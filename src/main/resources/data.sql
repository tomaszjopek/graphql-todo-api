-- truncate all tables
-- drop table USERS_TICKETS;
-- drop table users;
-- DROP TABLE TICKETS;

insert into users(id, username) values ('f4b412d2-87e9-11ea-bc55-0242ac130040', 'tjopek');

-- test data
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID, STATE) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130003', 'Ticket description', 'MEDIUM', 'Test ticket', 'f4b412d2-87e9-11ea-bc55-0242ac130040', 'TODO');
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID, STATE) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130004', 'Ticket description', 'LOW', 'Test ticket 1', 'f4b412d2-87e9-11ea-bc55-0242ac130040', 'TODO');
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID, STATE) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130005', 'Ticket description', 'HIGH', 'Test ticket 2', 'f4b412d2-87e9-11ea-bc55-0242ac130040', 'IN_PROGRESS');
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID, STATE) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130006', 'Ticket description', 'MEDIUM', 'Test ticket 3', 'f4b412d2-87e9-11ea-bc55-0242ac130040', 'DONE');
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID, STATE) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130007', 'Ticket description', 'MEDIUM', 'Test ticket 4', 'f4b412d2-87e9-11ea-bc55-0242ac130040', 'DONE');
insert into TICKETS(ID, DESCRIPTION, PRIORITY, TITLE, USER_ID, STATE) values ( 'f4b412d2-87e9-11ea-bc55-0242ac130008', 'Ticket description', 'MEDIUM', 'Test ticket 5', 'f4b412d2-87e9-11ea-bc55-0242ac130040', 'DONE');
