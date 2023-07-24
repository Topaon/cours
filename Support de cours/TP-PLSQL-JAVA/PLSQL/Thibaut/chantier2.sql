CREATE TABLE Employe(
    n_emp VARCHAR(4),
    nom_emp VARCHAR(20),
    qualif_emp VARCHAR(12),
    CONSTRAINT pk_emp PRIMARY KEY(n_emp)
);

CREATE TABLE Chantier(
    n_chantier VARCHAR(10),
    nom_ch VARCHAR(10),
    adresse_ch VARCHAR(15),
    CONSTRAINT pk_chan PRIMARY KEY(n_chantier)
);

CREATE TABLE Vehicule(
    n_vehicule VARCHAR(10),
    type_vehicule VARCHAR(1),
    kilometrage NUMBER,
    CONSTRAINT pk_vehi PRIMARY KEY(n_vehicule)
);

CREATE TABLE Transporter(
    n_conducteur VARCHAR2(4),
    n_chantier VARCHAR(10),
    n_vehicule VARCHAR(10),
    n_transporte VARCHAR2(4),
    CONSTRAINT pk_transporter PRIMARY KEY(n_conducteur),
    CONSTRAINT fk_transp_employe FOREIGN KEY (n_transporte) REFERENCES Employe(n_emp)
);

CREATE TABLE Visite(
    n_chantier VARCHAR(10),
    n_vehicule VARCHAR(10),
    date_jour DATE,
    kilometres NUMBER,
    n_conducteur VARCHAR2(4),
    CONSTRAINT pk_visite PRIMARY KEY(n_chantier,n_vehicule),
    CONSTRAINT fk_depl_chantier FOREIGN KEY(n_chantier) REFERENCES Chantier(n_chantier),
    CONSTRAINT fk_depl_vehicule FOREIGN KEY(n_vehicule) REFERENCES Vehicule(n_vehicule),
    CONSTRAINT fk_depl_employe FOREIGN KEY(n_conducteur) REFERENCES Transporter(n_conducteur)
);

ALTER TABLE Transporter
add CONSTRAINT fk_transp_visite FOREIGN KEY (n_chantier,n_vehicule) REFERENCES Visite(n_chantier,n_vehicule);