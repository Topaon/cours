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











