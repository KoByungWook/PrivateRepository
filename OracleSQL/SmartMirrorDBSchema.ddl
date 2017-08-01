-- 생성자 Oracle SQL Developer Data Modeler 4.1.3.901
--   위치:        2017-07-31 15:26:17 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g




CREATE
  TABLE "access"
  (
    ano        NUMBER (10) NOT NULL ,
    member_mid VARCHAR2 (50) NOT NULL ,
    adateon    DATE NOT NULL ,
    adateout   DATE NOT NULL
  ) ;
ALTER TABLE "access" ADD CONSTRAINT access_PK PRIMARY KEY ( ano ) ;


CREATE
  TABLE humidity
  (
    htime  DATE NOT NULL ,
    hvalue NUMBER NOT NULL
  ) ;


CREATE
  TABLE member
  (
    mid   VARCHAR2 (50) NOT NULL ,
    mname VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE member ADD CONSTRAINT member_PK PRIMARY KEY ( mid ) ;


CREATE
  TABLE photo
  (
    pno               NUMBER (10) NOT NULL ,
    member_mid        VARCHAR2 (50) NOT NULL ,
    poriginalfilename VARCHAR2 (200) NOT NULL ,
    psavedfilename    VARCHAR2 (200) NOT NULL ,
    pfilecontent      VARCHAR2 (200) NOT NULL
  ) ;
ALTER TABLE photo ADD CONSTRAINT photo_PK PRIMARY KEY ( pno ) ;


CREATE
  TABLE photoresistor
  (
    ptime  DATE NOT NULL ,
    pvalue NUMBER NOT NULL
  ) ;


CREATE
  TABLE SCHEDULE
  (
    sno        NUMBER (10) NOT NULL ,
    member_mid VARCHAR2 (50) NOT NULL ,
    sdate      DATE NOT NULL ,
    scontent   VARCHAR2 (4000) NOT NULL
  ) ;
ALTER TABLE SCHEDULE ADD CONSTRAINT schedule_PK PRIMARY KEY ( sno ) ;


CREATE
  TABLE thermistor
  (
    ttime  DATE NOT NULL ,
    tvalue NUMBER NOT NULL
  ) ;


ALTER TABLE "access" ADD CONSTRAINT access_member_FK FOREIGN KEY ( member_mid )
REFERENCES member ( mid ) ;

ALTER TABLE photo ADD CONSTRAINT photo_member_FK FOREIGN KEY ( member_mid )
REFERENCES member ( mid ) ;

ALTER TABLE SCHEDULE ADD CONSTRAINT schedule_member_FK FOREIGN KEY ( member_mid
) REFERENCES member ( mid ) ;


-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
