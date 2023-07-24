CREATE TABLE Employe (
    n_emp           VARCHAR(4), 
    nom_emp         VARCHAR (20), 
    qualif_emp      VARCHAR (12),
    CONSTRAINT pk_emp PRIMARY KEY (n_emp)
);

CREATE TABLE Chantier (
    n_chantier      VARCHAR(10), 
    nom_ch          VARCHAR(10), 
    adresse_ch      VARCHAR (15),
    CONSTRAINT pk_chan PRIMARY KEY (n_chantier)
);

CREATE TABLE Vehicule (
    n_vehicule      VARCHAR(10),
    type_vehicule   VARCHAR(1), 
    kilometrage     NUMBER,
    CONSTRAINT pk_vehi PRIMARY KEY (n_vehicule)
);

 CREATE TABLE Visite (
    n_visite        VARCHAR(10),                                    --ajout
    n_chantier      VARCHAR(10),                                    --ajout
    n_vehicule      VARCHAR(10),                                    --ajout
    n_conducteur    VARCHAR2(4),                                    --ajout 
    kilometrage   NUMBER,                                    --ajout      
    date_jour       DATE,   
    CONSTRAINT pk_visite PRIMARY KEY (n_visite),
    CONSTRAINT fk_depl_chantier FOREIGN KEY  (n_chantier) REFERENCES chantier (n_chantier),
    CONSTRAINT fk_depl_vehicule FOREIGN KEY (n_vehicule) REFERENCES vehicule (n_vehicule),
    CONSTRAINT fk_depl_employe  FOREIGN KEY (n_conducteur) REFERENCES employe (n_emp)
    --CONSTRAINT fk_transporter   FOREIGN KEY (n_transporter) REFERENCES transporter (n_transporter)
);

 CREATE TABLE Transporter ( --une relation de transporter pour chaque employé transporté
    n_emp       VARCHAR(4),                                         
    n_visite        VARCHAR(10) ,
    CONSTRAINT fk_transp_visite FOREIGN KEY (n_visite) REFERENCES visite (n_visite),
    CONSTRAINT fk_n_emp FOREIGN KEY (n_emp) REFERENCES employe (n_emp),
    CONSTRAINT pk_transporter PRIMARY KEY (n_emp,n_visite)
);