-- Create table
create table APP_USER
(
  user_id           INT(100) not null AUTO_INCREMENT,
  user_name         VARCHAR(255) not null,
  encryted_password VARCHAR(255) not null,
  enabled           INT(2) not null,
  CONSTRAINT APP_USER_PK PRIMARY KEY (user_id)
) ;
 
alter table APP_USER
  add constraint APP_USER_UK unique (user_name);
 
 
-- Create table
create table APP_ROLE
(
  role_id   INT(100) not null,
  role_name VARCHAR(255) not null
) ;
--  
alter table APP_ROLE
  add constraint APP_ROLE_PK primary key (role_id);
 
alter table APP_ROLE
  add constraint APP_ROLE_UK unique (role_name);
 
 
-- Create table
create table USER_ROLE
(
  id      INT(100) not null AUTO_INCREMENT,
  user_id INT(100) not null,
  role_id INT(100) not null,
  CONSTRAINT USER_ROLE_PK PRIMARY KEY (id)
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (user_id, role_id);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (user_id)
  references APP_USER (user_id);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (role_id)
  references APP_ROLE (role_id);
 

-- Create table
create table FILES
(
  id                VARCHAR(255) not null,
  user_name         VARCHAR(255) not null,
  data 				longblob,
  file_name         VARCHAR(255),
  file_type         VARCHAR(255),
  uri_download      VARCHAR(255),
  size              INT(100) DEFAULT 0,
  share_file        INT(2) DEFAULT 0,
  create_date       datetime,
  update_date       datetime,
  create_user       VARCHAR(255),
  update_user       VARCHAR(255)
  
) ;

alter table FILES
  add constraint FILES_PK primary key (id);
  
     
-- Used by Spring Remember Me API.  
CREATE TABLE Persistent_Logins (
 
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used Datetime not null,
    PRIMARY KEY (series)
     
);
 
--------------------------------------
 
insert into App_User (user_id, user_name, encryted_password, enabled)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into App_User (user_id, user_name, encryted_password, enabled)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
---
 
insert into app_role (role_id, role_name)
values (1, 'ROLE_ADMIN');
 
insert into app_role (role_id, role_name)
values (2, 'ROLE_USER');
 
---
 
insert into user_role (id, user_id, role_id)
values (1, 1, 1);
 
insert into user_role (id, user_id, role_id)
values (2, 1, 2);
 
insert into user_role (id, user_id, role_id)
values (3, 2, 2);