DELETE FROM Segment;
insert into segment values ('130.120.80', 'Brin RDC', null);
insert into segment values('130.120.81', 'Brin 1er étage', null);
insert into segment values('130.120.82', 'Brin 2e étage', null);




DELETE FROM Salle;
insert into salle values ('s01','Salle 1',3,'130.120.80');
insert into salle values ('s02', 'Salle 2',2,'130.120.80');
insert into salle values ('s03', 'Salle 3',2, '130.120.80');
insert into salle values ('s11', 'Salle 11',2, '130.120.81');
insert into salle values ('s12', 'Salle 12',1, '130.120.81');
insert into salle values ('s21', 'Salle 21',2, '130.120.82');
-- a supprimer a l'exo 3-4 insert into salle values ('s22', 'Salle 22',0, '130.120.83');
-- a supprimer a l'exo 3-4 insert into salle values ('s23', 'Salle 23',0, '130.120.83');

DELETE FROM Poste;
insert into Poste values ('p1', 'Poste 1','01', 'TX', '130.120.80',  's01' );
insert into Poste values ('p2', 'Poste 2', '02', 'UNIX','130.120.80',  's01' );
insert into Poste values ('p3', 'Poste 3', '03', 'TX','130.120.80',  's01' );
insert into Poste values ('p4', 'Poste 4','04', 'PCWS', '130.120.80',  's02' );
insert into Poste values ('p5', 'Poste 5',  '05', 'PCWS','130.120.80', 's02' );
insert into Poste values ('p6', 'Poste 6','06', 'UNIX', '130.120.80',  's03' );
insert into Poste values ('p7', 'Poste 7', '07', 'TX','130.120.80',  's03' );
insert into Poste values ('p8', 'Poste 8',  '01', 'UNIX','130.120.81', 's11' );
insert into Poste values ('p9', 'Poste 9', '02', 'TX','130.120.81',  's11' );
insert into Poste values ('p10', 'Poste 10', '03', 'UNIX','130.120.81',  's12' );
insert into Poste values ('p11', 'Poste 11', '01', 'PCNT','130.120.82',  's21' );
insert into Poste values ('p12', 'Poste 12', '02', 'PCWS','130.120.82',  's21' );


DELETE FROM Logiciel;

insert into Logiciel values ('log1', 'Oracle 6', TO_DATE('13/05/1995','dd/mm/yyyy'), '6.2', 'UNIX', 3000 );
insert into Logiciel values ('log2', 'Oracle 8', TO_DATE('15/09/1999','dd/mm/yyyy'), '8i', 'UNIX', 5600 );
insert into Logiciel values ('log3', 'SQL Server',TO_DATE('12/04/1998','dd/mm/yyyy'), '7', 'PCNT', 2700 );
insert into Logiciel values ('log4', 'Front Page', TO_DATE('03/06/1997','dd/mm/yyyy'), '5', 'PCWS', 500 );
insert into Logiciel values ('log5', 'WinDev', TO_DATE('12/05/1997','dd/mm/yyyy'), '5', 'PCWS', 750 );
insert into Logiciel values ('log6', 'SQL*Net', null, '2.0', 'UNIX', 500 );
insert into Logiciel values ('log7', 'I.I.S', TO_DATE('12/04/2002','dd/mm/yyyy'), '2', 'PCNT', 810 );
insert into Logiciel values ('log8', 'DreamWeaver', TO_DATE('21/09/2003','dd/mm/yyyy'), '2.0', 'BeOS', 1400 );

DELETE FROM Types;

insert into types values ('TX', 'Terminal X-Window');
insert into types values('UNIX', 'Systeme Unix');
insert into types values('PCNT', 'PC Windows NT');
insert into types values('PCWS','PC Windows');
insert into types values('NC', 'Network Computer');


DELETE FROM Installer;
CREATE SEQUENCE sequenceIns START WITH 1 INCREMENT BY 1 MAXVALUE 10000 NOCYCLE;
INSERT INTO installer VALUES('p2', 'log1', sequenceIns.NEXTVAL, TO_DATE('15/05/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p2', 'log2', sequenceIns.NEXTVAL, TO_DATE('17/09/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p4', 'log5', sequenceIns.NEXTVAL, DEFAULT, null);
INSERT INTO installer VALUES('p6', 'log6', sequenceIns.NEXTVAL, TO_DATE('20/05/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p6', 'log1', sequenceIns.NEXTVAL, TO_DATE('20/05/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p8', 'log2', sequenceIns.NEXTVAL, TO_DATE('19/05/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p8', 'log6', sequenceIns.NEXTVAL, TO_DATE('20/05/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p11', 'log3', sequenceIns.NEXTVAL, TO_DATE('20/04/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p12', 'log4', sequenceIns.NEXTVAL, TO_DATE('20/04/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p11', 'log7', sequenceIns.NEXTVAL, TO_DATE('20/04/03', 'dd/mm/yy'), null);
INSERT INTO installer VALUES('p7', 'log7', sequenceIns.NEXTVAL, TO_DATE('01/04/02', 'dd/mm/yy'), null);


DROP SEQUENCE sequenceIns;



