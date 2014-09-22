insert into USERS (ID,USERNAME, PASSWORD, PHONE, EMAIL) values (1,'user', '123', '509-555-1234','user@spring.com');
insert into USERS (ID,USERNAME, PASSWORD, PHONE, EMAIL) values (2,'admin', '456', '509-555-1244','admin@spring.com');

insert into ROLEs(ID,ROLE) values (1,'user');
insert into ROLEs(ID,ROLE) values (2,'admin');

insert into USER_ROLES(USER_ID,ROLE_ID) values (1,1);
insert into USER_ROLES(USER_ID,ROLE_ID) values (2,1);
insert into USER_ROLES(USER_ID,ROLE_ID) values (2,2);