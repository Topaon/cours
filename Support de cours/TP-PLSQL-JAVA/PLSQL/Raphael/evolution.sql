--exercice 3 1
ALTER TABLE Segment ADD (
nbSalle number(2),
nbPoste number(2));
ALTER TABLE Logiciel ADD nbInstall number(2);

ALTER TABLE Poste ADD nbLog number(2);

DESCRIBE Segment;
DESCRIBE Logiciel;
DESCRIBE Poste;
SELECT * FROM Segment;
SELECT * FROM Logiciel;
SELECT * FROM Poste;

--Exercice 3 2
ALTER TABLE Salle MODIFY
nomSalle VARCHAR2(30);

ALTER TABLE Segment MODIFY
nomSegment VARCHAR2(15)L;


DESC Segment;
DESC Salle;

SELECT * FROM Salle;
SELECT * FROM Segment;



-- Exercice 3 4

CREATE TABLE Rejets (
ligne ROWID,
proprietaire VARCHAR2(30),
nomTable VARCHAR2(30),
contrainte VARCHAR2(30) 
);

ALTER TABLE Poste ADD CONSTRAINT fk_type FOREIGN KEY (typePoste) REFERENCES Types(typeLP) EXCEPTIONS INTO Rejets;
ALTER TABLE Salle ADD CONSTRAINT fk_indIP FOREIGN KEY (indIP) REFERENCES Segment(indIP) EXCEPTIONS INTO Rejets;

