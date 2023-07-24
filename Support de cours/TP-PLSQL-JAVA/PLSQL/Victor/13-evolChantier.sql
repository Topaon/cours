
ALTER TABLE Vehicule ADD nb_places NUMBER(2);


DROP TABLE Autoriser;
DROP TABLE Interdire;
 
CREATE TABLE Autoriser (
    n_emp           VARCHAR(4),
    type_vehicule      VARCHAR(10),                                        
    CONSTRAINT fk_autoriser_emp FOREIGN KEY (n_emp) REFERENCES Employe (n_emp),
    --CONSTRAINT fk_autoriser_type_vehicule FOREIGN KEY (type_vehicule) REFERENCES Vehicule (type_vehicule),
    CONSTRAINT pk_autoriser PRIMARY KEY (n_emp,type_vehicule)
);

CREATE TABLE Interdire (
    type_vehicule      VARCHAR(10),  
    n_chantier      VARCHAR(4),
    --CONSTRAINT fk_interdire_type_vehicule FOREIGN KEY (type_vehicule) REFERENCES Vehicule (type_vehicule),                              
    CONSTRAINT fk_interdire_chantier FOREIGN KEY (n_chantier) REFERENCES Chantier (n_chantier),
    CONSTRAINT pk_interdire PRIMARY KEY (type_vehicule,n_chantier)
);


ALTER TABLE Visite ADD temps_trajet NUMBER AS (ROUND(kilometrage/40));