DROP TABLE EVENT;
DROP SEQUENCE E_SEQ;
CREATE SEQUENCE E_SEQ MAXVALUE 9999 NOCACHE NOCYCLE;
CREATE TABLE EVENT(
	NUM NUMBER(4) PRIMARY KEY,
	NO1 NUMBER(2),
	NO2 NUMBER(2),
	NO3 NUMBER(2),
	NO4 NUMBER(2),
	NO5 NUMBER(2) 
);
SELECT * FROM EVENT;

--관리자 숫자 삽입
INSERT INTO EVENT VALUES(E_SEQ.NEXTVAL, 2,16,29,32,45);
INSERT INTO EVENT VALUES(E_SEQ.NEXTVAL, 6,10,17,23,33);
--관리자 숫자 보기 TOTCNT
SELECT COUNT(*) FROM EVENT;
--관리자 페이징 숫자보기 TOTCNT
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM EVENT ORDER BY NUM DESC) A ) WHERE RN BETWEEN 1 AND 5;
--사용자 추첨 숫자 가져오기
SELECT * FROM EVENT WHERE NUM=2;
--사용자 추첨시 맏으면 결과갑올리기
UPDATE CUSTOMER SET CRESULT=CRESULT+1 WHERE CID='MID';
--당첨된 사람  가져오기
SELECT * FROM CUSTOMER WHERE CRESULT=1;
SELECT * FROM CUSTOMER;