
INSERT INTO Segment VALUES('130.120.80','Brin RDC',null);
INSERT INTO Segment VALUES('130.120.81','Brin 1er étage',null);
INSERT INTO Segment VALUES('130.120.82','Brin 2ème étage',null);
-- ajout de la ligne suivantes pour insert s22 et s23
INSERT INTO Segment VALUES('130.120.83','Brin 3ème étage',null);

INSERT INTO Salle VALUES('s01','Salle 1',3,'130.120.80');
INSERT INTO Salle VALUES('s02','Salle 2',2,'130.120.80');
INSERT INTO Salle VALUES('s03','Salle 3',2,'130.120.80');
INSERT INTO Salle VALUES('s11','Salle 11',2,'130.120.81');
INSERT INTO Salle VALUES('s12','Salle 12',1,'130.120.81');
INSERT INTO Salle VALUES('s21','Salle 21',2,'130.120.82');
INSERT INTO Salle VALUES('s22','Salle 22',0,'130.120.83');
INSERT INTO Salle VALUES('s23','Salle 23',0,'130.120.83');

INSERT INTO Poste VALUES('p1','Poste 1','130.120.80','01','TX','s01');
INSERT INTO Poste VALUES('p2','Poste 2','130.120.80','02','UNIX','s01');
INSERT INTO Poste VALUES('p3','Poste 3','130.120.80','03','TX','s01');
INSERT INTO Poste VALUES('p4','Poste 4','130.120.80','04','PCWS','s02');
INSERT INTO Poste VALUES('p5','Poste 5','130.120.80','05','PCWS','s02');
INSERT INTO Poste VALUES('p6','Poste 6','130.120.80','06','UNIX','s03');
INSERT INTO Poste VALUES('p7','Poste 7','130.120.80','07','TX','s03');
INSERT INTO Poste VALUES('p8','Poste 8','130.120.81','01','UNIX','s11');
INSERT INTO Poste VALUES('p9','Poste 9','130.120.81','02','TX','s11');
INSERT INTO Poste VALUES('p10','Poste 10','130.120.81','03','UNIX','s12');
INSERT INTO Poste VALUES('p11','Poste 11','130.120.82','01','PCNT','s21');
INSERT INTO Poste VALUES('p12','Poste 12','130.120.82','02','PCWS','s21');

INSERT INTO Logiciel VALUES('log1','Oracle 6',TO_DATE('13/05/95','DD/MM/YY'),'6.2','UNIX',3000);
INSERT INTO Logiciel VALUES('log2','Oracle 8',TO_DATE('15/09/99','DD/MM/YY'),'8i','UNIX',5600);
INSERT INTO Logiciel VALUES('log3','SQL Server',TO_DATE('12/04/98','DD/MM/YY'),'7','PCNT',2700);
INSERT INTO Logiciel VALUES('log4','Front Page',TO_DATE('03/06/97','DD/MM/YY'),'5','PCWS',500);
INSERT INTO Logiciel VALUES('log5','WinDev',TO_DATE('12/05/97','DD/MM/YY'),'5','PCWS',750);
INSERT INTO Logiciel VALUES('log6','SQL*Net',null,'2.0','UNIX',500);
INSERT INTO Logiciel VALUES('log7','I. I. S.',TO_DATE('12/04/02','DD/MM/YY'),'2','PCNT',810);
INSERT INTO Logiciel VALUES('log8','DreamWeaver',TO_DATE('21/09/03','DD/MM/YY'),'2.0','BeOS',1400);

INSERT INTO Types VALUES('TX','Terminal X-Window');
INSERT INTO Types VALUES('UNIX','Système Unix');
INSERT INTO Types VALUES('PCNT','PC Windows NT');
INSERT INTO Types VALUES('PCWS','PC Windows');
INSERT INTO Types VALUES('NC','Network Computer');

DROP SEQUENCE sequenceIns;
CREATE SEQUENCE sequenceIns
INCREMENT BY 1
START WITH 1
MAXVALUE 10000
NOCYCLE;


-- Utilisez cette séquence pour estimer la colonne numIns
-- Increment de 1, maxvalue 10 000 donc numIns de 1 à 10 000
INSERT INTO Installer VALUES('p2','log1',sequenceIns.nextval,TO_DATE('15/05/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p2','log2',sequenceIns.nextval,TO_DATE('17/09/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p4','log5',sequenceIns.nextval,null,null);
INSERT INTO Installer VALUES('p6','log6',sequenceIns.nextval,TO_DATE('20/05/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p6','log1',sequenceIns.nextval,TO_DATE('20/05/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p8','log2',sequenceIns.nextval,TO_DATE('19/05/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p8','log6',sequenceIns.nextval,TO_DATE('20/05/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p11','log3',sequenceIns.nextval,TO_DATE('20/04/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p12','log4',sequenceIns.nextval,TO_DATE('20/04/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p11','log7',sequenceIns.nextval,TO_DATE('20/04/03','DD/MM/YY'),null);
INSERT INTO Installer VALUES('p7','log7',sequenceIns.nextval,TO_DATE('01/04/03','DD/MM/YY'),null);
