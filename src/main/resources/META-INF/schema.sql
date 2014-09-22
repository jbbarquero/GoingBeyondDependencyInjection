drop table USERS if exists;
drop table ROLES if exists;
drop table USER_ROLES if exists;

create table USERS (ID integer identity primary key, USERNAME varchar(20) not null, PASSWORD varchar(10) not null, PHONE varchar(15), EMAIL varchar(40), unique(USERNAME));
create table ROLES (ID integer identity primary key, ROLE varchar(20) not null, unique(ROLE));
create table USER_ROLES ( USER_ID integer, ROLE_ID integer, unique(USER_ID, ROLE_ID));

alter table USER_ROLES add constraint FK_USER_ROLE1 foreign key (USER_ID) references USERS(ID) on delete cascade;
alter table USER_ROLES add constraint FK_USER_ROLE2  foreign key (ROLE_ID) references ROLES(ID) on delete cascade;
