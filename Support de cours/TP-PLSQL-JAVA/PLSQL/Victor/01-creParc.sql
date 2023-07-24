CREATE TABLE Segment  
(	indIP          	VARCHAR2(11) CONSTRAINT pk_indip_segment PRIMARY KEY,
  	nomSegment     	VARCHAR2(20) NOT NULL,
  	etage			NUMBER(2) );

CREATE TABLE Salle (
 	nSalle        	VARCHAR2(7) CONSTRAINT pk_nsalle PRIMARY KEY,
  	nomSalle     	VARCHAR2(20) NOT NULL,
  	nbPoste         NUMBER(2),
	indIP 	VARCHAR2(11) --CONSTRAINT fk_indip_segment_salle REFERENCES Segment(indIP)
	);

CREATE TABLE Poste (
  	nPoste      	VARCHAR2(7) CONSTRAINT pk_npost PRIMARY KEY,
	nomPoste		VARCHAR2(20) NOT NULL,
	indIP 			VARCHAR2(11) CONSTRAINT fk_indip_segment_poste REFERENCES Segment(indIP),
	ad				NUMBER(3) CHECK (ad>=0 AND ad<=255),
	typePoste		VARCHAR2(9),
	nSalle        	VARCHAR2(7));

CREATE TABLE Logiciel (
	nLog			VARCHAR2(5) CONSTRAINT pk_nlog PRIMARY KEY,
	nomLog			VARCHAR2(20),
	dateAch			DATE,
	version 		VARCHAR2(7),
	typeLog			VARCHAR2(9),
	prix			NUMBER(6,2) CHECK (prix >= 0) );

CREATE TABLE Installer (	
	nPoste      	VARCHAR2(7) CONSTRAINT fk_npost REFERENCES Poste(nPoste),
	nLog			VARCHAR2(5) CONSTRAINT fk_nlog REFERENCES Logiciel(nLog),
	numIns			NUMBER(5),
	dateIns			DATE DEFAULT CURRENT_TIMESTAMP,
	delai			INTERVAL DAY(5) TO SECOND(2),
	CONSTRAINT pk_installer PRIMARY KEY (nPoste,nLog)
);

CREATE TABLE Types (	
	typeLP			VARCHAR2(9) CONSTRAINT pk_typeLP PRIMARY KEY,
	nomType			VARCHAR2(20) );

--	