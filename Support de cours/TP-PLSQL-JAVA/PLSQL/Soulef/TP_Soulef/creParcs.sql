Prompt CREATION DES TABLES


PROMPT Creation de la table SEGMENT

CREATE TABLE "Segment" 
(indIP VARCHAR2(11) constraint pk_seg primary key,
nomSegment VARCHAR2(20) NOT NULL,
etage NUMBER(2));

CREATE TABLE Salle
(nSalle VARCHAR2(7) constraint pk_sal primary key,
nomSalle VARCHAR2(20) NOT NULL,
nbPoste NUMBER(2),
indIP  VARCHAR2(11) REFERENCES "Segment"(indIP));


CREATE TABLE Poste
(nPoste  VARCHAR2(7) constraint pk_pos primary key,
nomPoste VARCHAR2(20) NOT NULL,
indIP VARCHAR2(11) REFERENCES "Segment"(indIP),
ad VARCHAR2(3),
typePoste VARCHAR2(9),
nSalle VARCHAR2(7) REFERENCES Salle(nSalle),
CONSTRAINT ad CHECK (ad>=0 AND ad<255));



CREATE TABLE Logiciel
(nLog  VARCHAR2(5) constraint pk_log primary key,
nomLog VARCHAR2(20),
dateAch DATE DEFAULT SYSDATE,
"version" VARCHAR2(7),
typeLog VARCHAR2(9),
prix NUMBER(6,2),
CONSTRAINT prix CHECK (prix >=0));



CREATE TABLE Installer
(nPoste      VARCHAR2(7) CONSTRAINT fk_npost REFERENCES Poste(nPoste),
nLog        VARCHAR2(5) CONSTRAINT fk_nlog REFERENCES Logiciel(nLog),
CONSTRAINT pk_Installer PRIMARY KEY(nPoste,nLog),
numIns NUMBER(5),
dateIns DATE DEFAULT SYSDATE,
delai INTERVAL DAY(5) TO SECOND(2));

CREATE TABLE Types
(typeLP VARCHAR2(9) constraint pk_typ primary key,
nomType VARCHAR2(20));







