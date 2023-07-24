ALTER TABLE Segment
ADD nbSalle NUMBER(2);
ALTER TABLE Segment
ADD nbPoste NUMBER(2);

COMMENT ON COLUMN Segment.nbSalle 
IS 'nombre de salles' ;
COMMENT ON COLUMN Segment.nbPoste 
IS 'nombre de postes' ;

ALTER TABLE Logiciel
ADD nbInstall NUMBER(2);
COMMENT ON COLUMN Logiciel.nbInstall 
IS 'nombre d installations' ;

ALTER TABLE Poste
ADD nbLog NUMBER(2);
COMMENT ON COLUMN Poste.nbLog 
IS 'nombre de logiciels installés' ;

DESC Segment;
DESC Logiciel;
DESC Poste;

SELECT * FROM Segment;
SELECT * FROM Logiciel;
SELECT * FROM Poste;

ALTER TABLE Salle
MODIFY nomSalle VARCHAR2(30);
--ALTER TABLE Segment
--MODIFY nomSegment VARCHAR2(15);
-- "cannot decrease column length because some value is too big"
-- donc comme dedans on a 'Brin 2ème étage'
--ALTER TABLE Segment
--MODIFY nomSegment VARCHAR2(14);
-- "cannot decrease column length because some value is too big"
-- donc comme dedans on a 'Brin 2ème étage'
ALTER TABLE Segment
MODIFY nomSegment VARCHAR2(17); -- avec 17 ok

DESC Salle;
DESC Segment;

SELECT * FROM Salle;
SELECT * FROM Segment;


ALTER TABLE Poste
ADD CONSTRAINT fk_indIP_poste FOREIGN KEY (indIP) REFERENCES Segment(indIP);

ALTER TABLE Poste
ADD CONSTRAINT fk_Poste_typePoste_Types FOREIGN KEY (typePoste) REFERENCES Types(typeLP);

ALTER TABLE Poste
ADD CONSTRAINT fk_nSalle FOREIGN KEY (nSalle)  REFERENCES Salle(nSalle);

ALTER TABLE Installer 
ADD CONSTRAINT fk_nPoste FOREIGN KEY (nPoste) REFERENCES Poste(nPoste);

ALTER TABLE Installer 
ADD CONSTRAINT fk_nLog FOREIGN KEY (nLog) REFERENCES Logiciel(nLog);

CREATE TABLE Rejets (
ligne ROWID,
proprietaire VARCHAR2(30),
nomTable VARCHAR2(30),
contrainte VARCHAR2(30)
);

ALTER TABLE Salle 
ADD CONSTRAINT fk_indIP_salle FOREIGN KEY (indIP) REFERENCES Segment(indIP) exceptions into rejets;

ALTER TABLE Logiciel 
ADD CONSTRAINT fk_indIP_salle FOREIGN KEY (typeLog) REFERENCES Types(typeLP) exceptions into rejets;


SELECT * FROM Rejets;
SELECT ROWID,s.* FROM Salle s
    WHERE ROWID IN (SELECT ligne FROM Rejets);
SELECT ROWID,l.* FROM Logiciel l
    WHERE ROWID IN (SELECT ligne FROM Rejets);

DELETE FROM Rejets;