INSERT INTO segment VALUES('130.120.80', 'Brin RDC', null );
INSERT INTO segment VALUES('130.120.81', 'Brin 1er etage', null );
INSERT INTO segment VALUES('130.120.82', 'Brin 2eme etage', null );

INSERT INTO salle VALUES('s01', 'Salle 1', 3, '130.120.80');
INSERT INTO salle VALUES('s02', 'Salle 2', 2, '130.120.80');
INSERT INTO salle VALUES('s03', 'Salle 3', 2, '130.120.80');
INSERT INTO salle VALUES('s11', 'Salle 11', 2, '130.120.81');
INSERT INTO salle VALUES('s12', 'Salle 12', 1, '130.120.81');
INSERT INTO salle VALUES('s21', 'Salle 21', 2, '130.120.82');
INSERT INTO salle VALUES('s22', 'Salle 22', 0, '130.120.82');
INSERT INTO salle VALUES('s23', 'Salle 23', 0, '130.120.82');

INSERT INTO poste VALUES('p1', 'Poste 1', '130.120.80', '01', 'TX', 's01');
INSERT INTO poste VALUES('p2', 'Poste 2', '130.120.80', '02', 'UNIX', 's01');
INSERT INTO poste VALUES('p3', 'Poste 3', '130.120.80', '03', 'TX', 's01');
INSERT INTO poste VALUES('p4', 'Poste 4', '130.120.80', '04', 'PCWS', 's02');
INSERT INTO poste VALUES('p5', 'Poste 5', '130.120.80', '05', 'PCWS', 's02');
INSERT INTO poste VALUES('p6', 'Poste 6', '130.120.80', '06', 'UNIX', 's03');
INSERT INTO poste VALUES('p7', 'Poste 7', '130.120.80', '07', 'TX', 's03');
INSERT INTO poste VALUES('p8', 'Poste 8', '130.120.81', '01', 'UNIX', 's11');
INSERT INTO poste VALUES('p9', 'Poste 9', '130.120.81', '02', 'TX', 's11');
INSERT INTO poste VALUES('p10', 'Poste 10', '130.120.81', '03', 'UNIX', 's12');
INSERT INTO poste VALUES('p11', 'Poste 11', '130.120.82', '01', 'PCNT', 's21');
INSERT INTO poste VALUES('p12', 'Poste 12', '130.120.82', '02', 'PCWS', 's21');

INSERT INTO logiciel VALUES('log1', 'Oracle 6', TO_DATE('13/05/95', 'dd/mm/yy'), '6.2', 'UNIX', 3000);
INSERT INTO logiciel VALUES('log2', 'Oracle 8', TO_DATE('13/09/99', 'dd/mm/yy'), '8i', 'UNIX', 5600);
INSERT INTO logiciel VALUES('log3', 'SQL Server', TO_DATE('12/04/98', 'dd/mm/yy'), '7', 'PCNT', 2700);
INSERT INTO logiciel VALUES('log4', 'Front Page', TO_DATE('03/06/97', 'dd/mm/yy'), '5', 'PCWS', 500);
INSERT INTO logiciel VALUES('log5', 'WinDev', TO_DATE('12/05/97', 'dd/mm/yy'), '5', 'PCWS', 750);
INSERT INTO logiciel VALUES('log6', 'SQL*Net', null, '2.0', 'UNIX', 500);
INSERT INTO logiciel VALUES('log7', 'I. I. S.', TO_DATE('12/04/02', 'dd/mm/yy'), '2', 'PCNT', 810);
INSERT INTO logiciel VALUES('log8', 'DreamWeaver', TO_DATE('21/09/03', 'dd/mm/yy'), '2.0', 'BeOs', 1400);

INSERT INTO types VALUES('TX', 'Terminal X-Window');
INSERT INTO types VALUES('UNIX', 'Système Unix');
INSERT INTO types VALUES('PCNT', 'PC Windows NT');
INSERT INTO types VALUES('PCWS', 'PC Windows');
INSERT INTO types VALUES('NC', 'Network Computer');

CREATE SEQUENCE sequenceIns
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 10000
    NOCYCLE;

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