-- SELECT : 조회용 SQL

-- 데이터베이스에서 실행하고자 하는 명령 종류
-- CRUD : 데이터 기본 사항 처리 로직
-- CREAT  : 데이터 추가 / INTSERT
-- READ	  : 데이터 조회 / SELECT
-- UPDATE : 데이터 수정 / UPDATE
-- DELETE : 데이터 삭제 / DELETE

-- 연산자
-- 비교 연산자
-- <, > , <=, >= : 크기를 비교하는 부등호
-- = : 같다
-- != , <> : 같지않다

-- EMPLOYEE 테이블에서 부서코드가 'D9' 이 아닌 직원들의 모든 정보 조회

SELECT * FROM EMPLOYEE WHERE DEPT_CODE <> 'D9';

-- EMPLOYEE 테이블에서 급여가 350만원 이상 550만원이하인 직원의 사번, 사원명, 부서코드 , 직급코드, 급여 정보를 조회

-- 1.
SELECT EMP_ID '사번', EMP_NAME '사원명', DEPT_CODE '부서코드', JOB_CODE '직급코드', SALARY '급여' FROM EMPLOYEE WHERE SALARY>=3500000 AND SALARY<=5500000;


-- 2. BETWEEN A AND B 
SELECT EMP_ID '사번', EMP_NAME '사원명', DEPT_CODE '부서코드', JOB_CODE '직급코드', SALARY '급여' FROM EMPLOYEE WHERE SALARY BETWEEN 3500000 AND 5500000;

-- 급여가 350 미만 ,550 초과인 직원 정보 조회 (NOT BETWEEN : 조건의 반대를 출력)
SELECT EMP_ID '사번', EMP_NAME '사원명', DEPT_CODE '부서코드', JOB_CODE '직급코드', SALARY '급여' FROM EMPLOYEE WHERE SALARY NOT BETWEEN 3500000 AND 5500000;

-- LIKE : 입력한 숫자, 문자가 포함된 정보를 조회할 때 사용하는 연산자
-- ' _ ' : 임의의 한 문자
-- ' % ' : 몇자리 문자든 관계없이

-- EMPLOYEE 테이블에서 사원이름에 가운데 '중'이 들어가는 사원 정보 조회하기
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '_중_';

-- EMPLOYEE 테이블에서 주민번호를 기준으로 여성인 사원의 정보 조회
SELECT * FROM EMPLOYEE WHERE EMP_NO LIKE '______-2______'; -- ' _ ' 사용

SELECT * FROM EMPLOYEE WHERE EMP_NO LIKE '%-2%'; 	   -- ' % ' 사용

-- 실습1
-- 사원 중 이메일 아이디가
-- 5글자 초과하는 사원의
-- 사원명, 사번 , 이메일 정보를 조회

SELECT EMP_NAME '사원명', EMP_ID '사번', EMAIL '이메일' FROM EMPLOYEE WHERE EMAIL LIKE "______%@_or.kr";

-- 사원 중에 이메일 4번째 자리가 '_'인 사원 정보 조회
-- ESCAPE 문자를 선언하여 그 뒤에 오는 문자를 특수문자가 아닌 일반문자로 취급하여 사용
SELECT EMP_NAME '사원명',EMP_ID '사번',EMAIL '이메일' FROM EMPLOYEE WHERE EMAIL LIKE '___#_%@%' ESCAPE '#'; -- ESACPE 문자 뒤에오는 문자는 일반문자로 취급한다
	
-- IN 연산자
-- IN(값1, 값2, 값3, ...)
-- 안에 있는 값 중 하나라도 일치 하는 경우
-- 해당하는 값 조회

-- 부서코드가 D1 이거나 D6인 부서 직원 정보 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE IN ('D1','D6');
SELECT * FROM EMPLOYEE WHERE DEPT_CODE NOT IN ('D1','D6');


-- 함수 (Function)
-- 문자 관련 함수

-- LENGTH / CHAR_LENGTH
-- 문자열의 길이를 계산하는 함수
-- LENGTH : 길이를 BYTE 길이로 계산 (영어 1BYTE, 한글 3BYTE)
-- CHAR_LENGTH : 글자 수

SELECT LENGTH('HELLO'), CHAR_LENGTH('Hello');
SELECT LENGTH('조성현'), CHAR_LENGTH('조성현');

-- INSTR() : 주어진 값에서 원하는 문자가 몇번째인지 찾아 반환하는 함수
SELECT INSTR('AVCEA','A'),
	   INSTR('AVCEA','C'),
	   INSTR('AVCEA','F');
	   
SELECT EMAIL, INSTR(EMAIL,'@') FROM EMPLOYEE;


-- SUBSTR(컬럼명|값, 시작순번, 가져올 갯수) : 주어진 문자열에서 특정 부분만 꺼내오는 함수
SELECT 'HELLO WORLD', SUBSTR('HELLO WORLD ',1,5); -- HELLO WORLD를 가지고 1번째 부터 5개 가져오겠다
SELECT 'HELLO WORLD', SUBSTR('HELLO WORLD ',7); -- HELLO WROLD를 가지고 7번째부터 끝까지 가져온다

-- 실습2
-- EMPLOYEE 테이블에서
-- 사원들의 이름, 이메일 조회하되
-- 이메일은 아이디부분만 조회
-- 조회 결과--
-- 홍길동 hong-gd
SELECT INSTR(EMAIL,'@') FROM EMPLOYEE;
SELECT EMP_NAME '이름', SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)'EMAIL' FROM EMPLOYEE ;

-- LPAD/RPAD
-- 빈칸을 지정한 문자로 채우는 함수
SELECT LPAD(EMAIL,20,'#'),RPAD(EMAIL,20,'-') FROM EMPLOYEE;

-- LTRIM/RTRIM
-- 현재 부여된 컬럼이나, 값으로 부터 공백만 찾아 지워주는 함수

SELECT LTRIM('       HE LLO    ');
SELECT RTRIM('1     HE LLO1    ');

-- TRIM()
-- 주어진 컬럼이나, 값에서 양끝을 기준으로 특정 문자를 지워주는 함수
-- 기본형태
SELECT TRIM('0000HELLO0000');

-- 양 끝에서 특정값을 지우고자 할 때
SELECT TRIM('0' FROM '0000HELLO0000');
SELECT TRIM(' ' FROM '  1  HELLO   1  ');

-- LOWER/UPPER
-- 주어진 문자를 소문자, 대문자 형식으로 변경해주는 형식
SELECT LOWER('BIBLEE'),UPPER('biblee');

-- CONCAT() : 여러 문자열을 하나의 문자열로 합치는 함수
SELECT CONCAT('마이에스큐엘',' 재밌어요:?');
SELECT CONCAT(RPAD(SUBSTR(EMP_NAME,1,1),3,'*'),' 님') FROM EMPLOYEE;


-- REPLACE() : 주어진 문자열에서 특정 문자를 변경할 때 사용하는 함수
SELECT REPLACE('HELLO WORLD','HELLO','BYE');


-- 실습3
-- EMPLOYEE 테이블에서 사원의 주민번호를 확인하여
-- 생년, 생월, 생일을 각각 조회 하시오
-- 출력예시 : 이름 | 생년 | 생월 | 생일
--		    홍길동| 00년| 00월 | 00일
SELECT * FROM EMPLOYEE;

SELECT EMP_NAME ,CONCAT(SUBSTR(EMP_NO,1,2),' 년'),CONCAT(SUBSTR(EMP_NO,3,2),' 월'),CONCAT(SUBSTR(EMP_NO,5,2),' 일') FROM EMPLOYEE;

-- 실습 4
-- EMPOYEE 테이블에서
-- 사원의 사번, 사원명, 이메일, 주민번호를 조회.
-- 이 때, 이메일은 '@'전 까지, 
-- 주민번호는 7번째 자리 이후 '*'(000000-1******) 처리하여 조회

SELECT EMP_ID, EMP_NAME,SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)'EMAIL',RPAD(SUBSTR(EMP_NO,1,8),14,'*')FROM EMPLOYEE 





-- 실습 5
-- EMPLOYEE 테이블에서 현재 근무하는 
-- 여성 사원의 사번, 사원명, 직급코드를 조회.
-- **ENT_YN : 현재 근무 여부 파악하는 컬럼(퇴사여부)
-- **WHERE에 함수 사용 가능
SELECT * FROM EMPLOYEE;
SELECT EMP_NO,EMP_NAME,JOB_CODE FROM EMPLOYEE WHERE EMP_NO LIKE '%-2%' AND ENT_YN='Y';
-- where substr(emp_no,8,1)='2' and ent_yn='n'

-- 다중 행 함수 (Multiple Row Function) : 조건절에 만족하는 모든 행을 다 찾고나서 모든 로우를 한번에 연산

-- 그룹 함수(Group Function)
-- SUM(), AVG(), MAX(), MIN(), COUNT()

-- SUM(숫자가 기록된 컬럼) : 해당컬럼들의 합계
SELECT SUM(SALARY) FROM EMPLOYEE;

-- AVG() : 해당 컬럼들의  평균을 계산
SELECT AVG(SALARY) FROM EMPLOYEE;

-- MAX(), MIN() : 해당 컬럼들의 갑 중 최대값, 최소값을 계산
SELECT MAX(SALARY), MIN(SALARY) FROM EMPLOYEE;



-- EMPLOYEE 테이블에서 '해외영업1부'에 근무하는 모든 사원의 
-- 평균 급여, 가장 높은 급여, 낮은 급여, 급여 합계 조회

SELECT * FROM DEPARTMENT WHERE DEPT_TITLE ="해외영업1부";  -- D5

SELECT AVG(SALARY), MAX(SALARY),MIN(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5';

-- 에러
SELECT MAX(SALARY), EMP_NAME FROM EMPLOYEE;

-- COUNT(컬럼명 | *) : 행의 갯수

SELECT COUNT(*) FROM EMPLOYEE;
SELECT COUNT(EMP_NO) FROM EMPLOYEE;

-- NULL 값이 존재 할 경우 이를 계산하지 않는다
SELECT COUNT(DEPT_CODE) , COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE;

-- NULL 값을 포함하여 계산함
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

-- 날짜 처리 함수
-- SYSDATE(), NOW() : 현재 컴퓨터의 날짜를 반환하는 함수
SELECT SYSDATE(),NOW();



-- 두 날짜 사이의 차
-- DATEDIFF : 단순 일 차이
-- TIMESTAMPDIFF : 연, 분기, 월 주, 일 시 , 분 초를 지정하여 차이

SELECT HIRE_DATE "입사일",DATEDIFF(NOW(),HIRE_DATE) FROM EMPLOYEE;
SELECT HIRE_DATE "입사일",TIMESTAMPDIFF(YEAR,HIRE_DATE,NOW()) '입사 후 년 수' FROM EMPLOYEE;
SELECT HIRE_DATE "입사일",TIMESTAMPDIFF(MONTH,HIRE_DATE,NOW()) '입사 후 월 수' FROM EMPLOYEE;

/*
 * YEAR : 연
 * QUARTER : 분기
 * MONTH : 월
 * WEEK : 주
 * DAY : 일
 * HOUR : 시
 * MINUTE : 분
 * SECOND : 초
 */


-- EXTRACT (YEAR|MONTH|DATE FROM 날짜데이터)
-- : 지정한 날짜로 부터 원하는 날짜 값을 주출하는 함수

SELECT EXTRACT(YEAR FROM HIRE_DATE) ,EXTRACT(MONTH FROM HIRE_DATE), EXTRACT(DAY FROM HIRE_DATE) FROM EMPLOYEE;


-- DATE_FORMAT() : 날짜 정보(포맷) 변경
-- %H => 12시 -> 0시 
-- %h => 12시 -> 12시
SELECT
	HIRE_DATE,
	DATE_FORMAT(HIRE_DATE, '%Y%m%d%h%i%s'),
	DATE_FORMAT(HIRE_DATE, '%Y/%m/%d/ %H:%i:%s'),
	DATE_FORMAT(NOW(), '%Y/%m/%d/ %H:%i:%s') '현재'
FROM
	EMPLOYEE;
	
-- STR_TO_DATE()
SELECT STR_TO_DATE('20231010','%Y%m%d'),
       STR_TO_DATE('231010','%y%m%d'); -- DATE 값의 형식 과 포멧하는형식이 같은형식이어야 포멧된다


-- IF(조건, 참, 거짓)
-- 조건에 AND, OR 등을 통해 여러 조건을 가능
-- 현재 근무하는 직원들의 성별을 남, 여로 구분지어 출력하기
       
SELECT EMP_NAME,EMP_NO ,IF(SUBSTR(EMP_NO,8,1)='2',"여","남") '성별' FROM EMPLOYEE ORDER BY EMP_NAME DESC; 


-- 실습6
-- EMPLOYEE 테이블에서
-- 모든 직원의 사번, 사원명, 부서코드, 직급코드, 근무여부, 관리자 여부를 조회
-- 이 때, 근무 여부 : ENT_YN이 Y면 퇴사자 N이면 근무자
-- 관리자 여부 : MANAGER_ID가 있으면 사원, 없으면 관리자로 처리하여 조회
SELECT * FROM EMPLOYEE;
-- ID NAME DEPTCODE JOBCODE ENT_YN  MANAGER ID 
SELECT
	EMP_ID 사번,
	EMP_NAME 사원명,
	DEPT_CODE 부서코드,
	JOB_CODE 직급코드,
	IF(ENT_YN='Y', "퇴사자","근무자") 근무여부,
	IF(IFNULL(MANAGER_ID,0)=0,"관리자","사원") 관리자여부
FROM
	EMPLOYEE;
	

-- CASE 문
-- 자바의 IF,SWITCH 처럼 사용 가능한 함수 표현식


-- 사용법
-- CASE
-- WHEN(조건식1) THEN 결과값1
-- WHEN(조건식2) THEN 결과값2
-- ELSE 결과값3
-- END

-- 실습 6을 CASE를 이용하여 문제 해결
SELECT
	EMP_ID 사번,
	EMP_NAME 사원명,
	DEPT_CODE 부서코드,
	JOB_CODE 직급코드,
	CASE
		WHEN ENT_YN='Y'THEN '퇴사자'
		WHEN ENT_YN='N'THEN '근무자'
	END "근무여부",
	CASE
		WHEN MANAGER_ID IS NULL THEN '관리자'
		ELSE '사원'
	END "관리자 여부"
FROM
	EMPLOYEE;
	

-- MOD() : 주어진 컬럼이나 값을 나눈 "나머지"를 반환하는 함수
SELECT MOD(10,3),MOD(10,2),MOD(10,7);

-- ROUND() : 지정한 숫자를 반올림 할 때 사용하는 함수
SELECT
	ROUND(123.456, 0),
	ROUND(123.456, 1), -- 소수점 둘째자리 반올림
	ROUND(123.456, 2), -- 소수점 셋째자리 반올림
	ROUND(123.456, -2); -- 정수 둘째자리 반올림

	
-- CEIL() : 소수점 첫째 자리에서 올림하는 함수
-- FLOOR() : 소수점 이하 자리의 숫자를 버리는 함수
SELECT CEIL(123.456), FLOOR(123.456);

-- TRUNCATE() : 지정한 위치까지 숫자를 버리는 함수 (내림)
SELECT TRUNCATE(123.456,0),TRUNCATE(123.456,1),TRUNCATE(123.456,2),TRUNCATE(123.456,3),TRUNCATE(123.456,-2);

-- CEILING() : 소숫점 올림
SELECT CEILING(4.0),CEILING(4.1),CEILING(2.9);
SELECT CEILING(4.0),CEILING(-4.1),CEILING(-3.9);


-- 실습 7
-- EMPLOYEE 테이블에서 입사한 달의 숫자가 홀 수 달인 직원의 사번 , 사원명, 입사일 정보를 조회 (HIRE_DATE에 SUBSTR 활용)
SELECT * FROM EMPLOYEE; 
SELECT EMP_ID,EMP_NAME,HIRE_DATE FROM EMPLOYEE WHERE MOD(SUBSTR(HIRE_DATE,6,2),2)=1;




-- 함수 연습문제

-- 1. 직원명과 주민번호를 조회함
--  단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
--  예 : 홍길동 771120-1******
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME,RPAD(SUBSTR(EMP_NO,1,8),14,'*') FROM EMPLOYEE ;

-- 2. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
--   수 조회함.
--   사번 사원명 부서코드 입사일
SELECT DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE='D5' OR DEPT_CODE='D5';
SELECT EMP_NAME,DEPT_CODE,HIRE_DATE FROM EMPLOYEE WHERE (DEPT_CODE='D5' OR DEPT_CODE='D9') AND SUBSTR(HIRE_DATE,1,4)='2004';


-- 3. 직원명, 입사일, 입사한 달의 근무일수 조회
--   단, 주말도 포함함 ( LAST_DAY() : 주어진 날짜의 해당월의 마지막 날 반환 )

SELECT * FROM EMPLOYEE;
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE)'해당월 마지막날',DATEDIFF(LAST_DAY(HIRE_DATE) , HIRE_DATE)+1 '입사한달 근무일 수' FROM EMPLOYEE;

-- 4. 직원명, 부서코드, 생년월일, 나이 조회
--   단, 생년월일은 주민번호에서 추출해서 ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
SELECT
	EMP_NAME,
	DEPT_CODE,
	EMP_NO,
	DATE_FORMAT(STR_TO_DATE(SUBSTR(EMP_NO, 1, 6), '%y%m%d'), '%Y년%m월%d일') 생년월일,
	SUBSTR(SYSDATE(), 1, 4) - SUBSTR(STR_TO_DATE(SUBSTR(EMP_NO, 1, 6), '%y%m%d'), 1, 4)+ 1 나이,
	IF(EXTRACT(YEAR FROM NOW())-EXTRACT(YEAR FROM DATE_FORMAT(SUBSTR(EMP_NO, 1, 6), '%Y%m%d'))>0,
	EXTRACT(YEAR FROM NOW())-EXTRACT(YEAR FROM DATE_FORMAT(SUBSTR(EMP_NO, 1, 6), '%Y%m%d'))+ 1,
	EXTRACT(YEAR FROM NOW())-(EXTRACT(YEAR FROM DATE_FORMAT(SUBSTR(EMP_NO, 1, 6), '%Y%m%d'))- 101)) '억지로'
FROM
	EMPLOYEE;


SELECT SUBSTR(NOW(),1,4) ;
SELECT STR_TO_DATE(SUBSTR(EMP_NO,1,6),'%y%m%d')FROM EMPLOYEE;
select STR_TO_DATE(now(),'%Y%m%d%H%i%s'); 
SELECT SUBSTR(EMP_NO,1,6) FROM EMPLOYEE;
SELECT STR_TO_DATE(sysdate(),'%Y%m%d');
SELECT now()-STR_TO_DATE(SUBSTR(EMP_NO,1,6),'%y%m%d%h%i%s') FROM EMPLOYEE;
SELECT DATE_FORMAT(SUBSTR(EMP_NO,1,6),'%Y%m%d') ,EMP_NO FROM EMPLOYEE;
SELECT EXTRACT(YEAR FROM NOW())-(EXTRACT(YEAR FROM DATE_FORMAT(SUBSTR(EMP_NO, 1, 6), '%Y%m%d'))- 101) FROM EMPLOYEE;

-- 5.  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회함
--  => case 사용
SELECT * FROM EMPLOYEE;
SELECT
	* ,
	CASE
		WHEN DEPT_CODE='D5' THEN '총무부'
		WHEN DEPT_CODE='D6' THEN '기획부'
		WHEN DEPT_CODE='D9' THEN '영업부'
	END "근무부서"
	FROM EMPLOYEE WHERE DEPT_CODE = 'D5' OR DEPT_CODE ='D6' OR DEPT_CODE ='D9';




DROP TABLE MYMEMBER;
CREATE TABLE MYMEMBER(
	MYNO INT AUTO_INCREMENT PRIMARY KEY,
	MYID VARCHAR(100) NOT NULL UNIQUE,
	MYPW VARCHAR(100) NOT NULL,
	MYNAME VARCHAR(50) NOT NULL,
	MYADDR VARCHAR(1000) NOT NULL,
	MYPHONE VARCHAR(500) NOT NULL UNIQUE,
	MYEMAIL VARCHAR(300) NOT NULL UNIQUE,
	MYENABLED VARCHAR(2) NOT NULL CHECK(MYENABLED IN ('Y','N')),
	MYROLE VARCHAR(50) NOT NULL
)
-- 멤버번호, 아이디, 비번, 이름, 주소, 전화번호, 이메일, 가입(탈퇴)여부, 등급(ADMIN,USER,MANAGER...)


SELECT * FROM MYMEMBER; 

INSERT INTO MYMEMBER VALUES(NULL,'ADMIN','ADMIN123','관리자','관리시 관리구 관리동','010-5555-5555','ADMING@MYMEMBER.COM','Y','ADMIN')