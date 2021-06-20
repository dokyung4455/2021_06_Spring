create database WeatherOOTD;

create user wetd@localhost;


alter user wetd identified with mysql_native_password by'12345';
flush privileges; 
use wetd;

select * from weatherOOTD;

SHOW DATABASEs;

USE mySQL;

DROP DATABASE WeatherOOTD;

DROP USER wetd;

CREATE DATABASE weatherOOTD;

CREATE USER weaOotd@localhost;

USE MySQL;

DESC user;

GRANT all privileges on *.* TO weaOotd@localhost;

alter user 'weaOotd'@'localhost' identified with mysql_native_password BY '12345';


CREATE database score;
create user score@localhost;
use score;
grant all privileges on *.* to score@localhost;

alter user 'score'@'localhost' identified with mysql_native_password BY '12345;

