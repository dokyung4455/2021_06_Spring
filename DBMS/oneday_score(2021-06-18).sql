CREATE DATABASE mybook;
CREATE USER mybook;
USE mybook;
grant all privileges on *.* to mybook;
alter user 'mybook' identified with mysql_native_password by '12345';



CREATE DATABASE score;
CREATE USER score;
USE Score;
grant all privileges on *.* to score;
alter user 'score' identified with mysql_native_password by '12345';