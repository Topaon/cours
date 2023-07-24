CREATE TABLE Segment ( 
    indIP           VARCHAR2(11)     CONSTRAINT pk_segment PRIMARY KEY,
    nomSegment      VARCHAR2(20)     NOT NULL,
    etage           NUMBER(2)
    );
    
CREATE TABLE Salle ( 
    nSalle          VARCHAR2(7)     CONSTRAINT pk_salle PRIMARY KEY, 
    nomSalle        VARCHAR2(20)    NOT NULL,
    nbPoste         NUMBER(2),
    indIP           VARCHAR2(11)    CONSTRAINT fk_indIP_salle REFERENCES Segment(indIP)
    );
    
CREATE TABLE Poste ( 
    nPoste          VARCHAR2(7)       CONSTRAINT pk_poste PRIMARY KEY, 
    nomPoste        VARCHAR2(20)      NOT NULL,
    indIP           VARCHAR2(11)      CONSTRAINT fk_indIP_poste REFERENCES Segment(indIP),
    ad              VARCHAR2(3)       CONSTRAINT ck_intervalAd CHECK (ad>=0 AND ad<=255),
    typePoste       VARCHAR2(9),
    nSalle          VARCHAR2(7)       CONSTRAINT fk_nSalle_poste REFERENCES Salle(nSalle)
    );

CREATE TABLE Logiciel ( 
    nLog            VARCHAR2(5)     CONSTRAINT pk_logiciel PRIMARY KEY, 
    nomLog          VARCHAR2(20),
    dateAch         DATE            DEFAULT current_date,
    version         VARCHAR2(7),
    typeLog         VARCHAR2(9),
    prix            NUMBER(6,2)     CONSTRAINT ck_prixMin CHECK (prix >= 0)
    );
    
CREATE TABLE Installer ( 
    nPoste          VARCHAR2(7)         CONSTRAINT fk_nPoste_installer REFERENCES Poste(nPoste), 
    nLog            VARCHAR2(5)         CONSTRAINT fk_nLog_installer REFERENCES Logiciel(nLog),
    numIns          NUMBER(5),
    dateIns         DATE,
    delai           INTERVAL DAY (5) TO SECOND (2)
    );
    
CREATE TABLE Types ( 
    typeLP          VARCHAR2(9)          CONSTRAINT pk_types PRIMARY KEY, 
    nomType         VARCHAR2(20)
    );