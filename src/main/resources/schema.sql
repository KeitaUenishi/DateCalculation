CREATE TABLE IF NOT EXISTS datemaster(
          dateId          varchar  (6)               NOT NULL  PRIMARY KEY  COMMENT '���tID'
         ,dateName        varchar  (32)                                     COMMENT '���t��'
         ,adjustmentYear  int      (2)    Default 0  NOT NULL               COMMENT '�����l(�N)'
         ,adjustmentMonth int      (3)    Default 0  NOT NULL               COMMENT '�����l(��)'
         ,adjustmentDay   int      (4)    Default 0  NOT NULL               COMMENT '�����l(��)'
);