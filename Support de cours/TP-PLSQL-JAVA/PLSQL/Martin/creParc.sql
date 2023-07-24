/*CREATE TABLE ''(
    indIP VARCHAR2(11)
    nomSegment VARCHAR2(20)
    etage NUMBER(2)
    nSalle VARCHAR2(7)
    nomSalle VARCHAR2(20)
    nbPoste NUMBER(2)
    nPoste VARCHAR2(7)
    nomPoste VARCHAR2(20)
    ad VARCHAR2(3)
    typePoste VARCHAR2(9)
    dateIns DATE
    nLog VARCHAR2(5)
    nomLog VARCHAR2(20)
    dateAch DATE
    version VARCHAR2(7)
    typeLog VARCHAR2(9)
    prix NUMBER(6,2)
    numIns NUMBER(5)
    dateIns DATE
    delai INTERVAL DAY(5) TO SECOND(2)
    typeLP VARCHAR2(9)
    nomType VARCHAR2(20)
); */

/* Écrivez puis exécutez le script SQL (que vous appellerez creParc.sql) de création des tables avec leur clé primaire (en gras dans le schéma suivant) et les contraintes suivantes :
• Les noms des segments, des salles et des postes sont non nuls.
• Le domaine de valeurs de la colonne ad s’étend de 0 à 255.
• La colonne prix est supérieure ou égale à 0.
• La colonne dateIns est égale à la date du jour par défaut.*/

CREATE TABLE Segment(
    indIP VARCHAR2(11) CONSTRAINT pk_indIP PRIMARY KEY,
    nomSegment VARCHAR2(20) NOT NULL,
    etage NUMBER(2)
);

CREATE TABLE Salle(
    nSalle VARCHAR2(7) CONSTRAINT pk_Nsalle PRIMARY KEY,
    nomSalle VARCHAR2(20) NOT NULL,
    nbPoste NUMBER(2),
    indIP VARCHAR2(11) --CONSTRAINT fk_salle_indIP REFERENCES Segment(indIP)
);

CREATE TABLE Poste(
    nPoste VARCHAR2(7) CONSTRAINT pk_nPoste PRIMARY KEY,
    nomPoste VARCHAR2(20) NOT NULL,
    indIP VARCHAR2(11) CONSTRAINT fk_poste_indIP REFERENCES Segment(indIP),
    ad VARCHAR2(3) CONSTRAINT ck_intervalAd CHECK (0 =< ad =< 255),
    typePoste VARCHAR2(9),
    nSalle VARCHAR2(7) CONSTRAINT fk_poste_nSalle REFERENCES Salle(nSalle)
);

CREATE TABLE Logiciel(
    nLog VARCHAR2(5) CONSTRAINT pk_nLog PRIMARY KEY,
    nomLog VARCHAR2(20),
    dateAch DATE,
    version VARCHAR2(7),
    typeLog VARCHAR2(9),
    prix NUMBER(6,2) CONSTRAINT ck_prixMin CHECK (prix >= 0)
);

CREATE TABLE Installer(
    nPoste VARCHAR2(7) PRIMARY KEY,
    nLog VARCHAR2(5) CONSTRAINT fk_installer_nLog  REFERENCES Logiciel(nLog),
    numIns NUMBER(5),
    dateIns DATE DEFAULT sysdate,
    delai INTERVAL DAY(5) TO SECOND(2)
);

CREATE TABLE Types(
    typeLP VARCHAR2(9) PRIMARY KEY,
    nomType VARCHAR2(20)
);