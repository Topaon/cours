/*
UPDATE table1 alias1
    SET colonne = (SELECT COUNT(*)
        FROM table2 alias2
        WHERE alias2.colonneA=alias1.colonneB
    );
    */

INSERT INTO Installer VALUES('p2','log6', sequenceIns.NEXTVAL ,SYSDATE,'');
INSERT INTO Installer VALUES('p8','log1', sequenceIns.NEXTVAL ,SYSDATE,'');
INSERT INTO Installer VALUES('p10','log1', sequenceIns.NEXTVAL ,SYSDATE,'');


UPDATE Segment s
    SET nbSalle = (SELECT COUNT(*)
        FROM Salle sa
        WHERE sa.indIP=s.indIP
    );

SELECT * FROM Segment;

UPDATE Segment s
    SET nbPoste = (SELECT COUNT(*)
        FROM Poste p
        WHERE p.indIP=s.indIP
    );

SELECT * FROM Segment;


UPDATE Logiciel l
    SET nbInstall = (SELECT COUNT(*)
        FROM Installer i
        WHERE i.nLog=l.nLog
    );

SELECT * FROM Logiciel;

UPDATE Poste p
    SET nbLog = (SELECT COUNT(*)
        FROM Logiciel l
        LEFT JOIN Installer i ON l.nLog = i.nLog
        LEFT JOIN Poste p ON p.nPoste = i.nPoste
    );

SELECT * FROM Poste;
