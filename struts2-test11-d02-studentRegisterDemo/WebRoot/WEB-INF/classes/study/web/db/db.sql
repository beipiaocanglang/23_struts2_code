create database day27_0413_struts2;
use day27_userRegister_struts2;

create table student(
	username varchar(100),
	password varchar(100),
	birthday date,
	hobby varchar(100),
	married bit(1),
	primary key (username)
);