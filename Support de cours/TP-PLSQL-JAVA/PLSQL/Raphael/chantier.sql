CREATE TABLE employe(
    n_emp VARCHAR(4),
    nom_emp VARCHAR(20),
    qualif_emp VARCHAR(12),
    CONSTRAINT pk_emp PRIMARY KEY (n_emp)
);
CREATE TABLE chantier(
    n_chantier VARCHAR(10),
    nom_ch VARCHAR(10),
    adresse_ch VARCHAR(15,
    CONSTRAINT pk_chan PRIMARY KEY (n_chantier)
);

CREATE TABLE vehicule(
    n_vehicule VARCHAR(10),
    type_vehicule VARCHAR(1),
    kilometrage NUMBER,
    CONSTRAINT pk_vehi PRIMARY KEY (n_vehicule)
);

CREATE TABLE visite(
    n_chantier VARCHAR(10),
    n_vehicule VARCHAR(10),
    date_jour DATE,
    kilometres NUMBER,
    n_transporte VARCHAR2(4),
    CONSTRAINT pk_visite PRIMARY KEY (mix de plusieurs),
    CONSTRAINT fk_depl_chantier FOREIGN KEY (n_chantier) REFERENCES chantier(n_chantier),
    CONSTRAINT fk_depl_vehicule FOREIGN KEY (n_vehicule) REFERENCES vehicule(n_vehicule),
    CONSTRAINT fk_depl_employe FOREIGN KEY (n_conducteur) REFERENCES transport(n_conducteur)
);

CREATE TABLE transport(
    n_conducteur VARCHAR2(4),
    CONSTRAINT pk_transporter PRIMARY KEY (mix de plusieurs),
    CONSTRAINT fk_transp_visite FOREIGN KEY (something) REFERENCEs visite(pk_visite?),
    CONSTRAINT fk_transp_employe FOREIGN KEY n_emp REFERENCES employe(n_emp)
);