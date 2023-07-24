
ALTER TABLE Segment ADD nbSalle NUMBER(2);
ALTER TABLE Segment ADD nbPoste NUMBER(2);

ALTER TABLE Logiciel ADD nbInstall NUMBER(2);

ALTER TABLE Poste ADD nbLog NUMBER(2);


ALTER TABLE Salle MODIFY nomSalle VARCHAR2(30);
DESC Segment;
ALTER TABLE Segment MODIFY nomSegment VARCHAR2(15);
DESC Segment;
--ALTER TABLE Segment MODIFY nomSegment VARCHAR2(14);
--DESC Segment; (ne passe pas car il y a un mot de 15 caractères)



ALTER TABLE Poste ADD CONSTRAINT fk_Poste_typePoste_Types 
        FOREIGN KEY (typePoste) REFERENCES Types (typeLP);


ALTER TABLE Poste ADD CONSTRAINT fk_Poste_nSalle_Salle 
        FOREIGN KEY (nSalle) REFERENCES Salle (nSalle);
