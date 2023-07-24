DROP TABLE Types;
DROP TABLE Installer;
DROP TABLE Poste;
DROP TABLE Salle;
DROP TABLE Segment;
DROP TABLE Logiciel;

CREATE TABLE Segment(
    indIP VARCHAR2(11) CONSTRAINT pk_indip PRIMARY KEY,
    nomSegment VARCHAR2(20) NOT NULL,
    etage NUMBER(2));

CREATE TABLE Salle(
    nSalle VARCHAR2(7) CONSTRAINT pk_nsalle PRIMARY KEY,
    nomSalle VARCHAR2(20) NOT NULL,
    nbPoste NUMBER(2),
    indIP VARCHAR2(11) CONSTRAINT fk_indip_salle REFERENCES Segment(indIP));

CREATE TABLE Poste(
    nPoste VARCHAR2(7) CONSTRAINT pk_nposte PRIMARY KEY,
    nomPoste VARCHAR2(20) NOT NULL,
    indIP VARCHAR2(11) CONSTRAINT fk_indip_poste REFERENCES Segment(indIP),
    ad VARCHAR2(3) CONSTRAINT ad_range CHECK (ad >= 0 AND ad <=255),
    typePoste VARCHAR2(9),
    nSalle VARCHAR2(7) CONSTRAINT fk_nsalle_poste REFERENCES Salle(nSalle));
    
CREATE TABLE Logiciel(
    nLog VARCHAR2(5) CONSTRAINT pk_nlog PRIMARY KEY,
    nomLog VARCHAR2(20),
    dateAch DATE,
    version VARCHAR2(7),
    typeLog VARCHAR2(9),
    prix NUMBER(2,6)) CONSTRAINT log_prix_min CHECK (prix >= 0);
    
CREATE TABLE Installer(
    nPoste VARCHAR2(7) CONSTRAINT fk_nposte_installer REFERENCES Poste(nPoste),
    nLog VARCHAR2(5) CONSTRAINT fk_nlog_installer REFERENCES Logiciel(nLog),
    numIns NUMBER(5),
    dateIns DATE DEFAULT sysdate,
    delai INTERVAL DAY(5) TO SECOND(2));

CREATE TABLE Types(
    typeLP VARCHAR2(9) CONSTRAINT pk_typelp PRIMARY KEY,
    nomType VARCHAR2(20)
);