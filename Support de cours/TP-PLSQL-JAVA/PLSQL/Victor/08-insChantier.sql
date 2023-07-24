--UPDATE Segment SET etage = 0 WHERE indIP = '130.120.80';

DELETE FROM Employe;
INSERT INTO Employe VALUES ('E1', 'Bob1', 'OS');
INSERT INTO Employe VALUES ('E2', 'Bob2', 'Ingénieur');
INSERT INTO Employe VALUES ('E3', 'Bob3', 'Architecte');
INSERT INTO Employe VALUES ('E4', 'Bob4', 'Assistant');
INSERT INTO Employe VALUES ('E5', 'Bob5', 'Assistant');
INSERT INTO Employe VALUES ('E6', 'Bob6', 'Assistant');
INSERT INTO Employe VALUES ('E7', 'Bob7', 'Assistant');
INSERT INTO Employe VALUES ('E8', 'Bob8', 'Assistant');
INSERT INTO Employe VALUES ('E9', 'Bob9', 'Assistant');
INSERT INTO Employe VALUES ('E10', 'Bob10', 'Assistant');

--  OS, Assistant, Ingénieur et Architecte
   

DELETE FROM Chantier;
INSERT INTO Chantier VALUES ('C1', 'Chantier1', '5 rue Rue');
INSERT INTO Chantier VALUES ('C2', 'Chantier2', '6 rue Rue');
INSERT INTO Chantier VALUES ('C3', 'Chantier3', '7 rue Rue');
INSERT INTO Chantier VALUES ('C4', 'Chantier4', '8 rue Rue');


/*
n_chantier      VARCHAR(10), 
    nom_ch          VARCHAR(10), 
    adresse_ch      VARCHAR (15),
    */

DELETE FROM Vehicule;
INSERT INTO Vehicule VALUES ('Ve1', '2', 10000);
INSERT INTO Vehicule VALUES ('Ve2', '0', 50000);
INSERT INTO Vehicule VALUES ('Ve3', '2', 40000);
INSERT INTO Vehicule VALUES ('Ve4', '0', 20000);
INSERT INTO Vehicule VALUES ('Ve5', '2', 60000);

--0 pour une camionnette, 1 pour une moto et 2 pour une voiture

/* n_vehicule      VARCHAR(10),
    type_vehicule   VARCHAR(1), 
    kilometrage     NUMBER,*/

DELETE FROM Visite;
INSERT INTO Visite VALUES ('Vi1', 'C1', 'Ve1','E1',500,'15/05/04');
INSERT INTO Visite VALUES ('Vi2', 'C2', 'Ve4','E9',500,'17/06/04');
INSERT INTO Visite VALUES ('Vi3', 'C3', 'Ve5','E7',500,'15/07/05');



/*

    n_visite        VARCHAR(10),                                    --ajout
    n_chantier      VARCHAR(10),                                    --ajout
    n_vehicule      VARCHAR(10),                                    --ajout
    n_conducteur    VARCHAR2(4),                                    --ajout 
    kilometrage   NUMBER,                                    --ajout      
    date_jour       DATE, 

*/


DELETE FROM Transporter;
INSERT INTO Transporter VALUES ('E2','Vi1');
INSERT INTO Transporter VALUES ('E3','Vi1');
INSERT INTO Transporter VALUES ('E4','Vi1');
INSERT INTO Transporter VALUES ('E5','Vi2');
INSERT INTO Transporter VALUES ('E6','Vi2');
INSERT INTO Transporter VALUES ('E8','Vi3');
INSERT INTO Transporter VALUES ('E10','Vi3');


/*

     n_emp       VARCHAR(4),                                         
    n_visite        VARCHAR(10) ,

*/