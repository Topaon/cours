ALTER TABLE Segment ADD nbSalle NUMBER(2);
ALTER TABLE Segment ADD nbPoste NUMBER(2);
ALTER TABLE Logiciel ADD nbInstall NUMBER(2);
ALTER TABLE Poste ADD nbLog NUMBER(2);

DESC Segment;
DESC Logiciel;
DESC Poste;
SELECT * FROM Segment;
SELECT * FROM Logiciel;
SELECT * FROM Poste;

ALTER TABLE Salle MODIFY nomSalle VARCHAR2(30);
ALTER TABLE Segment MODIFY nomSegment VARCHAR2(15);
ALTER TABLE segment MODIFY nomSegment VARCHAR2(14); 
-- Ne fonctionne pas car certaines valeurs déjà  insérées dans la colonne font plus de 14 caractères
-- (ORA-01441: cannot decrease column length because some value is too big)

DESC Segment;
DESC Salle;
SELECT * FROM Salle;
SELECT * FROM Segment;

ALTER TABLE Poste ADD CONSTRAINT fk_Poste_TypePoste_Types FOREIGN KEY (typePoste) REFERENCES Types(typeLP); 

