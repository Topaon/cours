SELECT typePoste FROM Poste WHERE nPoste='p8';
SELECT nomLog FROM Logiciel WHERE typeLog='UNIX';
SELECT nomPoste, indIP, nSalle FROM Poste WHERE (typePoste='UNIX' OR typePoste='PCWS');
SELECT nomPoste, indIP, nSalle FROM Poste WHERE indIP='130.120.80' ORDER BY nSalle DESC;
SELECT nLog FROM Installer WHERE nPoste='p6';
SELECT nPoste FROM Installer WHERE nLog='log1';
SELECT CONCAT(CONCAT(indIP,'.0'), ad ) FROM Poste WHERE typePoste='TX';



SELECT nPoste,COUNT(nLog) FROM Installer GROUP BY nPoste;
SELECT nSalle,COUNT(nPoste) FROM Poste GROUP BY nSalle;
SELECT nLog,COUNT(DISTINCT nPoste) FROM Installer GROUP BY nLog;
SELECT AVG(prix) FROM Logiciel WHERE typeLog='UNIX';
SELECT MAX(dateAch) FROM Logiciel;
SELECT nPoste FROM Installer GROUP BY nPoste HAVING COUNT(nLog) = 2;
SELECT COUNT(*) FROM (
    SELECT nPoste
    FROM Installer
    GROUP BY nPoste
    HAVING COUNT(nLog) = 2
);



SELECT nomType FROM Types WHERE typeLP NOT IN (
                        SELECT typePoste FROM Poste
                        UNION
                        SELECT typeLog FROM Logiciel
);

SELECT nomType FROM Types WHERE typeLP IN (
                        SELECT typePoste FROM Poste
                        INTERSECT
                        SELECT typeLog FROM Logiciel
);

SELECT nomType FROM Types WHERE typeLP IN (
                        SELECT typePoste FROM Poste
                        MINUS 
                        SELECT typeLog FROM Logiciel
);



SELECT p.indIP
FROM Installer i LEFT JOIN Poste p ON i.nPoste = p.nPoste
WHERE i.nLog='log6';

SELECT p.indIP
FROM Poste p
LEFT JOIN Installer i ON p.nPoste = i.nPoste
LEFT JOIN Logiciel l ON l.nLog = i.nLog
WHERE l.nomLog='Oracle 8';


SELECT s.nomSegment
FROM Segment s LEFT JOIN Poste p ON s.indIP = p.indIP
WHERE p.typePoste='TX' GROUP BY s.nomSegment HAVING COUNT(p.typePoste) = 3;


SELECT s.nomSalle
FROM Salle s
LEFT JOIN Poste p ON p.nSalle = s.nSalle
LEFT JOIN Installer i ON i.nPoste = p.nPoste
LEFT JOIN Logiciel l ON l.nLog = i.nLog
WHERE l.nomLog='Oracle 6';


--SELECT MAX(dateAch) AS dateAch FROM Logiciel;

SELECT l.nomLog
FROM Logiciel l
RIGHT JOIN (SELECT MAX(dateAch) AS dateAch FROM Logiciel) lmax ON l.dateAch = lmax.dateAch;





