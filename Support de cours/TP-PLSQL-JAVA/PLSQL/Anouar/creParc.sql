CREATE TABLE segment (
  indIP         VARCHAR2(11) CONSTRAINT PK_indIP PRIMARY KEY,
  nomSegment   VARCHAR2(20)  NOT NULL,
  etage         NUMBER(2)
);

CREATE TABLE salle (
  nSalle     VARCHAR2(7) CONSTRAINT PK_nS PRIMARY KEY ,
  nomSalle     VARCHAR2(20)    NOT NULL,
  nbPoste     NUMBER(2),
  indIP    VARCHAR2(11) REFERENCES segment(indIP)
);

 CREATE TABLE Poste (
  nPoste     VARCHAR2(7) CONSTRAINT PK_nP PRIMARY KEY,
  nomPoste     VARCHAR2(20) NOT NULL,
  indIP     VARCHAR2(11) REFERENCES segment (indIP),
  ad       VARCHAR2(7) ,
  typePoste    VARCHAR2(9) ,
  nSalle        VARCHAR2(7) REFERENCES Salle (nSalle),
  CONSTRAINT ad CHECK ( ad>='0' and ad<'255')
);

CREATE TABLE logiciel (
  nLog     VARCHAR2(5) CONSTRAINT PK_logi PRIMARY KEY,
  nomLog     VARCHAR2(20),
  dateAche  DATE  ,
  version  VARCHAR2(7)  ,
  typeLog        VARCHAR2(9) ,
  prix          NUMBER(6,2),
  CONSTRAINT prix CHECK (prix >=0)
);

CREATE TABLE Installer (    
    nPoste      VARCHAR2(7)  REFERENCES Poste(nPoste),
    nLog        VARCHAR2(5)  REFERENCES Logiciel(nLog),
    numIns      NUMBER(5),
    dateIns     DATE DEFAULT CURRENT_TIMESTAMP,
    delai       INTERVAL DAY(5) TO SECOND(2),
    CONSTRAINT pk_installer PRIMARY KEY (nPoste,nLog)
);

CREATE TABLE Types (
  typeLP     VARCHAR2(9) CONSTRAINT PK_types PRIMARY KEY,
  nomType     VARCHAR2(20) 
);