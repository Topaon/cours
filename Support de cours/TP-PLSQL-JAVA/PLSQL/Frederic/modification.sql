UPDATE Segment 
    SET etage = 0
    WHERE indIP = '130.120.80';

UPDATE Segment 
    SET etage = 1
    WHERE indIP = '130.120.81';

UPDATE Segment 
    SET etage = 2
    WHERE indIP = '130.120.82';

UPDATE logiciel SET prix = prix*0.9 WHERE typelog='PCNT';

SELECT * FROM segment;
SELECT nLog, typeLog, prix FROM logiciel;