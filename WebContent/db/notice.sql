DROP TABLE NOTICE;
DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE NOTICE_SEQ MAXVALUE 9999 NOCACHE NOCYCLE;
CREATE TABLE NOTICE(
 NNUM NUMBER(4) PRIMARY KEY,
 MID VARCHAR2(20) REFERENCES MASTER(MID),
 NNAME VARCHAR2(20) NOT NULL,
 NCONTENT VARCHAR2(500) NOT NULL,
 NRDATE DATE DEFAULT SYSDATE );
 
SELECT * FROM NOTICE;

--공지사항 작성
INSERT INTO NOTICE (NNUM, MID, NNAME, NCONTENT) VALUES (NOTICE_SEQ.NEXTVAL, 'MASTER', '제목', '내용');
INSERT INTO NOTICE (NNUM, MID, NNAME, NCONTENT) VALUES (NOTICE_SEQ.NEXTVAL, 'MASTER2', '제목3', '내용3');
--공지사항 상세보기--
SELECT * FROM NOTICE WHERE NNUM=1;
--공지사항 삭제
DELETE FROM NOTICE WHERE NNUM=2;
--공지사항 보기
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT N.* FROM NOTICE N, MASTER M WHERE N.MID=M.MID ORDER BY NNUM DESC) A) WHERE RN BETWEEN 1 AND 5;
COMMIT;