CREATE TABLE Adresse ( 
    id              INT(11)         AUTO_INCREMENT CONSTRAINT pk_adresse PRIMARY KEY,
    nomVoie         VARCHAR2(50)    NOT NULL,
    codePostal      VARCHAR2(5)     NOT NULL,
    ville           VARCHAR2(20)    NOT NULL,
    );
    
CREATE TABLE Stagiaire ( 
    id          INT(11)             AUTO_INCREMENT CONSTRAINT pk_stagiaire PRIMARY KEY,
    prenom      VARCHAR2(20)        NOT NULL,
    email       VARCHAR2(80)        NOT NULL,
    mdp         TEXT                NOT NULL,
    adresseId   INT(11)             CONSTRAINT fk_adresseId_Stagiaire REFERENCES Adresse(id),
    ddn         DATE,
    role        VARCHAR2(20)        NOT NULL,
    );