DROP TABLE MASTER;
CREATE TABLE MASTER(
  MID VARCHAR2(20) PRIMARY KEY,
  MPASS VARCHAR2(20) NOT NULL );
  
  -- MID로 PASS가져오기
  SELECT * FROM MASTER ;
  
  INSERT INTO MASTER VALUES ('master' , 'm1234');
  