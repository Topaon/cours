UPDATE segment SET etage = 0 WHERE indip='130.120.80';
UPDATE segment SET etage = 1 WHERE indip='130.120.81';
UPDATE segment SET etage = 2 WHERE indip='130.120.82';

UPDATE logiciel SET prix = prix*0.9 WHERE typelog='PCNT';

SELECT * FROM segment;
SELECT nLog, typeLog, prix FROM logiciel;