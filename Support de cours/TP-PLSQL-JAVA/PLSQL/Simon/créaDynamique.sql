CREATE TABLE Softs AS SELECT nomLog, version, prix FROM logiciel;

CREATE TABLE PCSeuls AS SELECT nPoste, nomPoste, indIP, ad, typePoste, nSalle 
FROM poste 
WHERE typeposte='PCWS' OR typeposte='PCNT';