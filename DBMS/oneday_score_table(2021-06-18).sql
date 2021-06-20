CREATE TABLE tbl_student(
st_num	CHAR(8)		primary KEY,
st_name	VARCHAR(20)	NOT NULL	,
st_dept	VARCHAR(20)	NOT NULL	,
st_grade	INT	NOT NULL	,
st_tel	VARCHAR(15)	NOT NULL,	
st_addr	VARCHAR(125)		
);

DROP TABLE tbl_score;
CREATE TABLE tbl_score(
sc_seq	BIGINT auto_increment primary KEY,
sc_stnum	CHAR(8)	NOT NULL	,
sc_subject	VARCHAR(20)	NOT NULL,	
sc_score	INT	NOT NULL	
);

ALTER TABLE tbl_score
ADD constraint fk_student
foreign key (sc_stnum)
references tbl_student(st_num);

ALTER TABLE tbl_student
ADD UNIQUE (st_name,st_dept,st_tel);

CREATE VIEW view_성적일람표 AS (
SELECT
ST.st_num AS st_num,
ST.st_name AS st_name,
ST.st_dept AS st_dept,
ST.st_grade AS st_grade,
COUNT(SC.sc_subject) AS sc_subject,
SUM(SC.sc_score) AS sc_score,
ROUND(AVG(SC.sc_score),1) AS sc_avg
FROM tbl_student ST
	LEFT JOIN tbl_score SC ON ST.st_num = SC.sc_stnum
    ORDER BY st_num
    );
DROP VIEW view_성적일람표;


