-- Exercice 4-2 Requêtes monotable
--1.Type du poste 'p8'.
SELECT typePoste FROM Poste WHERE nPoste = 'p8';
--2. Noms des logiciels Unix.
SELECT nomlog FROM Logiciel WHERE typeLog= UPPER('UNIX');
--3. Nom, adresse IP, numéro de salle des postes de type 'Unix' ou 'PCWS'.
SELECT nomposte, indip, nsalle FROM Poste WHERE typeposte = UPPER('unix') OR typeposte = UPPER('PCWS');
--4. Même requête pour les postes du segment '130.120.80' triés par numéros de salles décroissants.
SELECT nomposte, indip, nsalle FROM Poste WHERE indip = '130.120.80' ORDER BY nsalle DESC;
--5. Numéros des logiciels installés sur le poste 'p6'.
SELECT nLog FROM Installer WHERE nPoste = 'p6';
--6. Numéros des postes qui hébergent le logiciel 'log1'.
SELECT nPoste FROM Installer WHERE nLog = 'log1';
--7. Nom et adresse IP complète (ex : '130.120.80.01') des postes de type TX (utiliser l’opérateur de concaténation).
SELECT nPoste || indIP FROM Poste WHERE typePoste = UPPER('TX');


-- Exercice 4-3 Fonctions et groupements
--8. Pour chaque poste, le nombre de logiciels installés (en utilisant la table Installer).
SELECT nPoste, COUNT(nLog) FROM Installer GROUP BY nPoste ;
--9. Pour chaque salle, le nombre de postes (à partir de la table Poste).
SELECT  nSalle, COUNT(nPoste) FROM Poste GROUP BY nSalle;
--10. Pour chaque logiciel, le nombre d’installations sur des postes différents.
SELEcT nLog, COUNT(numIns) FROM Installer GROUP BY nLog;
--11. Moyenne des prix des logiciels 'Unix'.
SELECT AVG(prix) FROM Logiciel WHERE typelog=Upper('UNIX');
--12. Plus récente date d’achat d’un logiciel.
SELECT nomLog,dateAch FROM Logiciel WHERE dateAch = (SELECT max(dateAch) FROM Logiciel);
--13. Numéros des postes hébergeant 2 logiciels.
SELECT nPoste FROM Installer GROUP BY nPoste HAVING COUNT(nLog) = 2;
--14. Nombre de postes hébergeant 2 logiciels (utiliser la requête précédente en faisant un SELECT dans la clause FROM).


-- EXERCICE 4-4 Requetes multitables
--15. Types de postes non recensés dans le parc informatique (utiliser la table Types).
SELECT typeLp FROM Types t 
LEFT OUTER JOIN poste p ON t.typelp = p.typePoste 
WHERE p.typePoste IS NULL;
--16. Types existant à la fois comme types de postes et de logiciels.
--17. Types de postes de travail n’étant pas des types de logiciel.
--18. Adresses IP des postes qui hébergent le logiciel 'log6'.
SELECT indIP FROM Poste p 
JOIN Installer i ON p.nPoste = i.nPoste 
WHERE nLog = 'log6';
--19. Adresses IP des postes qui hébergent le logiciel de nom 'Oracle 8'.
SELECT indIP, nomPoste FROM Poste p 
JOIN Installer i ON p.nPoste = i.nPoste
JOIN Logiciel l ON i.nLog = l.nLog  
WHERE l.nomLog = 'Oracle 8';
--20. Noms des segments possédant exactement trois postes de travail de type 'TX'.
SELECT nomSegment FROM Segment s JOIN Poste p ON s.indIp = p.indIp WHERE  COUNT(nPoste) = 3 AND typePoste = 'TX';
--21. Noms des salles où l’on peut trouver au moins un poste hébergeant le logiciel 'Oracle 6'.
--22. Nom du logiciel acheté le plus récent (utiliser la requête 12).