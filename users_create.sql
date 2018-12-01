create table USERS (
  USER_ID serial not null,
  USER_NAME varchar(20),
  USER_SEX varchar(1),
  USER_AGE varchar(3),
  INSERT_DATE timestamp,
  UPDATE_DATE timestamp,
  VERSION varchar,
  primary key(USER_ID)
);

drop table USERS;

insert into USERS (USER_NAME, USER_SEX, USER_AGE, INSERT_DATE, VERSION) values ('山田太郎', '0', '25', '2018-01-01 00:00:00','1');
insert into USERS (USER_NAME, USER_SEX, USER_AGE, INSERT_DATE, VERSION) values ('山田花子', '1', '24', '2018-01-01 00:00:00','1');
insert into USERS (USER_NAME, USER_SEX, USER_AGE, INSERT_DATE, VERSION) values ('佐藤夏生', '0', '25', '2018-01-01 00:00:00','1');
insert into USERS (USER_NAME, USER_SEX, USER_AGE, INSERT_DATE, VERSION) values ('田中雪子', '1', '24', '2018-01-01 00:00:00','1');
