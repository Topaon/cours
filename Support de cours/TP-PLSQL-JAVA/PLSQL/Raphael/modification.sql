UPDATE Segment SET etage = 0 WHERE indIp = '130.120.80';
UPDATE Segment SET etage = 1 WHERE indIp = '130.120.81';
UPDATE Segment SET etage = 2 WHERE indIp = '130.120.82';
UPDATE Segment SET etage = 3 WHERE indIp = '130.120.83';

SELECT * FROM Segment;

SELECT nLog, typeLog, prix FROM logiciel;

UPDATE Logiciel SET prix = prix * 1.1 WHERE typeLog = PCNT;

SELECT nLog, typeLog, prix FROM logiciel;

