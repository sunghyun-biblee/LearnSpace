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