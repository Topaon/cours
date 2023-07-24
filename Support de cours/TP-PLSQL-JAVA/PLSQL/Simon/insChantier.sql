INSERT INTO employe VALUES ('E1', 'Alan', 'OS');
INSERT INTO employe VALUES ('E2', 'Alain', 'Assistant');
INSERT INTO employe VALUES ('E3', 'Albert', 'Ingénieur');
INSERT INTO employe VALUES ('E4', 'Arthur', 'Architecte');
INSERT INTO employe VALUES ('E5', 'Alex', 'OS');
INSERT INTO employe VALUES ('E6', 'Achille', 'Assistant');
INSERT INTO employe VALUES ('E7', 'Abraham', 'Ingénieur');
INSERT INTO employe VALUES ('E8', 'Aaron', 'Architecte');
INSERT INTO employe VALUES ('E9', 'Adam', 'OS');
INSERT INTO employe VALUES ('E10', 'Alexandre', 'Assistant');

INSERT INTO chantier VALUES ('C1', 'Bois_Dore', '95310');
INSERT INTO chantier VALUES ('C2', 'Fontaine', '94230');
INSERT INTO chantier VALUES ('C3', 'F_Mitt', '92260');
INSERT INTO chantier VALUES ('C4', 'G_Clooney', '75016');

INSERT INTO vehicule VALUES ('V1', '0', 150000);
INSERT INTO vehicule VALUES ('V2', '1', 72000);
INSERT INTO vehicule VALUES ('V3', '2', 65000);
INSERT INTO vehicule VALUES ('V4', '0', 122000);
INSERT INTO vehicule VALUES ('V5', '1', 160000);

INSERT INTO visite VALUES ('C1', 'V1', TO_DATE('03/07/23', 'dd/mm/yy'), 150000, 'E1', 1);
INSERT INTO visite VALUES ('C2', 'V2', TO_DATE('04/07/23', 'dd/mm/yy'), 72000, 'E2', 1);
INSERT INTO visite VALUES ('C3', 'V3', TO_DATE('05/07/23', 'dd/mm/yy'), 65000, 'E3', 1);