CREATE DATABASE db_school;
USE db_school;
CREATE TABLE tbl_student(
st_num	CHAR(8)		PRIMARY KEY,
st_name	VARCHAR(20)	NOT NULL	,
st_dept	VARCHAR(20)	NOT NULL	,
st_grade	INT	NOT NULL	,
st_tel	VARCHAR(15)	NOT NULL,	
st_addr	VARCHAR(125)		
);

INSERT INTO tbl_student(st_num, st_name, st_dept, st_grade, st_tel, st_addr)
VALUES('20210001','홍길동','국어국문학과','3','010-1111-5222','서울특별시');


/*
TABLE에 INSERT INTO ON DUPLICATE KEY UPDATE를 실행하기 위해서는 PK 설정을 변경해야 한다.
tbl_score는 두개의 칼럼을 기준으로 UPDATE, DELETE를 수행하는 문제가 발생한다.

가장 좋은 설계는 UPDATE, DELETE 를 수행할때 한개의 칼럼으로 구성된 PK를 기준으로 수행하는 것이다.
*/
/*
PK는 그대로 살려두고 두개의 칼럼을 묶어 UNIQUE 로 설정 두개 칼럼의 값이 동시에 같은 경우는 추가하지 말라는 제약조건 설정
*/
CREATE TABLE tbl_score (
sc_seq	BIGINT	auto_increment	PRIMARY KEY,
sc_stnum	CHAR(8)	NOT NULL	,
sc_sbcode VARCHAR(20)	NOT NULL,	
sc_sbscore	INT	NOT NULL,
unique(SC_stnum, sc_sbcode)
);

DROP TABLE tbl_student;

DROP TABLE tbl_score;
DROP TABLE tbl_subject;

INSERT INTO tbl_score (sc_stnum, sc_sbcode, sc_sbscore)
VALUES('20210001','S001',90);
INSERT INTO tbl_score (sc_stnum, sc_sbcode, sc_sbscore)
VALUES('20210001','S002',85);
INSERT INTO tbl_score (sc_stnum, sc_sbcode, sc_sbscore)
VALUES('20210001','S003',60);
INSERT INTO tbl_score (sc_stnum, sc_sbcode, sc_sbscore)
VALUES('20210001','S004',87);

CREATE TABLE tbl_subject (
sb_code	CHAR(4)		PRIMARY KEY,
sb_name	VARCHAR(20)	NOT NULL	,
sb_prof	VARCHAR(20)		
);

INSERT INTO tbl_subject (sb_code, sb_name, sb_prof)
VALUES('C001','국어','김길중');
INSERT INTO tbl_subject (sb_code, sb_name, sb_prof)
VALUES('C001','영어','최영');
INSERT INTO tbl_subject (sb_code, sb_name, sb_prof)
VALUES('C001','수학','강석현');

DELETE FROM tbl_subject WHERE sb_code = '과목코드';

select * from tbl_subject;

select * from tbl_score;

/*
tbl_subject, tbl_score table을 가지고 각  학생의 성적 리스트를 출력해보기
과목 리스트를 출력하고, 각 과목의 성적이 입력된 학생의 리스트를 확인하기

학번을 조건으로하여 한 학생의 성적입력 여부를 확인하기

학생의 점수가 입력된 과목과 입력되지 않은 과목을 확인하고싶다.
*/
SELECT SB.sb_code, SB.sb_name, SB.sb_prof, SC.sc_stnum, SC.sc_sbscore
FROM tbl_subject SB
	LEFT JOIN 
		(SELECT * FROM tbl_score WHERE sc_stnum = '20210001' ) SC 
        ON SC.sc_sbcode = SB.sb_code;

/*
과목리스트를 전체 보여주고, 학생의 성적 table을 JOIN하여 학생의 점수가 있으면 점수를 보이고
없으면 null로 보여주는 JOIN SQL 문

순수한 JOIN을 사용하여 한 학생의 성적을 조회하는데 학생의 성적이 tbl_score table에 있으면 점수를 보이고
없으면 NULL 표현하기 위하여 WHERE 절에서 학번을 조건으로 부여하지 않고
JOIN문의 ON 절에 학번을 조건으로 부여한다.
*/
SELECT SB.sb_code, SB.sb_name, SB.sb_prof, SC.sc_stnum, SC.sc_sbscore
FROM tbl_subject SB
	LEFT JOIN 
		tbl_score SC 
        ON SC.sc_sbcode = SB.sb_code ;
        
        AND SC.sc_stnum = '2021001' LIMIT 5;
DELETE from tbl_subject where sb_code = '';

SELECT COUNT(*) FROM tbl_score WHERE sc_stnum = '20210901';