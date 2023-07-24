
CREATE TABLE Segment (
indIP VARCHAR2(11) CONSTRAINT pk_indIP PRIMARY KEY,
nomSegment VARCHAR2(20) NOT NULL,
etage NUMBER(2)
);

CREATE TABLE Salle (
nSalle VARCHAR2(7) CONSTRAINT pk_nSalle PRIMARY KEY,
nomSalle VARCHAR2(20) NOT NULL,
nbPoste NUMBER(2),
indIP VARCHAR2(11) CONSTRAINT fk_indIP_salle REFERENCES Segment(indIP)
);

CREATE TABLE Poste (
nPoste VARCHAR2(7) CONSTRAINT pk_nPoste PRIMARY KEY,
nomPoste VARCHAR2(20) NOT NULL,
indIP VARCHAR2(11),
ad VARCHAR2(3),
typePoste VARCHAR2(9),
nSalle VARCHAR2(7)
);

CREATE TABLE Logiciel (
nLog VARCHAR2(5) CONSTRAINT pk_nLog PRIMARY KEY,
nomLog VARCHAR2(20),
dateAch DATE,
version VARCHAR2(7),
typeLog VARCHAR2(9),
prix NUMBER(6,2)
);

CREATE TABLE Installer (
nPoste VARCHAR2(7),
nLog VARCHAR2(5),
numIns NUMBER(5),
dateIns DATE DEFAULT sysdate,
delai INTERVAL DAY(5) TO SECOND(2),
CONSTRAINT pk_installer PRIMARY KEY (nPoste,nLog)
);

CREATE TABLE Types (
typeLP VARCHAR2(9) CONSTRAINT pk_typeLP PRIMARY KEY,
nomType VARCHAR2(20)
);

ALTER TABLE Poste
ADD CONSTRAINT ad_range
CHECK (ad >= 0 AND ad <=255) ;

ALTER TABLE Logiciel
ADD CONSTRAINT log_prix_min
CHECK (prix >= 0) ;


COMMENT ON COLUMN Segment.indIP 
IS 'trois premiers groupes IP (exemple : 130.120.80)' ;
COMMENT ON COLUMN Segment.nomSegment
IS 'nom du segment' ;
COMMENT ON COLUMN Segment.etage
IS 'etage du segment' ;

COMMENT ON COLUMN Salle.nSalle 
IS 'numéro de la salle' ;
COMMENT ON COLUMN Salle.nomSalle
IS 'nom de la salle' ;
COMMENT ON COLUMN Salle.nbPoste
IS 'nombre de postes de travail dans la salle' ;
COMMENT ON COLUMN Salle.indIP
IS 'REFERENCES Segment.indIP : trois premiers groupes IP (exemple : 130.120.80)' ;

COMMENT ON COLUMN Poste.nPoste 
IS 'code du poste de travail' ;
COMMENT ON COLUMN Poste.nomPoste
IS 'nom du poste de travail' ;
COMMENT ON COLUMN Poste.ad
IS 'dernier groupe de chiffres IP (exemple : 11)' ;
COMMENT ON COLUMN Poste.typePoste
IS 'type du poste (Unix, TX, PCWS, PCNT)' ;
COMMENT ON COLUMN Poste.indIP
IS 'REFERENCES Segment.indIP : trois premiers groupes IP (exemple : 130.120.80)' ;
COMMENT ON COLUMN Poste.nSalle
IS 'REFERENCES Salle.nSalle numéro de la salle' ;

COMMENT ON COLUMN Logiciel.nLog 
IS 'code du logiciel' ;
COMMENT ON COLUMN Logiciel.nomLog
IS 'nom du logiciel' ;
COMMENT ON COLUMN Logiciel.dateAch
IS 'date d achat du logiciel' ;
COMMENT ON COLUMN Logiciel.version
IS 'version du logiciel' ;
COMMENT ON COLUMN Logiciel.typeLog
IS 'type du logiciel (Unix, TX, PCWS, PCNT)' ;
COMMENT ON COLUMN Logiciel.prix
IS 'prix du logiciel' ;

COMMENT ON COLUMN Installer.nPoste 
IS 'REFERENCES Poste.nPoste : code du poste de travail' ;
COMMENT ON COLUMN Installer.nLog
IS 'REFERENCES Logiciel.nLog : code du logiciel' ;
COMMENT ON COLUMN Installer.numIns 
IS 'numéro sequentiel des installations' ;
COMMENT ON COLUMN Installer.dateIns
IS 'date d installation du logiciel' ;
COMMENT ON COLUMN Installer.delai
IS 'intervalle entre achat et installation' ;

COMMENT ON COLUMN Types.typeLP 
IS 'types des logiciels et des postes' ;
COMMENT ON COLUMN Types.nomType
IS 'noms des types (Terminaux X, PC Windows...)' ;