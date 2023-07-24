
ALTER TABLE Salle ADD CONSTRAINT fk_Salle_indIP_Segment 
        FOREIGN KEY (indIP) REFERENCES Segment (indIP)
		EXCEPTIONS INTO Rejets;

ALTER TABLE Logiciel ADD CONSTRAINT fk_Logiciel_typeLog_Types 
        FOREIGN KEY (typeLog) REFERENCES Types (typeLP)
		EXCEPTIONS INTO Rejets;

SELECT * FROM Rejets;
SELECT ROWID,s.* FROM Salle s WHERE ROWID IN (SELECT ligne FROM Rejets);
SELECT ROWID,l.* FROM Logiciel l WHERE ROWID IN (SELECT ligne FROM Rejets);


DELETE FROM Rejets;

DELETE FROM Salle WHERE nSalle='s22' OR nSalle='s23';
SELECT * FROM Salle;

INSERT INTO Types VALUES('BeOS','Systeme Be');

ALTER TABLE Salle ADD CONSTRAINT fk_Salle_indIP_Segment 
        FOREIGN KEY (indIP) REFERENCES Segment (indIP)
		EXCEPTIONS INTO Rejets;

ALTER TABLE Logiciel ADD CONSTRAINT fk_Logiciel_typeLog_Types 
        FOREIGN KEY (typeLog) REFERENCES Types (typeLP)
		EXCEPTIONS INTO Rejets;

SELECT * FROM Rejets;
SELECT ROWID,s.* FROM Salle s WHERE ROWID IN (SELECT ligne FROM Rejets);
SELECT ROWID,l.* FROM Logiciel l WHERE ROWID IN (SELECT ligne FROM Rejets);