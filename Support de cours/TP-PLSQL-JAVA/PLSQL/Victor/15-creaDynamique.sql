DROP TABLE Softs;

CREATE TABLE Softs AS SELECT
    nLog AS nomSoft,
    version,
    prix
FROM Logiciel;

DESC Softs;

DROP TABLE PCSeuls;

CREATE TABLE PCSeuls AS SELECT
     nPoste AS nP,
     nomPoste AS nomP,
    indIP AS seg,
    ad,
    typePoste AS typeP ,
    nSalle AS salle
FROM Poste WHERE (typePoste='PCWS' OR typePoste='PCNT');

DESC PCSeuls;

SELECT * FROM Softs;
SELECT * FROM PCSeuls;