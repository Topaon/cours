ALTER TABLE Segment ADD nbSalle NUMBER(2);
ALTER TABLE Segment ADD nbPoste NUMBER(2);
ALTER TABLE Logiciel ADD nbInstall NUMBER(2);
ALTER TABLE Poste ADD nbLog NUMBER(2);

ALTER TABLE salle MODIFY nomSalle VARCHAR2(30);
ALTER TABLE segment MODIFY nomSegment VARCHAR2(15);
ALTER TABLE segment MODIFY nomSegment VARCHAR2(14); -- Ne marche pas car certaines valeurs de la colonne font plus de 14 caractères

CREATE TABLE Rejets(
    ligne ROWID,
    propriétaire VARCHAR2(30),
    nomTable VARCHAR2(30),
    contrainte VARCHAR2(30)
)

ALTER TABLE Logiciel 
ADD CONSTRAINT fk_nomType_logiciel 
FOREIGN KEY(typeLog)
REFERENCES Types(typeLP)
EXCEPTIONS INTO Rejets;

INSERT INTO types VALUES('BeOs', 'Système Be');

