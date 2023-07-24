DELETE FROM Segment;
INSERT INTO Segment (indIP,nomSegment) VALUES('130.120.80','Brin RDC');
INSERT INTO Segment (indIP,nomSegment) VALUES('130.120.81','Brin 1er etage');
INSERT INTO Segment (indIP,nomSegment) VALUES('130.120.82','Brin 2eme etage');

DELETE FROM Salle;
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s01','Salle 1',3,'130.120.80');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s02','Salle 2',2,'130.120.80');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s03','Salle 3',2,'130.120.80');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s11','Salle 11',2,'130.120.81');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s12','Salle 12',1,'130.120.81');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s21','Salle 21',2,'130.120.82');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s22','Salle 22',0,'130.120.83');
INSERT INTO Salle (nSalle,nomSalle,nbPoste,indIP) VALUES('s23','Salle 23',0,'130.120.83');
--(pas de 83 déclaré)


DELETE FROM Poste;
-- (nPoste,nomPoste,indIP,ad,typePoste,Salle)
INSERT INTO Poste VALUES('p1','Poste 1','130.120.80',1,'TX','s01');
INSERT INTO Poste VALUES('p2','Poste 2','130.120.80',2,'UNIX','s01');
INSERT INTO Poste VALUES('p3','Poste 3','130.120.80',3,'TX','s01');
INSERT INTO Poste VALUES('p4','Poste 4','130.120.80',4,'PCWS','s02');
INSERT INTO Poste VALUES('p5','Poste 5','130.120.80',5,'PCWS','s02');
INSERT INTO Poste VALUES('p6','Poste 6','130.120.80',6,'UNIX','s03');
INSERT INTO Poste VALUES('p7','Poste 7','130.120.80',7,'TX','s03');
INSERT INTO Poste VALUES('p8','Poste 8','130.120.81',1,'UNIX','s11');
INSERT INTO Poste VALUES('p9','Poste 9','130.120.81',2,'TX','s11');
INSERT INTO Poste VALUES('p10','Poste 10','130.120.81',3,'UNIX','s12');
INSERT INTO Poste VALUES('p11','Poste 11','130.120.82',1,'PCNT','s21');
INSERT INTO Poste VALUES('p12','Poste 12','130.120.82',2,'PCWS','s21');


DELETE FROM Logiciel;
INSERT INTO Logiciel VALUES('log1','Oracle 6','13/05/95','6.2','UNIX',3000);
INSERT INTO Logiciel VALUES('log2','Oracle 8','15/09/99','8i','UNIX',5600);
INSERT INTO Logiciel VALUES('log3','SQL Server','12/04/98','7','PCNT',2700);
INSERT INTO Logiciel VALUES('log4','Front Page','03/06/97','5','PCWS',500);
INSERT INTO Logiciel VALUES('log5','WinDev','12/05/97','5','PCWS',750);
INSERT INTO Logiciel VALUES('log6','SQL*Net','','2.0','UNIX',500);
INSERT INTO Logiciel VALUES('log7','I. I. S.','12/04/02','2','PCNT',810);
INSERT INTO Logiciel VALUES('log8','DreamWeaver','21/09/03','2.0','BeOS',1400);

DELETE FROM Types;
INSERT INTO Types VALUES('TX','Terminal X-Window');
INSERT INTO Types VALUES('UNIX','Système Unix');
INSERT INTO Types VALUES('PCNT','PC Windows NT');
INSERT INTO Types VALUES('PCWS','PC Windows');
INSERT INTO Types VALUES('NC','Network Computer');
