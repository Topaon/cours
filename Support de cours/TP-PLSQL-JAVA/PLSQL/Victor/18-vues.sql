CREATE VIEW LogicielsUnix AS
	SELECT nLog
    FROM Poste p
        LEFT JOIN Salle s ON p.nSalle = s.nSalle
    WHERE typeLog='UNIX';

DESC LogicielsUnix;
SELECT * FROM LogicielsUnix;


CREATE VIEW Poste_0 AS
	SELECT p.nPoste, p.nomPoste, p.nSalle, p.typePoste, p.indIP, p.ad
    FROM Poste p
    LEFT JOIN Segment s ON p.indIP = s.indIP
    WHERE s.etage=0;

DESC Poste_0;

SELECT * FROM Poste_0;
DROP VIEW LogicielsUnix;
DROP VIEW Poste_0;


CREATE VIEW SallePrix AS
	SELECT nSalle, nomSalle, nbPoste, 100*nbPoste AS prixLocation
    FROM Salle;

DESC SallePrix;
SELECT * FROM SallePrix;
SELECT nSalle FROM SallePrix WHERE prixLocation >= 150;
DROP VIEW SallePrix;