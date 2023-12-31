
-- DDL 
-- ALTER를 이용한 테이블에 제약조건 추가

-- ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명)
-- 					  ADD FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명(참조할 컬럼)
-- 					  ADD UNIQUE(컬럼명)
-- 					  ADD CHECK(값|조건식)
-- ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL

-- DEPARTMENT 테이블의 DEPT_ID 컬럼에 PK추가
ALTER TABLE DEPARTMENT ADD PRIMARY KEY(DEPT_ID);

DESC DEPARTMENT;
-- DEPARTMENT 테이블의 LOCATION_ID에 FK를 추가
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(LOCAL_CODE);

DESC DEPARTMENT;

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA='multi' AND TABLE_NAME = 'DEPARTMENT';


-- 테이블 내용 관련을 수정한다하면 이곳저곳의 데이터를 같이 관리하며 수정해야하기에 시간이 걸리는 편이다.

-- EMPLOYEE 테이블에
-- DEPT_CODE컬럼에 FK 추가
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMP_DEPTCODE FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);

-- SAL_LEVEL컬럼 FK 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(SAL_LEVEL) REFERENCES SAL_GRADE(SAL_LEVEL);

-- 
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB(JOB_CODE);

ALTER TABLE EMPLOYEE ADD CHECK(ENT_YN IN('Y','N'));

ALTER TABLE EMPLOYEE ADD CHECK(SALARY>0);

ALTER TABLE EMPLOYEE ADD UNIQUE(EMP_NO);

ALTER TABLE LOCATION ADD FOREIGN KEY(NATIONAL_CODE) REFERENCES NATIONAL(NATIONAL_CODE);



-- [CRUD]
-- CREATE : INSERT/ 추가
-- READ : SELECT / 조회
-- UPDATE : UPDATE / 수정
-- DELETE : DELETE / 삭제

-- INSERT : 새로운 행을 특정 테이블에 추가하는 명령어, 명령어 실행 후에는 테이블 ROW의 갯수가 증가

-- [사용형식]
-- 1. 특정 컬럼에 값을 추가하는 방법
-- INSERT INTO 테이블명(컬럼명)

-- 2. 모든 컬럼에 값을 추가하는 방법
-- INSERT INTO 테이블명 VALUES(값1,값2,....);

DESC EMPLOYEE;
-- 컬럼을 명시하여 데이터 추가

INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,EMP_NO,EMAIL,PHONE,DEPT_CODE,JOB_CODE,SAL_LEVEL,SALARY,BONUS,MANAGER_ID,HIRE_DATE,ENT_DATE,ENT_YN)
VALUES (500,'BIBLEE','991014-1234567','BIBLEE@MULTI.KR','01011112222','D1','J7','S4',3100000,0.1,200,NOW(),NULL,DEFAULT);

SELECT * FROM EMPLOYEE WHERE EMP_NAME='BIBLEE';

DESC USER_GRADE;
SELECT * FROM USER_GRADE;
INSERT INTO USER_GRADE(GRADE_CODE) VALUES (1);

DROP TABLE TEST_IN;
CREATE TABLE TEST_IN(
	NO1 INT,
	NO2 INT
);
INSERT INTO TEST_IN(NO1) VALUES (10,21);
SELECT * FROM TSET_IN;

-- 컬럼생략하고 데이터 추가 (모든 컬럼에 값을 추가)

INSERT INTO EMPLOYEE VALUES (900,'BIBLEE2','971014-1234567','biblee@multi.kr','01011113333','D2','J7','S5','3200000',0.1,200,NOW(),NULL,DEFAULT);

SELECT * FROM EMPLOYEE WHERE EMP_ID IN (500,900);


-- 지금까지 변경된 내용을 데이터베이스에 반영. 저장.
COMMIT;

-- INSERT + SUBQUERY
-- INSERT 문에 서브쿼리 사용하여 VALUES 대신 값을 지정하여 추가 가능

CREATE TABLE EMP_01(
	EMP_ID INT,
	EMP_NAME VARCHAR(20),
	DEPT_TITLE VARCHAR(40)
);

INSERT INTO EMP_01 (
SELECT EMP_ID,EMP_NAME,DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
);

DESC EMP_01;

SELECT * FROM EMP_01;

COMMIT;

-- UPDATE : 해당 테이블의 데이터를 수정하는 명령어
-- [사용형식]
-- UPDATE 테이블명 SET 컬럼명 = 바꿀값 [WHERE 조건식];
-- UPDATE는 실행 후 데이터 개수(ROW의 수) 변하지 않는다.

CREATE TABLE DEPT_COPY  * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;


-- D9 부서를 총무부 -> 전략기획부

UPDATE DEPT_COPY SET DEPT_TITLE = '전략기획부' WHERE DEPT_ID='D9';

SELECT * FROM DEPT_COPY;

COMMIT;

-- 실습1
-- EMPLOYEE 테이블에서 주민번호가 잘못 표기되어 있는 사원들이 있다.
-- 해당 사원을 찾아 사번순으로 각각 주민번호 앞자리를 
-- '621230','631126','850705'로 변경하는 UPDATE 구문 작성

-- 잘못 표기된 사원 조회
SELECT EMP_ID, EMP_NO
FROM EMPLOYEE ;
-- 200 , 201 , 214

UPDATE EMPLOYEE SET EMP_NO = CONCAT('621230',SUBSTR(EMP_NO,7)) WHERE EMP_ID ='200';
UPDATE EMPLOYEE SET EMP_NO = CONCAT('631126',SUBSTR(EMP_NO,7)) WHERE EMP_ID ='201';
UPDATE EMPLOYEE SET EMP_NO = CONCAT('850705',SUBSTR(EMP_NO,7)) WHERE EMP_ID ='214';


-- SELECT * FROM EMPLOYEE WHERE EMP_ID='200'OR EMP_ID='201'OR EMP_ID='214';
SELECT * FROM EMPLOYEE WHERE EMP_ID IN(200,201,214);

COMMIT;

-- UPDATE + SUBQUERY
-- UPDATE 테이블 SET 컬럼 = (서브쿼리)

-- 유재식 사원과 같은 급여,보너르르 받게끔 방명수 사원의 정보를 변경하자

SELECT * FROM EMPLOYEE WHERE EMP_NAME IN('유재식','방명수');


CREATE TABLE EMP_SALARY AS SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY,BONUS FROM EMPLOYEE;

SELECT * FROM EMP_SALARY;
-- 유재식 사원과 같은 급여 , 보너스를 받게끔 방명수 사원의 정보를 변경하자

UPDATE EMP_SALARY
SET SALARY= (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME='유재식'),
 	BONUS=(SELECT BONUS FROM EMPLOYEE WHERE EMP_NAME='유재식') 
WHERE EMP_NAME='방명수';

SELECT * FROM EMP_SALARY WHERE EMP_NAME IN('유재식','방명수');

COMMIT;


-- 단일행 다중열 서브쿼리
SELECT * FROM EMP_SALARY;

-- 버전 이슈로 문법적용 X
-- UPDATE EMP_SALARY
-- SET (SALARY,BONUS)= (SELECT SALARY,BONUS FROM EMPLOYEE WHERE EMP_ID='207')
-- WHERE EMP_NAME='방명수';







-- UPDATE시에 변경할 값이 해당 ㅋ러럼의 제약조건을 위배하지 않아야 한다.
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails (`multi`.`EMPLOYEE`, CONSTRAINT `FK_EMP_DEPTCODE` FOREIGN KEY (`DEPT_CODE`) REFERENCES `DEPARTMENT` (`DEPT_ID`))
-- 참조할수 없는 값을 명시하려고하면 에러가나온다 / 외래키 제약조건 위배
UPDATE EMPLOYEE SET DEPT_CODE='D0' WHERE DEPT_CODE='D9';

SELECT * FROM DEPARTMENT;

-- SQL Error [1048] [23000]: Column 'EMP_ID' cannot be null
-- EMP_ID 는 PRIMARY KEY 제약조건이 걸려있으므로 NOT NULL과 UNIQUE가 자동적용되어 에러가 발생
UPDATE EMPLOYEE SET EMP_ID = NULL WHERE EMP_ID= 200;



-- DELETE
-- 테이블의 행을 삭제하는 명령어
-- 실행하고 나면 테이블의 ROW 개수가 줄어든다

-- [사용형식]
-- DELETE FROM 테이블명 [WHERE 조건];
-- 만약 WHERE 조건을 작성하지 않고 실행 할 경우에는 테이블의 모든 데이터(ROW)가 삭제.


-- SQL Error [1451] [23000]: Cannot delete or update a parent row: a foreign key constraint fails (`multi`.`EMPLOYEE`, CONSTRAINT `FK_EMP_DEPTCODE` FOREIGN KEY (`DEPT_CODE`) REFERENCES `DEPARTMENT` (`DEPT_ID`))
-- DELETE를 사용할 때에 반드시 지우고자 하는 내용에 대해서 충분히 파악한 후 실행해야 한다.
DELETE FROM DEPARTMENT WHERE DEPT_ID='D1';

SELECT * FROM EMP_SALARY;
COMMIT;

-- 데이터 전체 삭제
DELETE FROM EMP_SALARY;

SELECT * FROM EMP_SALARY;

ROLLBACK;

SELECT * FROM EMP_SALARY;

-- 원하는 데이터만 삭제
DELETE FROM EMP_SALARY WHERE EMP_ID=200;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;





-- TCL
-- 트랜잭션 제어 언어
-- COMMIT , ROLLBACK, SAVEPOINT , ROLLBACK TO

-- TRANSCATION
-- 데이터를 처리하는 작업을 잘게 나눈 데이터 처리의 최소 단위
-- 하나의 트랜잭션으로 이루어진 작업은 반드시 ,작업 내용이 모두 성공하거나 모두 실패해야 한다
-- 성공하면 COMMIT, 하나라도 실패하면 ROLLBACK


COMMIT;

CREATE TABLE USER_TBL(
	USER_NO INT UNIQUE,
	USER_ID VARCHAR(20) NOT NULL UNIQUE,
	USER_PW VARCHAR(20) NOT NULL
);

INSERT INTO USER_TBL VALUES(1,'TEST01','TEST01');
INSERT INTO USER_TBL VALUES(2,'TEST02','TEST02');

COMMIT; -- 현재까지 작업한 DML 내용을 DB에 반영한다
SELECT * FROM USER_TBL;

INSERT INTO USER_TBL VALUES(3,'TEST03','TEST03');

ROLLBACK; -- 가장 최근에 COMMIT 했던 구간으로 되돌아간다.

SELECT * FROM USER_TBL;




DROP TABLE USER_TBL; -- DDL은 COMMIT , ROLLBACK이 적용되지 않는다
ROLLBACK;  
SELECT * FROM USER_TBL;





-- DDL (CREATE, ATLER, DROP)
-- CREATE : 데이터베이스 객체 생성 (데이터베이스,테이블, 뷰 ,인덱스)
-- ALTER : 생성상한 객체 수정
-- DROP : 생성한 객체 삭제

-- ALTER
DROP TABLE DEPT_COPY;

CREATE TABLE DEPT_COPY AS SELECT * FROM DEPARTMENT;
SELECT * FROM DEPT_COPY;

-- DEPT_COPY에 컬럼 추가
ALTER TABLE DEPT_COPY ADD (LNAME VARCHAR(20));

SELECT * FROM DEPT_COPY;

-- DEPT_COPY에 컬럼 삭제
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
SELECT * FROM DEPT_COPY;

-- 기본값을 적용하여 컬럼추가
ALTER TABLE DEPT_COPY ADD(LNAME VARCHAR(20) DEFAULT '한국');
SELECT * FROM DEPT_COPY;

DESC DEPT_COPY;

-- 컬럼의 자료형 수정
ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(30);
DESC DEPT_COPY;

-- SQL Error [1265] [01000]: Data truncated for column 'DEPT_TITLE' at row 1
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR(3);


-- 컬럼의 이름 변경
ALTER TABLE DEPT_COPY RENAME COLUMN LNAME TO LOC_NAME;

DESC DEPT_COPY;

-- 테이블 이름 변경
ALTER TABLE DEPT_COPY RENAME TO DEPT_COPY2;

DESC DEPT_COPY2;
DESC DEPT_COPY; -- DEPT_COPY2 로 이름이 변경되면서 조회불가


ALTER TABLE DEPT_COPY2 DROP COLUMN LOC_NAME;
ALTER TABLE DEPT_COPY2 DROP COLUMN LOCATION_ID;
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_TITLE;

DESC DEPT_COPY2;

-- SQL Error [1090] [42000]: You can't delete all columns with ALTER TABLE; use DROP TABLE instead
-- 한 테이블에 반드시 하나 이상의 컬럼이 있어야한다
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_ID;



-- DROP
-- 객체 삭제
DROP TABLE DEPT_COPY2;


-- VIEW (뷰)
-- SELECT를 실행한 결과 화면을 담는 객체
-- 조회한 SELECT 문장 자체를 저장
-- 호출할때마다 해당 쿼리를 실행하여 결과를 보여주는 객체

-- 실질적으로 데이터를 저장하는 테이블이 아니다.
-- 일반 사용자에게 노출 하고싶은 정보나, 업무에 필요한 정보들만 조회 할 수 있게끔 제공

-- [사용형식]
-- CREATE [OR REPLACE]VIEW (뷰 이름) AS (서브쿼리) -> 뷰를 통해 확인할 SELECT문

-- VIEW 생성
CREATE OR REPLACE VIEW V_EMP AS SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE;

SELECT * FROM V_EMP;

SHOW CREATE VIEW V_EMP;


-- VIEW는 SELECT 쿼리를 저장하고 있기 때문에 원본 테이블의 값이 변경되면 뷰도 함께 변경되어 조회된다.

UPDATE EMPLOYEE SET EMP_NAME='biblee' WHERE EMP_ID="900";

SELECT * FROM EMPLOYEE;


-- VIEW 삭제
DROP VIEW V_EMP;



-- 뷰에 컬럼별 별칭 부여
CREATE OR REPLACE VIEW V_EMP(사번, 사원명, 부서코드) AS SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE;

SELECT * FROM V_EMP;


-- CREATE [OR REPLACE]VIEW (뷰 이름) AS (서브쿼리) -> 뷰를 통해 확인할 SELECT문
-- 실습2
-- 사번, 이름, 직급명, 부서명, 근무지역을 조회할 수 있는
-- V_RES_EMP 라는 뷰를 만들어
-- 뷰를 통해 그 결과를 조회

-- 1. 서브쿼리 준비
-- 2. 뷰 생성
-- 3. 결과 조회

SELECT * FROM EMPLOYEE;
CREATE TABLE SILSUB AS SELECT EMP_NO, EMP_NAME, JOB_CODE,DEPT_CODE,LOCAL_NAME 
FROM EMPLOYEE 
JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) 
JOIN LOCATION ON(LOCATION_ID= LOCAL_CODE);

SELECT * FROM SILSUB;

DROP VIEW SILSUB;

-- 1. 서브쿼리 준비
SELECT EMP_NO, EMP_NAME, JOB_NAME,DEPT_CODE,LOCAL_NAME 
FROM EMPLOYEE 
JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) 
JOIN LOCATION ON(LOCATION_ID= LOCAL_CODE)
JOIN JOB USING(JOB_CODE);

-- 2. 뷰 생성
CREATE OR REPLACE VIEW SILSUB_VIEW (사번,이름,직급명,부서명,근무지역) AS SELECT EMP_NO, EMP_NAME, JOB_NAME,DEPT_CODE,LOCAL_NAME 
FROM EMPLOYEE 
JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) 
JOIN LOCATION ON(LOCATION_ID= LOCAL_CODE)
JOIN JOB USING(JOB_CODE);

-- 3. 결과 조회
SELECT * FROM SILSUB_VIEW;

SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;
SELECT * FROM LOCATION;




-- AUTO INCREMENT : INSERT 할때마다 자동으로 키를 1씩 증가
CREATE TABLE AT_TEST(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(30)
);

INSERT INTO AT_TEST VALUES(1,'BIBLEE');

SELECT * FROM AT_TEST;


SELECT * FROM AT_TEST;

INSERT INTO AT_TEST VALUES(NULL,'SUNGHYUN');

SELECT * FROM AT_TEST;

INSERT INTO AT_TEST VALUES(NULL,'SUNGHYUN');

SELECT * FROM AT_TEST;


-- 문제 만들기
-- 10~15문제
-- SELECT문 연습문제 만드시면 됩니다.(EMPLOYEE 같은 테이블 활용)
-- 필요하ㄷ면 CREATE를 통해 생성한 테이블을 활용한 문제도 가능 , 단! 테이블에 대한 내용도 추가
-- 정답도 같이 작성하여 제출
-- 기간: 월요일 아침 9시까지
-- 제출 링크 : 당일날 공지
-- 제출 형식 : .TXT , .SQL , .HWP , .DOC 다 가능함



DROP TABLE MYTEST;
-- 디비버에서 쿼리문 실행
CREATE TABLE MYTEST(
	MNO INT AUTO_INCREMENT PRIMARY KEY,
	MNAME VARCHAR(20) NOT NULL ,
	NICKNAME VARCHAR(20) NOT NULL
);

INSERT INTO MYTEST VALUES(NULL,'CHO','CSH');
SELECT * FROM MYTEST;

-- --------------------------

DROP TABLE MVCBOARD;

CREATE TABLE MVCBOARD(
	SEQ INT AUTO_INCREMENT PRIMARY KEY,
	WRITER VARCHAR(30) NOT NULL,
	TITLE VARCHAR(1000) NOT NULL,
	CONTENT VARCHAR(2000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MVCBOARD VALUES(NULL,'관리자','테스트중','테스트1234 ABCD',NOW());
INSERT INTO MVCBOARD VALUES(NULL,'조성현','살려주세요','머리가 아파요',NOW());

SELECT * FROM MVCBOARD;


DROP TABLE MYMVCBOARD;

CREATE TABLE MYMVCBOARD(
	SEQ INT AUTO_INCREMENT PRIMARY KEY,
	WRITER VARCHAR(100) NOT NULL,
	TITLE VARCHAR(1000) NOT NULL,
	CONTENT VARCHAR(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MYMVCBOARD VALUES(NULL,'관리자','테스트중','테스트중 입니다',NOW());

SELECT * FROM MYMVCBOARD;



