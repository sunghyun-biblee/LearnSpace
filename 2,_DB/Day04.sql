-- 행 번호 매겨보자
-- RANK(), DENSE_RANK() 함수
-- RANK() : 동일한 순번이 있을 경우 이후의 순번은 이전 동일한 순번의 개수만큼 건너 뛰고 순번을 매기는 함수

-- 1
-- 2
-- 3
-- 4
SELECT EMP_NAME,SALARY, RANK() OVER(ORDER BY SALARY DESC)순위 FROM EMPLOYEE;

-- 급여 TOP3 조회
SELECT * FROM (SELECT EMP_NAME,SALARY, RANK() OVER(ORDER BY SALARY DESC)순위 FROM EMPLOYEE) A 
WHERE 순위<4;


SELECT EMP_NAME,SALARY, RANK() OVER(ORDER BY SALARY DESC)순위 FROM EMPLOYEE LIMIT 3; -- LIMIT : SELECT 되는 갯수를 제한해두는 함수


-- DENSE_RANK() : 동일한 순번이 있을 경우 이후 순번에 영향을 미치지 안는 함수
-- 1
-- 2
-- 2
-- 3
SELECT EMP_NAME,SALARY,DENSE_RANK() OVER(ORDER BY SALARY DESC)순위 FROM EMPLOYEE;



-- ROW NUMBER() : 그냥 넘버링, 동일 순번은 무시, 
-- 1,2,3,4....
SELECT EMP_NAME,SALARY,ROW_NUMBER() OVER(ORDER BY SALARY DESC) 번호 FROM EMPLOYEE;


-- --------------------------변수 @ROWNO 선언하여 1씩 증가시키며 SELECT (자바 x+=와 비슷)
SET @ROWNO := 0;
SELECT @ROWNO :=@ROWNO+1 AS ROWNUM, EMP_ID,EMP_NAME,SALARY FROM EMPLOYEE; 
-- @ROWNO을 초기화하고 실행해야는 번거로움이 있다
-- -------------------------- 


-- 부서별 급여 합계가 전체부서 급여 종합의 
-- 20% 보다 많은 부서의 부서명과 부서급여 합계를 조회

-- [1] 단일행 서브쿼리
SELECT SUM(SALARY)*0.2 FROM EMPLOYEE; -- 1. 전체 급여 합계의 20% 조회 

SELECT DEPT_CODE , SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING SUM(SALARY)>(SELECT SUM(SALARY)*0.2 FROM EMPLOYEE);


-- [2] 인라인뷰 활용
-- 서브쿼리
SELECT DEPT_cODE,SUM(SALARY) FROM EMPLOYEE GROUP BT DEPT_CODE;

SELECT * FROM(SELECT DEPT_CODE,SUM(SALARY) SUMSAL FROM EMPLOYEE GROUP BY DEPT_CODE) A WHERE SUMSAL > (SELECT SUM(SALARY)*0.2 FROM EMPLOYEE);

-- [3] 상호연관 쿼리 : 상관커리
-- 메인 쿼리가 사용하는 컬럼값, 계산식 등을 서브쿼리에 적용하여
-- 서브쿼리 실행 시 메인쿼리의 값도 함께 사용하는 방식

-- 사원의 직급에 따른 급여 평균보다, 많이 받는 사원의 정보 조회

SELECT AVG(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE;

SELECT EMP_ID, EMP_NAME,JOB_CODE, SALARY FROM EMPLOYEE E WHERE SALARY>(SELECT AVG(SALARY) FROM EMPLOYEE M WHERE E.JOB_CODE=M.JOB_CODE);     -- <=나와 같은 JOB_CODE인 사원의 평균 



-- 연습 (SELECT)
-- 모든 사원의 사번,사원명,관리자 사번, 관리자명을 조회
-- 관리자가 없으면 '없음' 조회, 단 SELECT 문에 서브쿼리를 사용하여 조회
SELECT EMP_ID, EMP_NAME,MANAGER_ID,IFNULL((SELECT EMP_NAME FROM EMPLOYEE M WHERE E.MANAGER_ID=M.EMP_ID),'없음') 관리자명 FROM EMPLOYEE E ORDER BY 4;

-- 상관ㄱ커리 + 단일행 ==> 스칼라 서브쿼리 : 보통 SELECT절에 많이 사용, SELECT LIST라고도 한다.






-- DDL--
-- CREATE : 데이터 베이스의 객체를 생성하는 DDL
-- [사용형식]
-- CREATE 객체형태 객체명 (관련 내용)

-- 예) 테이블 생성
-- CREATE TABLE TB_TEST(
-- 		컬럼 자료형(길이) 제약조건,
-- 		...
-- 	);

-- 제약조건 : 테이블에 데이터를 저장하고자 할 때 지켜야 하는 규칙
-- NOT NULL : NULL 값을 허용하지 않는다 (데이터 필수 입력)
-- UNIQUE : 중복 값을 허용하지 않는다.
-- CHECK : 지정한 입력 사항 외에는 저장하지 못한다.
-- PRIMARY KET* - 주 식별자 (NOT NULL + UNIQUE)  : 테이블 내에서 해당 ROW를 인식할 수 있는 고유의 값 / 테이블 내에서 단 1개만 존재할 수 있다
-- FOREIGN KEY - 외래 키 : 다른 테이블에서 저장된 값을 연결 지어서 참조로 가져오는 데이터에 지정하는 제약조건
	
	
	
-- 테이블생성 --
-- 데이터저장을 위한 틀 (객체)
-- 데이터들을 2차원의 표 형태로 담을 수 있는 객체
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
	MEMBER_NO INT,
	MEMBER_ID VARCHAR(20),
	MEMBER_PWD VARCHAR(20),
	MEMBER_NAME VARCHAR(15) COMMENT '회원이름'
);
SELECT * FROM MEMBER;
SHOW TABLES;

-- 컬럼 주석 확인
SHOW FULL COLUMNS FROM MEMBER;

-- 컬럼에 주석 달기
ALTER TABLE MEMBER MODIFY MEMBER_NO INT COMMENT '회원번호';
ALTER TABLE MEMBER MODIFY MEMBER_ID VARCHAR(30) COMMENT '회원 아이디';

SHOW FULL COLUMNS FROM MEMBER;

SELECT TABLE_NAME,COLUMN_NAME,COLUMN_COMMENT FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='MEMBER';

-- 컬럼 타입 --
-- 숫자 문자 날짜
-- 숫자 : INT , INTEGER , FLOAT , DOUBLE, NUMBER
-- 문자 : CHAR, VARCHAR , TEXT , BLOB
-- 날짜 : DATE, TIME, DATETIME


-- 제약조건 (CONSTRAINTS) --
-- 테이블에 각 컬럼마다 값을 기록하는것에 제약사항을 설정할 때 사용하는 조건

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE CONSTRAINT_SCHEMA='multi'


-- NOT NULL
-- 'NULL 값을 허용하지 않는다'
-- 해당 제약조건을 추가한 컬럼에 반드시 값을 기록해야 하는 경우
-- 데이터 삽입/수정/삭제 시에 NULL 값을 허용하지 않도록 컬럼 작성시 함께 작성

DROP TABLE USER_NOCONS;

CREATE TABLE USER_NOCONS(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PWD VARCHAR(20),
	USER_NAME VARCHAR(15)
);

SELECT * FROM USER_NOCONS;

-- 테이블에 값 추가하기
-- DML : INSERT

INSERT INTO USER_NOCONS VALUES(1,'USER01','PASS01','홍길동');
INSERT INTO USER_NOCONS VALUES(2,'USER02','PASS02','홍동길');
INSERT INTO USER_NOCONS VALUES(3,'USER03','PASS03','길홍동');
INSERT INTO USER_NOCONS VALUES(4,'USER04','PASS04','길동홍');
INSERT INTO USER_NOCONS VALUES(5,NULL,NULL,NULL);
SELECT * FROM USER_NOCONS;


CREATE TABLE USER_NOT_NULL(
	USER_NO INT NOT NULL,
	USER_ID VARCHAR(20) NOT NULL,
	USER_PWD VARCHAR(20) NOT NULL,
	USER_NAME VARCHAR(15) NOT NULL
);

DESC USER_NOT_NULL;
DESC USER_NOCONS;

INSERT INTO USER_NOT_NULL VALUES(1,'USER01','PASS01','BIBLEE');
SELECT * FROM USER_NOT_NULL;

INSERT INTO USER_NOT_NULL VALUES(2,NULL,NULL,NULL);
SELECT * FROM USER_NOT_NULL;
	

-- UNIQUE 제약 조건
-- 중복을 허용하지 않는 제약조건

INSERT INTO USER_NOCONS VALUES(1,'USER01','PASS01','홍길동');
SELECT * FROM USER_NOCONS;

CREATE TABLE USER_UNIQUE(
	USER_NO INT,
	USER_ID VARCHAR(20) UNIQUE, -- 컬럼레벨 제약조건 : 컬럼옆에 명시하는 것
	USER_PWD VARCHAR(20),
	USER_NAME VARCHAR(15),
	UNIQUE(USER_NO)  -- 테이블레벨 제약조건 : 따로 UNIQUE함수를 사용하여 명시
);
DROP TABLE USER_UNIQUE;

INSERT INTO USER_UNIQUE VALUES(1,'USER01','PASS01','홍길동');
SELECT * FROM USER_UNIQUE;

-- SQL Error [1062] [23000]: Duplicate entry 'USER02' for key 'USER_UNIQUE.USER_ID''
INSERT INTO USER_UNIQUE VALUES(1,'USER02','PASS02','BIBLEE');
-- SQL Error [1062] [23000]: Duplicate entry '1' for key 'USER_UNIQUE.USER_NO'
INSERT INTO USER_UNIQUE VALUES(2,'USER01','PASS01','홍길동');

SELECT * FROM USER_UNIQUE;


-- UNIQUE 제약조건 여러개 컬럼에 적용하기
-- A1 -- 200
-- A1 -- 201
-- B1 -- 200
-- B1 -- 201
-- 두 개 이상의 컬럼을 제약조건으로 묶을 경우
-- 반드시 테이블레벨에서 제약조건을 선언해야 한다

CREATE TABLE USER_UNIQUE2(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PWD VARCHAR(20),
	USER_NAME VARCHAR(15),
	UNIQUE(USER_NO,USER_ID)
);

DESC USER_UNIQUE2;

INSERT INTO USER_UNIQUE2 VALUES(1,'USER01','PASS01','홍길동');
INSERT INTO USER_UNIQUE2 VALUES(1,'USER02','PASS02','김길동');
INSERT INTO USER_UNIQUE2 VALUES(2,'USER01','PASS03','최길동');
INSERT INTO USER_UNIQUE2 VALUES(2,'USER02','PASS04','이길동');

SELECT * FROM USER_UNIQUE2;


-- CHECK 제약조건
-- 값을 저장할 때 컬럼에 지정한 값 이외에는
-- 값이 기록되지 않도록 범위를 제한하는 조건
-- [사용형식]
-- EX) CHECK(GENDER IN ('M','F'))
-- EX) CHECK(UESR_ID IS NOT NULL)

CREATE TABLE USER_CHECK(
	USER_NO INT,
	USER_ID VARCHAR(20),
	USER_PWD VARCHAR(20),
	USER_NAME VARCHAR(15),
-- 	GENDER VARCHAR(10) CHECK(GENDER IN('남','여')) -- 컬럼레벨
	GENDER VARCHAR(10),
	CONSTRAINT CK_GENDER CHECK(GENDER IN('남','여')) -- 테이블레벨
-- 제약조건의 이름 추가
	);


DESC USER_CHECK;


INSERT INTO USER_CHECK VALUES(1,'USER01','PASS01','홍길동','남');
INSERT INTO USER_CHECK VALUES(2,'USER02','PASS02','BIBLEE','남');

-- SQL Error [3819] [HY000]: Check constraint 'CK_GENDER' is violated.
INSERT INTO USER_CHECK VALUES(3,'USER03','PASS03','홍길순','여자');
-- SQL Error [3819] [HY000]: Check constraint 'CK_GENDER' is violated.
INSERT INTO USER_CHECK VALUES(3,'USER03','PASS03','홍길순','F');

SELECT * FROM USER_CHECK;
-- 제약조건 확인
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE TABLE_NAME='USER_CHECK';



-- CHECK 제약조건 부등호로 표기
CREATE TABLE TEST_CHECK(
	TEST_DATA INT,
	CONSTRAINT CK_TEST_DATA CHECK(TEST_DATA>0 AND TEST_DATA<100)
);




INSERT INTO TEST_CHECK VALUES(10);

-- SQL Error [3819] [HY000]: Check constraint 'CK_TEST_DATA' is violated.
INSERT INTO TEST_CHECK VALUES(-10); -- CHECK 제약조건에 의해 음수는 들어가지 않는다
-- SQL Error [3819] [HY000]: Check constraint 'CK_TEST_DATA' is violated.
INSERT INTO TEST_CHECK VALUES(110); -- CHECK 제약조건에 의해 100이상의 수는 들어가지 않는다

SELECT * FROM TEST_CHECK;


-- PRIMARY KEY 제약조건
-- '기본 키 제약조건'
-- 테이블 내의 한 행에서 그 행을 식별하기위한 고유값을 가지는 컬럼
-- NOT NULL 과 UNIQUE제약조건을 함께 걸어준다
-- 테이블 전체에 대한 각 데이터(ROW)의 식별자 역할을 수행시키는 제약조건
-- 기본키로 선언된 컬럼은 반드시 값이 들어가고, 중복이 있으면 안된다.
-- 기본키 제약조건 테이블에서 한개 존재, 한 컬럼에 적용가능한 것 뿐만 아니라 여러컬럼을 묶어서도 적용 가능

CREATE TABLE USER_PK_TABLE(
	USER_NO INT PRIMARY KEY,
	USER_ID VARCHAR(20) UNIQUE NOT NULL,  -- 중복x , 널값 안받음
	USER_PWD VARCHAR(20) NOT NULL, -- 널값 안받음
	USER_NAME VARCHAR(15) NOT NULL -- 널값 안받음
);


DESC USER_PK_TABLE;

INSERT INTO USER_PK_TABLE VALUES(1,'USER01','PASS01','홍길동');
INSERT INTO USER_PK_TABLE VALUES(2,'USER02','PASS02','김길동');
-- SQL Error [1062] [23000]: Duplicate entry '1' for key 'USER_PK_TABLE.PRIMARY' 
INSERT INTO USER_PK_TABLE VALUES(1,'USER03','PASS04','최길동'); -- PRIMARY KEY가 중복이다
-- SQL Error [1048] [23000]: Column 'USER_NO' cannot be null
INSERT INTO USER_PK_TABLE VALUES(NULL,'USER03','PASS04','최길동'); -- 기본키(PRIMARY KEY) 제약조건을 설정하면 NOT NULL 과 UNIQUE가 자동으로 함께 설정

SELECT * FROM USER_PK_TABLE;

-- 여러 컬럼에 기본키 제약조건 적용
CREATE TABLE USER_PK_TABLE2(
	USER_NO INT,
	USER_ID VARCHAR(20) UNIQUE,
	USER_PWD VARCHAR(20) NOT NULL,
	USER_NAME VARCHAR(15) NOT NULL,
	CONSTRAINT PK_USER_NO2 PRIMARY KEY(USER_NO, USER_ID)
);

DESC USER_PK_TABLE2;

-- 1, USER 01 - INSERT 성공 
-- 2, USER 02 - INSERT 성공
-- 1, USER 03 - INSERT 성공
-- 2, USER 01 - INSERT 실패




-- DROP은 테이블을 삭제하는 명령어
DROP TABLE MEMBER;

-- 실습 1
-- MEMBER 테이블을 생성하여
-- 사용자 정보를 받을 수 있는 테이블 객체를 만들자
-- 회원번호 : INT, 기본키
-- 회원아이디: VARCHAR, 중복불가, 필수 입력사항
-- 회원비밀번호 : VARCHAR, 필수 입력사항
-- 회원 이름: VARCHAR, 
-- 성별 : VARCHAR, (M,F)만 입력 
-- 회원연락처 : VARCHAR
-- 생년월일 : VARCHAR
-- 의 정보를 받을 수 있는 컬럼을 가진 테이블 생성
-- 각 컬럼의 이름과 길이는 직접 판단하고, 생성된 테이블 기준으로 회원정보 5개 이상 입력 (INSERT) 후 확인(SELECT) 

CREATE TABLE MEMBER_TABLE3(
	USER_NO INT PRIMARY KEY,
	USER_ID VARCHAR(20) UNIQUE NOT NULL,
	USER_PWD VARCHAR(20) NOT NULL,
	USER_NAME VARCHAR(10),
	GENDER VARCHAR(5)
	CONSTRAINT CK_GENDER2 CHECK(GENDER IN('M','F')),
	USER_PHONE VARCHAR(15),
	USER_BIRTHDAY  VARCHAR(15)
-- 	변수들을 만들어두고 , 제약조건은 마지막에 작성해도 무관하다
-- 	CONSTRAINT PK_MEMBER_MNO PRIMARY KEY(M_NO),
-- 	CONSTRAINT UK_MEMBER_MID UNIQUE(M_ID),
-- 	CONSTRAINT CK_MEMBER_MGEN CHECK(M_GENDER IN('M','F'))
);


DESC MEMBER_TABLE3;

INSERT INTO MEMBER_TABLE3 VALUES(1,'USER-1','PASS01','홍길동','M','010-1111-1111','99/12/31');
INSERT INTO MEMBER_TABLE3 VALUES(2,'USER-2','PASS02','최길동','M','010-2222-2222','98/11/30');
INSERT INTO MEMBER_TABLE3 VALUES(3,'USER-3','PASS03','김길동','F','010-3333-3333','97/10/29');
INSERT INTO MEMBER_TABLE3 VALUES(4,'USER-4','PASS04','이길동','F','010-4444-4444','96/09/28');
INSERT INTO MEMBER_TABLE3 VALUES(5,'USER-5','PASS05','한길동','M','010-5555-5555','95/08/27');


SELECT * FROM MEMBER_TABLE3;


-- FOREIGN KEY 제약조건
-- 외래키, 외부키 ,참조키라고 한다
-- 다른 테이블의 컬럼값을 참조하여
-- 참조하는 테이블의 값만 허용한다
-- 해당 제약조건을 통해 다른 테이블과의 관계(RELATIONSHIP)가 형성


-- 참조하고자 하는 컬럼은 반드시 PRIMARY KEY 이거나, UNIQUE 제약조건이 걸려있어야한다.
-- 단순하게 어떤 테이블을 참조한다면 PK가 참조되며 명확하게 컬럼을 지정해주어야한다
-- 참조해야할 컬럼이 어떤 컬림인지 모르기 때문에 반드시 PRIMARY KEY , UNIQUE를 명시해주어야 한다
CREATE TABLE USER_GRADE(
	GRADE_CODE INT PRIMARY KEY,
	GRADE_NAME VARCHAR(20) NOT NULL
);

INSERT INTO USER_GRADE VALUES(1,'일반 회원');
INSERT INTO USER_GRADE VALUES(2,'VIP 회원');
INSERT INTO USER_GRADE VALUES(3,'VVIP 회원');
INSERT INTO USER_GRADE VALUES(4,'XVIP 회원');

SELECT * FROM USER_GRADE;

CREATE TABLE USER_FOREIGN_KEY(
	USER_NO INT PRIMARY KEY,
	USER_ID VARCHAR(20),
	USER_PWD VARCHAR(20),
	USER_NAME VARCHAR(15),
-- 	GRADE_CODE INT REFERENCES USER_GRADE(GRADE_CODE) -- 컬럼레벨 / -- REFERENCES : 참조한다
	GRADE_CODE INT,
	CONSTRAINT FK_GRADE_CODE FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE(GRADE_CODE)  -- 테이블레벨
);

DESC USER_FOREIGN_KEY;

SELECT * FROM USER_FOREIGN_KEY;


INSERT INTO USER_FOREIGN_KEY VALUES(1,'123','321','홍길동',2);
INSERT INTO USER_FOREIGN_KEY VALUES(2,'ABC','ABC1','노길동',4);
INSERT INTO USER_FOREIGN_KEY VALUES(3,'asb','asb1','현길동',1);
INSERT INTO USER_FOREIGN_KEY VALUES(4,'lost','lost1','이길동',3);
INSERT INTO USER_FOREIGN_KEY VALUES(5,'ark','ark1','최길동',1);

SELECT * FROM USER_FOREIGN_KEY;
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails (`multi`.`USER_FOREIGN_KEY`, CONSTRAINT `FK_GRADE_CODE` FOREIGN KEY (`GRADE_CODE`) REFERENCES `USER_GRADE` (`GRADE_CODE`))
-- 참조하고있는 테이블에 추가 or 수정이 불가능하다. / ! 외래키 제약조건에 위배되었다.
-- 외래키로 지정된 GRADE_CODE는 참조하는 USER_GRADE 테이블의 GRADE_CODE 컬럼에 있는 데이터만 INSERT 가능!!
INSERT INTO USER_FOREIGN_KEY VALUES(6,'mokoko','mokoko1','최길동',10);

SELECT * FROM USER_FOREIGN_KEY JOIN USER_GRADE USING(GRADE_CODE);
SELECT * FROM USER_FOREIGN_KEY F JOIN USER_GRADE M ON(F.GRADE_CODE=M.GRADE_CODE);




-- 
DELETE FROM USER_GRADE
WHERE GRADE_CODE=4;

SELECT * FROM USER_GRADE;
SELECT * FROM USER_FOREIGN_KEY;

-- 참조되는 테이블의 컬럼은 기본적으로 삭제가 불가능하다.


-- 삭제 옵션
-- 참조되는 테이블의 컬럼 값이 삭제/수정 될때
-- 참조하는 값을 어떻게 처리할 것인지 설정하는 옵션


DROP TABLE USER_FOREIGN_KEY;
DROP TABLE USER_GRADE;
-- USER GRADE를 참조하는 테이블이 존재하므로 함부로 삭제 불가능하다
-- 참조를 하는 USER_FOREIGN_KEY 테이블 삭제 후 USER_GRADE 삭제 가능



-- UPDATE : UPDATE (테이블명) SET
CREATE TABLE USER_FOREIGN_KEY(
	USER_NO INT PRIMARY KEY,
	USER_ID VARCHAR(20),
	USER_PWD VARCHAR(20),
	USER_NAME VARCHAR(15),
	GRADE_CODE INT,
	CONSTRAINT FK_GRADE_CODE FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE(GRADE_CODE) ON UPDATE CASCADE ON DELETE CASCADE
-- 	 ON UPDATE CASCADE ON DELETE CASCADE :  데이터가 변경되거나 삭제되면 똑같이 변경과 삭제 되도록 옵션을 추가함
);

INSERT INTO USER_FOREIGN_KEY VALUES(1,'123','321','홍길동',2);
INSERT INTO USER_FOREIGN_KEY VALUES(2,'ABC','ABC1','노길동',4);
INSERT INTO USER_FOREIGN_KEY VALUES(3,'asb','asb1','현길동',1);
INSERT INTO USER_FOREIGN_KEY VALUES(4,'lost','lost1','이길동',3);
INSERT INTO USER_FOREIGN_KEY VALUES(5,'ark','ark1','최길동',1);

SELECT * FROM USER_FOREIGN_KEY;

SELECT * FROM USER_FOREIGN_KEY JOIN USER_GRADE USING(GRADE_CODE);


UPDATE USER_GRADE SET GRADE_CODE= 10 WHERE GRADE_CODE=1;

SELECT * FROM USER_GRADE;
SELECT * FROM USER_FOREIGN_KEY;

DELETE FROM USER_GRADE WHERE GRADE_CODE=10;

SELECT * FROM USER_GRADE;
SELECT * FROM USER_FOREIGN_KEY;



-- SUBQUERY 활용한 테이블 만들기
-- 테이블을 복사할때 컬럼명, 데이터 타입, 값, NOT NULL은 복사 가능하지만
-- 다른 제약조건은 복사되지않는다. (PRIMARY KEY, FOREIGN KEY ...) 

CREATE TABLE EMPLOYEE_COPY AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY;

DESC EMPLOYEE;
DESC EMPLOYEE_COPY;

-- 테이블의 형식만 복사
-- 테이블의 값을 제외한 형식 복사

CREATE TABLE EMPLOYEE_COPY2 AS SELECT * FROM EMPLOYEE WHERE 1=2;
SELECT * FROM EMPLOYEE_COPY2; -- 형식만 복사하는 테이블로 데이터는 아무것도 없다

-- 1=2 : 일치하지 않는 경우를 조건으로 SELECT 되는 로우가 하나도 없다 / 형식만 복사하기 위해 데이터를 조회하지 않도록 조건값을 어떠한것도 일치하지 않게 명시한 것


-- 특정 컬럼만 복사 (원하는 컬럼만 복사)
DROP TABLE EMPLOYEE_COPY3;
CREATE TABLE EMPLOYEE_COPY3 AS SELECT EMP_ID,EMP_NAME,EMP_NO,EMAIL,HIRE_DATE,SALARY '급여' FROM EMPLOYEE WHERE SALARY > 3500000;
SELECT * FROM EMPLOYEE_COPY3;


-- 테이블 생성시 기본값 설정
DROP TABLE DEFAULT_TABLE;
CREATE TABLE DEFAULT_TABLE(
	COL1 VARCHAR(30) DEFAULT '없음',
	COL2 DATE DEFAULT (CURRENT_DATE),-- NOW() 사용해도 무관
	COL3 DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO DEFAULT_TABLE VALUES(DEFAULT,DEFAULT,DEFAULT); -- 테이블 생성후 INSERT로 기본값(DEFAULT)을 넣어주어야 데이터가 생성된다

SELECT * FROM DEFAULT_TABLE;

DESC DEFAULT_TABLE;
DESC EMPLOYEE;


