CREATE TABLE "Segment"(
   indIP VARCHAR2(11) CONSTRAINT pk_Segment PRIMARY KEY,
   nomSegment VARCHAR2(20),
   etage NUMBER(2) 
);

CREATE TABLE Salle(
    nSalle VARCHAR2(7) CONSTRAINT pk_Salle PRIMARY KEY,
    nomSalle VARCHAR2(20),
    nbPoste NUMBER(2),
    indIP VARCHAR2(11) REFERENCES "Segment"(indIP)
);

CREATE TABLE Poste(
    nPoste VARCHAR2(7) PRIMARY KEY,
    nomPoste VARCHAR2(20),
    indIP VARCHAR2(11) REFERENCES "Segment"(indIP),
    ad VARCHAR2(3),
    typePoste VARCHAR2(9),
    nSalle VARCHAR2(7) REFERENCES Salle(nSalle)
);
CREATE TABLE Logiciel(
    nLog VARCHAR2(5) PRIMARY KEY,
    nomLog VARCHAR2(20),
    dateAch DATE,
    "version" VARCHAR2(7),
    typeLog VARCHAR2(9),
    prix NUMBER(6,2)
);
CREATE TABLE Installer(
    nPoste VARCHAR2(7) REFERENCES Poste(nPoste),
    nLog VARCHAR2(5) REFERENCES Logiciel(nLog),
    numIns NUMBER(5) PRIMARY KEY,
    dateIns DATE,
    delai INTERVAL DAY(5) TO SECOND(2)
);
CREATE TABLE "Types"(
    typeLP VARCHAR2(9) PRIMARY KEY,
    nomType VARCHAR2(20)
);
