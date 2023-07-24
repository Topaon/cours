DROP SEQUENCE sequenceIns;
CREATE SEQUENCE sequenceIns START WITH 1 INCREMENT BY 1 MAXVALUE 10000 NOCYCLE;

DELETE FROM Installer;
INSERT INTO Installer VALUES('p2','log1', sequenceIns.NEXTVAL ,'15/05/03','');
INSERT INTO Installer VALUES('p2','log2', sequenceIns.NEXTVAL ,'17/09/03','');
INSERT INTO Installer VALUES('p4','log5', sequenceIns.NEXTVAL ,'','');
INSERT INTO Installer VALUES('p6','log6', sequenceIns.NEXTVAL ,'20/05/03','');
INSERT INTO Installer VALUES('p6','log1', sequenceIns.NEXTVAL ,'20/05/03','');
INSERT INTO Installer VALUES('p8','log2', sequenceIns.NEXTVAL ,'19/05/03','');
INSERT INTO Installer VALUES('p8','log6', sequenceIns.NEXTVAL ,'20/05/03','');
INSERT INTO Installer VALUES('p11','log3', sequenceIns.NEXTVAL ,'20/04/03','');
INSERT INTO Installer VALUES('p12','log4', sequenceIns.NEXTVAL ,'20/04/03','');
INSERT INTO Installer VALUES('p11','log7', sequenceIns.NEXTVAL ,'20/04/03','');
INSERT INTO Installer VALUES('p7','log7', sequenceIns.NEXTVAL ,'01/04/02','');
