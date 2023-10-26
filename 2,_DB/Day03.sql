-- DATE_ADD() : 해당날짜 이후를 알 수 있다 , DATE_SUB() : 해달 날짜 이전을 알 수 있다
SELECT
	EMP_NAME,
	HIRE_DATE,
	DATE_ADD(HIRE_DATE, INTERVAL 1 YEAR),
	DATE_SUB(HIRE_DATE, INTERVAL 1 YEAR)
FROM
	EMPLOYEE;
	
-- DAYOFWEEK() : 해당 날짜의 요일을 알 수 있다.
-- 1: 일요일 ~ 7: 토요일
SELECT DAYOFWEEK(NOW());

-- EMPLOYEE 에서 사원이 입사한 날의 요일을 조회
-- 이 때 숫자가 아닌 일요일 ~ 토요일로 조회
SELECT
	EMP_NAME,
	CASE
		WHEN DAYOFWEEK(HIRE_DATE) = 1 THEN '일요일'
		WHEN DAYOFWEEK(HIRE_DATE) = 2 THEN '월요일'
		WHEN DAYOFWEEK(HIRE_DATE) = 3 THEN '화요일'
		WHEN DAYOFWEEK(HIRE_DATE) = 4 THEN '수요일'
		WHEN DAYOFWEEK(HIRE_DATE) = 5 THEN '목요일'
		WHEN DAYOFWEEK(HIRE_DATE) = 6 THEN '금요일'
		WHEN DAYOFWEEK(HIRE_DATE) = 7 THEN '토요일'
	END "요일"
FROM
	EMPLOYEE;

-- LAST_DAY():주어진 날짜의 마지막 일자를 조회한다.
SELECT LAST_DAY(NOW());


	
-- 실습1
-- EMPLOYEE 테이블에서 근무년수가 25년이상인 사원들의
-- 사번, 사원명, 부서코두, 입사일 조회
SELECT EMP_ID 사번, EMP_NAME 사원명,DEPT_CODE 부서코드, HIRE_DATE 입사일 FROM EMPLOYEE
WHERE DATE_ADD(HIRE_DATE, INTERVAL 25 YEAR)<=NOW();


-- CAST(), CONVERT() : 주어진 값을 원하는 형식으로 변경하는 함수
SELECT CAST(20231011 AS DATE), CONVERT(20231011,DATE);
SELECT CAST(20202020111 AS CHAR), CAST(NOW() AS CHAR);

SELECT '123'+'456';
SELECT '123'+'456ABC','123'+'4A5B6C';



-- 관계형 데이터베이스에서는 DBMS의 설정 정보들을 테이블 형태로 관리한다.
-- 이를 데이터사전(데이터 딕셔너리)라 부른다.
-- 기본적으로 시스템의 관리자만 설정 변경 가능!
-- 단, 사용자 계정도 사용자가 접속한 동안만 변경 가능, 재접속하면 초기화

SHOW TABLES;
SELECT * FROM INFORMATION_SCHEMA.TABLES;

SET TIME_ZONE = 'ASIA/SEOUL';

SELECT NOW();
SELECT @@SESSION.TIME_ZONE;



-- SELECT 문의 실행 순서 --
/*
 * 5. SELECT 컬럼 AS 별칭 , 계산식, 함수, ...
 * 1. FROM  테이블명
 * 2. WHERE  조건
 * 3. GROUP BY  그룹을 묶을 컬럼명
 * 5. HAVING  그룹에 대한 조건식, 함수
 * 6. ORDER BY 컬럼명 | 별칭 | 컬럼의 순서 |[ASC|DESC][,컬럼명..]
 */


-- ORDER BY 절
-- SELECT 절을 통해 조회한 행의 결과들을 특정 기준에 맞춰 정렬하는 구문
SELECT EMP_ID,EMP_NAME 이름,SALARY*12,DEPT_CODE FROM EMPLOYEE
-- ORDER BY EMP_ID;
-- ORDER BY EMP_NAME; -- 기본값은 ASC(오름차순)
-- ORDER BY DEPT_CODE DESC, EMP_NAME;
-- ORDER BY 이름; -- ORDER BY에 컬럼의 별칭도 사용 가능하다
ORDER BY 3 DESC; -- 컬럼의 순서를 입력해도 정렬 가능하다


-- GROUP BY--
-- 사원 전체 급여 평균
SELECT TRUNCATE(AVG(SALARY),-3) FROM EMPLOYEE;

-- 부서 D1의 평균 급여
SELECT TRUNCATE(AVG(SALARY),-3) FROM EMPLOYEE WHERE DEPT_CODE = 'D1'; 

-- GROUP BY
-- 특정 컬럼이나 계산식을 하나의 그룹으로 묶어
-- 한 테이블 내에서 소그룹 별로 조회하고자 할 때 선언하는 구문

-- 부서별 급여 평균
SELECT DEPT_CODE 부서별, TRUNCATE(AVG(SALARY),-3) '평균 월급' FROM EMPLOYEE GROUP BY DEPT_CODE;



-- 실습2
-- EMPLOYEE 테이블에서
-- 부서별 총인원, 급여 합계 ,급여평균 ,최대급여, 최소급여를 조회
SELECT DEPT_CODE,COUNT(*),SUM(SALARY),MAX(SALARY),MIN(SALARY), TRUNCATE(AVG(SALARY),-3) FROM EMPLOYEE GROUP BY DEPT_CODE ORDER BY 1;


-- 실습3
-- EMPLOYEE 테이블에서 직급별 보너스를 받는 사원의 수를 조회
-- 직급 코드 순으로 내림차순 정렬
-- 직급 코드, 보너스 받는 사원 수를 조회
SELECT JOB_CODE 직급코드,CONCAT(COUNT(BONUS),'명') '보너스받는 사원수' FROM EMPLOYEE GROUP BY JOB_CODE ORDER BY 1 DESC;


-- 실습4
-- EMPLOYEE 테이블에서
-- 남성직원과 여성직원의 수를 조회
-- GROUP BY 에서 주어진 컬럼만이 아닌 함수도 사용가능

SELECT SUBSTR(EMP_NO,8,1) , COUNT(*)FROM EMPLOYEE GROUP BY SUBSTR(EMP_NO,8,1); -- SUBSTR은 값이 1개만 조회됨 즉, 열이 하나만 나오기때문에 다른 여러개의 값을 가지고있는 컬럼과 같이 조회할 수 없다.



-- HAVING 구문
-- GROUP BY 한 각 소그룹에 대한 조건을 설정 할 때
-- 부서별 급여 평균이 300만원 이상인 부서만 조회
-- SELECT DEPT_CODE,TRUNCATE(AVG(SALARY),-3) FROM EMPLOYEE WHERE SALARY>=3000000 GROUP BY DEPT_CODE;
SELECT
	DEPT_CODE, -- 부서를 조회
	TRUNCATE(AVG(SALARY),-3) -- 월급이 얼마인지
FROM
	EMPLOYEE
GROUP BY
	DEPT_CODE  -- 부서별로 묶음
HAVING
	AVG(SALARY)>= 3000000; -- 평균급여가 300만원이상인가
	
	
	
-- 실습5
-- 부서별 그룹의 급여 합계 중 900만원을 초과하는
-- 부서의 부서코드, 급여 합계 조회
SELECT DEPT_CODE , SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING SUM(SALARY)>9000000;

-- GROUP BY 할때 컬럼 여러개
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE,JOB_CODE ORDER BY 1,2;



-- SET OPERATOR
-- 두 개 이상의 SELECT한 결과 (RESULT SET)를 합치는 집합 형태의 결과로 조회하는 명령어

-- 합집합 == 
-- UNION : 두 개 이상의 SELECT한 결과를 하나로 구하는 명령어.
-- 		   단, 중복이 있을 경우 중복되는 결과는 1번만 보여준다

-- UNION ALL : 두 개 이상의 SELECT한 결과를 보여주지만, 중복이 있을경우 중복되는 내용도 함께 조회하여 보여준다.

-- UNION으로 합칠때는 결과셋의 컬럼의 갯수를 맞춰주어야 한다
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY FROM EMPLOYEE WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID,EMP_NAME,DEPT_CODE,EMP_NO FROM EMPLOYEE WHERE SALARY>3000000;

-- -------------- 

SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY FROM EMPLOYEE WHERE DEPT_CODE='D5'
UNION ALL
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY FROM EMPLOYEE WHERE SALARY>3000000;




-- JOIN --
-- 두 개 이상의 테이블을 하나로 합쳐 사용하는 명령 구문

-- 만약 'J6'라는 직읍을 가진 사원들의 근무 부서명이 궁금하다면?

SELECT EMP_NAME, JOB_CODE,DEPT_CODE FROM EMPLOYEE WHERE JOB_CODE='J6';

SELECT * FROM DEPARTMENT;

-- 조언하고자 하는 테이블을 FROM 구문 다음에 JOIN 테이블명 ON() | USING() 구문을 사용하여 
-- 두 개 이상의 테이블을 하나로 합치는 방법


-- 두 개의 테이블에서 공통컬럼의 이름이 다를 경우
SELECT EMP_ID,EMP_NAME,DEPT_CODE,DEPT_TITLE FROM EMPLOYEE -- JOIN DEPARTMENT ON(EMPLOYEE.DEPT_CODE=DEPARTMENT.DEPT_ID);
JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID);
-- SELECT * FROM EMPLOYEE -- JOIN DEPARTMENT ON(EMPLOYEE.DEPT_CODE=DEPARTMENT.DEPT_ID);

-- 두 개의 테이블에서 공통컬럼의 이름이 같을 경우
-- 1. ON()을 사용할 때
SELECT EMP_ID,EMP_NAME,EMPLOYEE.JOB_CODE,JOB_NAME FROM EMPLOYEE JOIN JOB ON(EMPLOYEE.JOB_CODE=JOB.JOB_CODE);
	-- 공통컬럼의 이름이 같을 경우에는 어느테이블의 컬럼인지 명시해주어야 한다.

-- 2. USING()을 사용할 때
SELECT EMP_ID,EMP_NAME,JOB_CODE,JOB_NAME FROM EMPLOYEE JOIN JOB USING(JOB_CODE);
	-- 공통컬럼이 있을땐 USING을 사용하는 것이 더 편하다.


-- 실습6
-- EMPLOYEE 테이블의 직원 급여 정보와 SAL_GRADE의 급여 등급을 합쳐서 
-- 사번, 사원명, 급여 ,등급 기준, 최소급여 , 최대급여를 조회

SELECT * FROM SAL_GRADE;

SELECT EMP_ID,EMP_NAME,SALARY,EMPLOYEE.SAL_LEVEL,MIN_SAL,MAX_SAL FROM EMPLOYEE JOIN SAL_GRADE ON(EMPLOYEE.SAL_LEVEL = SAL_GRADE.SAL_LEVEL);


SELECT EMP_ID,EMP_NAME,SALARY,SAL_LEVEL,MIN_SAL,MAX_SAL FROM EMPLOYEE JOIN SAL_GRADE USING(SAL_LEVEL);


-- INNER JOIN/ OUTER JOIN (LEFT, RIGHT)

-- INNER : 조건에 만족하는(일치하는) 데이터만 선택
-- 조건에 만족하는 데이터만 선택하여 붙이기때문에 조건에 만족하지않는 데이터는 버린다.
SELECT EMP_NAME,DEPT_CODE,DEPT_TITLE FROM EMPLOYEE INNER JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID);



-- LEFT OUTER J0IN ( LEFT JOIN )
-- LEFT : 첫 번째 테이블 기준으로 두 번째 테이블을 조합
-- 		  조건을 만족하지않는 경우 첫 번째 테이블의 필드값은 그대로 두고
-- 		  두 번째 테이블의 필드 값은 NULL로 처리된다.

-- RIGHT : 두 번째 테이블 기준으로 첫 번째 테이블을 조합
-- 		   조건을 만족하지 않는 경우 두 번째 테이블의 필드값을 그대로 가져온다.
-- 		   하지만 해당 로우의 첫 번째 테이블의 필드값은 모두 NULL로 표시


-- LEFT JOIN
SELECT EMP_NAME,DEPT_CODE,DEPT_TITLE FROM EMPLOYEE LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID);

-- RIGHT JOIN
SELECT * FROM EMPLOYEE RIGHT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID);


-- SELF JOIN
-- 자기 자신을 조언하는 방법
-- 한 테이블의 정보 중 값 비교가 필요한 정보들을 계산하여 조회하는 방식

-- 직원의 정보와 직원을 관리하는 매니저의 정보를 조회
SELECT
	E.EMP_ID ,
	E.EMP_NAME ,
	M.MANAGER_ID,
	M.EMP_NAME
FROM EMPLOYEE E
JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID);


-- 다중 JOIN
-- 여러 개의 테이블을 JOIN 하는 것
-- 일반 조인과 선언방식은 같으나, 앞서 조인한 결과를 기준으로
-- 호에 조인할 테이블을 연결 짓는다.
-- 순서가 중요함

SELECT EMP_NAME,DEPT_TITLE,LOCAL_NAME FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) JOIN LOCATION ON(LOCATION_ID= LOCAL_CODE);


-- 실습 7
-- 직급이 대리이면서 아시아 지역에서 근무하는 사원 조회
-- 사번, 사원명, 직급명, 부서명, 근무지역명, 급여
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;
SELECT * FROM JOB;

SELECT
	EMP_ID 사번,
	EMP_NAME 사원명,
	JOB_NAME 직급명,
	DEPT_TITLE 부서명,
	NATIONAL_CODE 근무지역명,
	SALARY 급여
FROM
	EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
	-- JOIN JOB ON(EMPLOYEE.JOB_CODE=JOB.JOB_CODE)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
WHERE
	JOB_NAME = '대리'
	AND LOCAL_NAME LIKE 'ASIA%'
	-- 	AND (LOCAL_NAME = 'ASIA1'
	-- 		OR LOCAL_NAME = 'ASIA2'
	-- 		OR LOCAL_NAME = 'ASIA3')
ORDER BY
	1; 

SELECT
	EMP_ID,
	EMP_NAME,
	JOB_NAME,
	DEPT_TITLE,
	NATIONAL_CODE,
	SALARY,
	LOCAL_NAME
FROM
	EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
-- JOIN JOB ON(EMPLOYEE.JOB_CODE=JOB.JOB_CODE AND JOB_NAME='대리')
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE AND LOCAL_NAME LIKE 'ASIA%');

-- LEFT JOIN 과 RIGHT JOIN을 어떻때 사용하는지 알아보기---




-- Sub Query
-- 주(메인)가 되는 메인쿼리 안에서
-- 조건이나 하나의 검색을 위한 또 하나의 쿼리를 추가하여 작성하는 기법

-- [단일 행 서브쿼리]
-- 결과 값이 1개 나오는 서브쿼리

-- 최소 급여를 받는 사원의 정보 조회

-- 기존 방식
-- 1) 최소 급여 확인
SELECT MIN(SALARY) FROM EMPLOYEE; -- 138만원
-- 2) 최소급여 받는 사원의 정보 확인
SELECT * FROM EMPLOYEE WHERE SALARY= 1380000;

-- 서브쿼리 활용
SELECT * FROM EMPLOYEE WHERE SALARY=(SELECT MIN(SALARY) FROM EMPLOYEE);




-- [다중 행 서브쿼리]
-- 결과 값이 여러개 나오는 서브쿼리

-- 각 직급별 최소 급여 받는 사원 정보 출력
SELECT JOB_CODE, MIN(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE;

SELECT * FROM EMPLOYEE WHERE SALARY IN(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE);

-- 다중 열 다중 행 서브쿼리
-- 여러 행(컬럼)과 여러 열(로우)을 가지는 서브쿼리를 사용하여 결과 조회
SELECT *
FROM EMPLOYEE
WHERE (JOB_CODE,SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
				FROM EMPLOYEE 
				GROUP BY JOB_CODE)
			ORDER BY 1 ASC;


-- 다중행 다중열 서브쿼리와 일반 단일행 서브쿼리 차이
-- 퇴사한 여직원과 같은 직급,같은 부서에 근무하는 직원들의 정보 조회
-- 단일행
SELECT * FROM EMPLOYEE WHERE DEPT_CODE=(SELECT DEPT_CODE FROM EMPLOYEE WHERE ENT_YN='Y') AND JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y');

-- 다중열
SELECT * FROM EMPLOYEE WHERE (DEPT_CODE,JOB_CODE)=(SELECT DEPT_CODE,JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y');


-- 서브쿼리의 사용위치
-- SELECT, FROM, WHERE, GROUP BY, HAVING , ORDER BY, JOIN...
-- DML : INSERT, UPDATE, DELETE 
-- DDL : CREAT TABLE, CREAT VIEW

-- FROM 위치에 사용되는 서브쿼리는
-- 테이블 명으로 테이블을 직접 조회하는 대신
-- 서브쿼리의 결과 (RESULT SET)을 테이블 처럼 활용하여 데이터를 조회
-- Inline View(인라인 뷰)라고 부른다.


SELECT *
FROM(
	SELECT EMP_ID 사번 ,EMP_NAME 사원명 , DEPT_TITLE , JOB_NAME
	FROM EMPLOYEE
	JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID)
	JOIN JOB USING(JOB_CODE)
) A;


d






















