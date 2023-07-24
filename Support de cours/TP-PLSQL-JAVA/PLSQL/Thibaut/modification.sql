/* UPDATE table
SET nom_colonne_1 = 'nouvelle valeur'
WHERE condition 

UPDATE table
SET colonne_1 = 'valeur 1', colonne_2 = 'valeur 2', colonne_3 = 'valeur 3'
WHERE condition*/

UPDATE Segment
SET etage = 0 WHERE indIP = '130.120.80';
UPDATE Segment
SET etage = 1 WHERE indIP = '130.120.81';
UPDATE Segment
SET etage = 2 WHERE indIP = '130.120.82';

/*SELECT * FROM Segment;
SELECT nLog, typeLog, prix FROM Logiciel;*/