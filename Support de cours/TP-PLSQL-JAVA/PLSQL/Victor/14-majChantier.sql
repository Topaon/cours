UPDATE Vehicule SET nb_places = 
                        CASE type_vehicule
                            WHEN '0' THEN 6
                            WHEN '1' THEN 1
                            WHEN '2' THEN 3
                            ELSE -1 -- Valeur par défaut si le type de véhicule n'a pas de correspondance
                        END;


SELECT type_vehicule,nb_places FROM Vehicule;

DELETE FROM Interdire;
INSERT INTO Interdire VALUES ('2','C3');
INSERT INTO Interdire VALUES ('1','C2');


DELETE FROM Autoriser;

INSERT INTO Autoriser VALUES ('E1','1');
INSERT INTO Autoriser VALUES ('E1','2');

INSERT INTO Autoriser VALUES ('E9','0');
INSERT INTO Autoriser VALUES ('E9','1');

INSERT INTO Autoriser VALUES ('E7','0');
INSERT INTO Autoriser VALUES ('E7','2');