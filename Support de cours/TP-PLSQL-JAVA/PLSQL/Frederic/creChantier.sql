CREATE TABLE employe(
    n_emp VARCHAR(4), 
    nom_emp VARCHAR(20),
    qualif_emp VARCHAR(12),
    CONSTRAINT pk_emp PRIMARY KEY(n_emp));


CREATE TABLE chantier(
    n_chantier VARCHAR(10),
    nom_ch VARCHAR(10),
    adresse_ch VARCHAR(15),
    CONSTRAINT pk_chan PRIMARY KEY(n_chantier));
    
CREATE TABLE vehicule(
    n_vehicule VARCHAR(10),
    type_vehicule VARCHAR(1),
    kilometrage NUMBER,
    CONSTRAINT pk_vehi PRIMARY KEY(n_vehicule));


CREATE TABLE visite(
    n_visite VARCHAR(10),
    n_chantier VARCHAR(10),
    n_vehicule VARCHAR(10),
    n_conducteur VARCHAR(4),
    date_jour DATE,
    kilometres NUMBER,

    CONSTRAINT pk_visite PRIMARY KEY(n_visite),
    CONSTRAINT fk_depl_chantier FOREIGN KEY(n_chantier) REFERENCES Chantier(n_chantier),
    CONSTRAINT fk_depl_vehicule FOREIGN KEY(n_vehicule) REFERENCES Vehicule(n_vehicule),
    CONSTRAINT fk_depl_employe FOREIGN KEY(n_conducteur) REFERENCES Employe(n_emp));

CREATE TABLE transporter(
    n_visite VARCHAR(10),
    n_transporte VARCHAR(4),
    CONSTRAINT fk_transp_visite FOREIGN KEY(n_visite) REFERENCES Visite(n_visite),
    CONSTRAINT fk_transp_employe FOREIGN KEY(n_transporte) REFERENCES Employe(n_emp),
    CONSTRAINT pk_transporteur PRIMARY KEY(n_visite, n_transporte));
