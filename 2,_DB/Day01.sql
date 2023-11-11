-- 실행 : 실행하려는 명령어로 커서를 이동시키고 ( CTRL + ENTER ) 키 OR ( ALT + x ) 
SHOW TABLE;

-- 테이블 생성
CREATE TABLE STUDENTS(
	ID INT,
	NAME VARCHAR(100),
	PHONE CHAR(13),
	ADDRESS VARCHAR(1000)
);

SHOW TABLES;

SELECT * FROM EMPLOYEE;	

-- SELECT 문 --
-- SELECT : 조회용 SQL 문장
-- [사용법]	 (*은 모든 것을 의미)
-- SELECT 컬럼,컬럼,...  : 조회하고자 하는 내용
-- FROM 테이블명         : 조회하고자 하는 테이블명
-- [WHERE 조건]         : 특정 조건
-- [ORDER BY 컬럼]      : 정렬
-- ;


-- EMPLOYEE 테이블의 모든행과 모든컬럼 조회
SELECT * FROM EMPLOYEE;
-- 행,컬럼은 WHERE를 적지 않으면 모두 출력한다

-- 모든 사원의 아이디(EMP_ID)와 사원명(EMP_NAME), 연락처(PHONE)만 조회
SELECT EMP_ID, EMP_NAME, PHONE 
FROM EMPLOYEE;  

-- WHERE 구문(절)
-- 테이블에서 조건을 만족하는 값을 가진 행을
-- 따로 선택하여 조회하는 조건절
-- AND, OR 명령어를 함께 사용

-- 부서코드가 'D6'인 사원들의 정보를 모두 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D6';


-- 실습1
-- 직급이 'J1'인 사원의 사번(EMP_ID),사원명(EMP_NAME),직급코드(JOB_CODE). 부서코드(DEPT_CODE)를 조회
SELECT EMP_ID, EMP_NAME,JOB_CODE,DEPT_CODE FROM EMPLOYEE WHERE JOB_CODE='J1';


-- '', "" => 문자

-- 실습2
-- EMPLOYEE 테이블에서 급여(SALARY)가 300만원 이상인
-- 사원의 아이디, 사원명, 직급코드, 급여정보들을 조회
SELECT EMP_ID,EMP_NAME,JOB_CODE,SALARY FROM EMPLOYEE WHERE SALARY>=3000000;

-- 부서코드가 'D6' 이면서, 이름이 '유재식'인 사원의 모든 정보를 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D6' AND EMP_NAME='유재식';


-- 컬럼명에 별칭(별명) 달기
DESC EMLPOLYEE;

-- 1.AS(alias) 표현
SELECT EMP_ID AS"사원번호", EMP_NAME AS "사원명" FROM EMPLOYEE;

-- 2.AS 생략 ("",''를 생략하고 작성할땐 SPACE:띄워쓰기는 적용되지 않는다)
SELECT EMP_ID 사번, EMP_NAME 사원명 FROM EMPLOYEE;


-- 실습3
-- EMPLOYEE 테이블에서 부서가 D2 이거나 D1인 사원들의 사원명, 입사일 ,연락처 조회 ( 단 , 조회하는 컬럼에 별칭 부여)
SELECT EMP_NAME AS "사원명",HIRE_DATE AS "입사일", PHONE AS "연락처"	FROM EMPLOYEE WHERE DEPT_CODE='D2' OR DEPT_CODE='D1'


-- 사원들의 연봉 조회
SELECT
	EMP_NAME "사원명",
	SALARY "월급", -- 월급
	(SALARY * 12) "연봉",-- 연봉 (SELECT로 가져온 값을 연산처리하여 가져올수 있다)
	BONUS "보너스",
	(SALARY + (SALARY*BONUS)) * 12 "연봉총합"
FROM
	EMPLOYEE;
	

-- 컬럼 값이 만약 NULL 이라면
-- 어떠한 연산을 처리해도 결과는 NULL 이다

-- IFNULL() : 만약 현재 조회한 값이 NULL인 경우 별도로 설정한 값으로 변경한다
-- IFNULL(컬럼, 기본값)

SELECT
	BONUS,
	IFNULL(BONUS, 0)
FROM
	EMPLOYEE;

SELECT
	EMP_NAME "사원명",
	SALARY "월급", 
	(SALARY * 12) "연봉",
	BONUS "보너스",
	(SALARY + (SALARY * IFNULL(BONUS, 0))) * 12 "연봉총합"
FROM
	EMPLOYEE;
	
-- DISTINCT (중복제거)
-- 해당하는 값이 컬럼에 여러 개 존재할 경우
-- 중복을 제거하고 한개만 조회 (NULL도 포함하여 중복제거)
SELECT DEPT_CODE FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE , EMP_NAME FROM EMPLOYEE;


-- 실습 4
-- DEPARTMENT 테이블을 참조하여, 
-- 부서가 '해외영업2부'인 부서의 부서코드를 찾고,
-- EMPLOYEE 테이블에서 해당 부서의
-- 사원들 중 급여를 200만원보다 많이 받는 직원의
-- 사번, 사원명, 급여를 조회하시오.
-- 1) '해외영업2부' 부서의 부서코드 찾기

-- 2) 조회한 부서 코드를 사용하여 
--    사원들 중 급여를 200만원보다 많이 받는 직원 조회하기

SELECT * FROM DEPARTMENT; 
SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_TITLE='해외영업2부'; -- D6
SELECT * FROM EMPLOYEE;

SELECT EMP_ID "사번", EMP_NAME "사원명", SALARY "급여" FROM EMPLOYEE WHERE SALARY>2000000 AND DEPT_CODE='D6';



-- 실습 5
-- 실습 3을 참고하여
-- 부서가 '해외영업2부'이거나
-- 급여를 200만원보다 많이 받는 직원의
-- 사번, 사원명, 급여를 조회 하시오.

SELECT EMP_ID "사번",EMP_NAME "사원명", SALARY "급여" FROM EMPLOYEE WHERE DEPT_CODE="D6" OR SALARY>2000000




DROP TABLE BIKE_TB;

CREATE TABLE BIKE_TB(
	ADDR_GU VARCHAR(4000),
	CONTENT_ID INT PRIMARY KEY,
	CONTENT_NM VARCHAR(4000),
	NEW_ADDR VARCHAR(4000),
	CRADLE_COUNT INT,
	LONGITUDE FLOAT,
	LATITUDE FLOAT
);

SELECT * FROM BIKE_TB;




DROP TABLE MYPRABOARD;

CREATE TABLE MYPRABOARD(
	SEQ INT AUTO_INCREMENT PRIMARY KEY,
	WRITER VARCHAR(100) NOT NULL,
	TITLE VARCHAR(1000) NOT NULL,
	CONTENT VARCHAR(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MYPRABOARD VALUES(NULL,'관리자','테스트중','테스트중 입니다',NOW());

SELECT * FROM MYPRABOARD;




